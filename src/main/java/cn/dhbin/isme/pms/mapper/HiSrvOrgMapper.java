package cn.dhbin.isme.pms.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

@Mapper
public interface HiSrvOrgMapper {
//    List<SrvOrgResponse> getSrvOrgByCode(SrvOrgRequest srvOrgRequest);

    List<Map<String,Object>> getBdSrvByCode(@Param("itemCodeReq")String itemCodeReq,@Param("beginNum")Integer beginNum,@Param("endNum")Integer endNum);

    List<Map<String,Object>> getBdSrvByName(@Param("itemNameReq")String itemNameReq,@Param("beginNum")Integer beginNum,@Param("endNum")Integer endNum);

    List<Map<String,Object>> getBdSrvDetail(@Param("itemCode")String itemCode);
}
