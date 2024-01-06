package cn.dhbin.isme.pms.domain.dto;
import lombok.Data;

import java.math.BigDecimal;

//服务项目明细
@Data
public class SrvOrgDetail {
    //服务项目费用编码
    private String itemCode;
    //服务项目费用名称
    private String itemName;
    //数量
    private String num;
    //单位
    private String unit;
    //单价
    private String price;
}
