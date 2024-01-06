package cn.dhbin.isme.pms.domain.dto;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class SrvOrgResponse {
    //服务项目编码
    private String item;
    //服务项目名称
    private String text;
    //
    List<SrvOrgDetail> srvOrgDetails = new ArrayList<>();
}
