package cn.dhbin.isme.pms.mapper;

import cn.dhbin.isme.pms.domain.dto.SrvOrgDetail;
import cn.dhbin.isme.pms.domain.dto.SrvOrgResponse;
import cn.dhbin.isme.pms.domain.request.SrvOrgRequest;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

@Mapper
public interface HiSrvOrgMapper{
//    List<SrvOrgResponse> getSrvOrgByCode(SrvOrgRequest srvOrgRequest);

    List<SrvOrgResponse> getBdSrv(@Param("itemCodeReq")String itemCodeReq,
                                        @Param("itemNameReq")String itemNameReq,
                                        @Param("beginNum")Integer beginNum,
                                        @Param("endNum")Integer endNum);

    List<SrvOrgDetail> getBdSrvDetail(@Param("itemCode")String itemCode);


}
