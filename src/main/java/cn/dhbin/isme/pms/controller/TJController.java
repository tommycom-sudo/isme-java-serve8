package cn.dhbin.isme.pms.controller;
import cn.dhbin.isme.pms.mapper.HiSrvOrgMapper;
import cn.dhbin.isme.pms.domain.dto.SrvOrgDetail;
import cn.dhbin.isme.pms.domain.dto.SrvOrgResponse;
import cn.dhbin.isme.pms.domain.request.SrvOrgRequest;
import cn.dhbin.isme.pms.mapper.HiSrvOrgMapperV2;
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
    @PostMapping("/getSrvDetail")
    @MetricTime("getSrvDetail1")
    public List<SrvOrgResponse> getSrvDetail(@RequestBody @Validated SrvOrgRequest req){

        return getOrgSrv(req);

    }

    @PostMapping("/getSrvDetailV2")
    @MetricTime("getSrvDetailv2")
    public List<SrvOrgResponse> getSrvDetailv2(@RequestBody @Validated SrvOrgRequest req){

        return getOrgSrv2(req);

    }
    @Autowired
    private HiSrvOrgMapper hiSrvOrgMapper;

    public List<SrvOrgResponse> getOrgSrv(SrvOrgRequest srvOrgRequest){
        String itemNameReq = ObjectUtil.isEmpty(srvOrgRequest.getItemName())?"":srvOrgRequest.getItemName() + "%";
        Integer currentPageReq = ObjectUtil.isEmpty(srvOrgRequest.getCurrentPage())?0:srvOrgRequest.getCurrentPage() ;
        Integer limitReq = ObjectUtil.isEmpty(srvOrgRequest.getLimit())? -1:srvOrgRequest.getLimit();
        List<SrvOrgResponse> mapList;
        mapList = hiSrvOrgMapper.getBdSrv( srvOrgRequest.getItemCode(),
                itemNameReq,
                currentPageReq, limitReq);
        return mapList;
    }

    @Autowired
    private HiSrvOrgMapperV2 hiSrvOrgMapperV2;

    public List<SrvOrgResponse> getOrgSrv2(SrvOrgRequest srvOrgRequest){
        //String itemCodeReq = srvOrgRequest.getItemCode();
        String itemNameReq = ObjectUtil.isEmpty(srvOrgRequest.getItemName())?"":srvOrgRequest.getItemName() + "%";
        Integer currentPageReq = ObjectUtil.isEmpty(srvOrgRequest.getCurrentPage())?0:srvOrgRequest.getCurrentPage();
        Integer limitReq = ObjectUtil.isEmpty(srvOrgRequest.getLimit())?-1:srvOrgRequest.getLimit();
        Integer beginNum = (currentPageReq == 1 || currentPageReq==0)?1:(currentPageReq - 1) * (limitReq + 1);
        Integer endNum =  currentPageReq * limitReq;
        List<SrvOrgResponse> mapList;
        mapList = hiSrvOrgMapperV2.getBdSrvByCodeV2( srvOrgRequest.getItemCode(),
                    itemNameReq,
                    beginNum,endNum);
        return mapList;
    }
}
