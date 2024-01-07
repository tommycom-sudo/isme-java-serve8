package cn.dhbin.isme.pms.controller;
import cn.dhbin.isme.pms.mapper.HiSrvOrgMapper;
import cn.dhbin.isme.pms.domain.dto.SrvOrgDetail;
import cn.dhbin.isme.pms.domain.dto.SrvOrgResponse;
import cn.dhbin.isme.pms.domain.request.SrvOrgRequest;
import cn.hutool.core.util.ObjectUtil;
//import com.baomidou.mybatisplus.toolkit.StringUtils;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import lombok.RequiredArgsConstructor;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/tj")
@RequiredArgsConstructor
@Component
public class TJController {
    @PostMapping("/getSrvDetail1")
    @MetricTime("getSrvDetail1")
    public List<SrvOrgResponse> getSrvDetail1(@RequestBody @Validated SrvOrgRequest req){
//        SrvOrgResponse  res  = new SrvOrgResponse();
//        res.setItem("2222");
//        res.setText("bbbbb");
        return getOrgSrv1(req);

    }
    @Autowired

    private HiSrvOrgMapper hiSrvOrgMapper;

    public List<SrvOrgResponse> getOrgSrv1(SrvOrgRequest srvOrgRequest){
        List<SrvOrgResponse> list = new ArrayList<>();
        Map<String,SrvOrgResponse> responseMap = new HashMap<>();
        Map<String, SrvOrgDetail> responseDetMap = new HashMap<>();
        String itemCodeReq = srvOrgRequest.getItemCode();
        String itemNameReq = ObjectUtil.isEmpty(srvOrgRequest.getItemName())?"":srvOrgRequest.getItemName() + "%";
        Integer currentPageReq = ObjectUtil.isEmpty(srvOrgRequest.getCurrentPage())?0:srvOrgRequest.getCurrentPage();
        Integer limitReq = ObjectUtil.isEmpty(srvOrgRequest.getLimit())?-1:srvOrgRequest.getLimit();
        Integer beginNum = (currentPageReq == 1 || currentPageReq==0)?1:(currentPageReq - 1) * (limitReq + 1);
        Integer endNum =  currentPageReq * limitReq;
        List<Map<String,Object>> mapList = new ArrayList<>();
        if (StringUtils.isNotEmpty(itemCodeReq)&&!"".equals(itemCodeReq)){
            mapList = hiSrvOrgMapper.getBdSrvByCode(itemCodeReq,beginNum,endNum);
        }else if (StringUtils.isNotEmpty(itemNameReq)&&!"".equals(itemNameReq)){
            mapList = hiSrvOrgMapper.getBdSrvByName(itemNameReq,beginNum,endNum);
        }else {
            mapList = hiSrvOrgMapper.getBdSrvByCode("",beginNum,endNum);
        }
        if (mapList!=null){
            for (Map<String,Object> map:mapList){
                String item = map.get("ID_SRV").toString();
                SrvOrgResponse srvOrgResponse = responseMap.get(item);
                if (srvOrgResponse == null){
                    srvOrgResponse = new SrvOrgResponse();
                    srvOrgResponse.setItem(item);
                    srvOrgResponse.setText(map.get("NA").toString());
                    srvOrgResponse.setSrvOrgDetails(new ArrayList<>());
                    list.add(srvOrgResponse);
                    responseMap.put(item,srvOrgResponse);
                }
                List<Map<String,Object>> detailMap = hiSrvOrgMapper.getBdSrvDetail(item);
                for (Map<String,Object> map1:detailMap){
                    String itemCode = map1.get("ITEMCODE").toString();
                    SrvOrgDetail srvOrgDetail = responseDetMap.get(itemCode);
                    if (srvOrgDetail==null){
                        srvOrgDetail = new SrvOrgDetail();
                        srvOrgDetail.setItemCode(itemCode);
                        srvOrgDetail.setItemName(map1.get("ITEMNAME").toString());
                        srvOrgDetail.setNum(map1.get("NUM").toString());
                        srvOrgDetail.setUnit(map1.get("UNIT").toString());
                        srvOrgDetail.setPrice(map1.get("PRICE").toString());
                        srvOrgResponse.getSrvOrgDetails().add(srvOrgDetail);
                        responseDetMap.put(itemCode,srvOrgDetail);
                    }
                }
            }
        }
        return list;
    }
}
