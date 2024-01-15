package cn.dhbin.isme.pms.domain.request;

import lombok.Data;

import java.util.List;
@Data
public class AddUserRoleRequest {
    private List<Long> roleIds;
}
