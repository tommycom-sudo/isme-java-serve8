package cn.dhbin.isme.pms.mapper;

import cn.dhbin.isme.pms.domain.dto.SrvOrgResponse;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

@Mapper
public interface HiSrvOrgMapperV2 {
//    List<SrvOrgResponse> getSrvOrgByCode(SrvOrgRequest srvOrgRequest);

    List<SrvOrgResponse> getBdSrvByCodeV2(@Param("itemCodeReq")String itemCodeReq, @Param("beginNum")Integer beginNum, @Param("endNum")Integer endNum);

}
