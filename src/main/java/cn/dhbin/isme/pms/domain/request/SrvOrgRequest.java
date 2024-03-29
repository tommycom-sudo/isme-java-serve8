package cn.dhbin.isme.pms.domain.request;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Data;

@Data   //. PropertyNamingStrategyBase，KebabCaseStrategy, LowerCaseStrategy(全小写), SnakeCaseStrategy??
public class SrvOrgRequest {
    //服务项目编码
    private String itemCode;

    //服务项目名称
    private String itemName;

    //当前页
    private Integer currentPage;

    //每页返回记录条数
    private Integer limit;

    private String idTet;
}
