package cn.dhbin.isme.pms.domain.request;

import cn.dhbin.isme.common.request.PageRequest;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper= true)
public class UserPageRequest extends PageRequest {
    private String username;
    private Integer gender;

    private Integer role;
    private Boolean enable;

}
