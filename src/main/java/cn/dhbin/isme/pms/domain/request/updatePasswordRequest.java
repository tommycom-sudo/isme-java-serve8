package cn.dhbin.isme.pms.domain.request;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;


@Data
public class updatePasswordRequest {
    @NotBlank(message="密码不能为空")
    @Length(min = 6, max = 20 , message = "密码长度必须大于6和20之间")
    private String password;
}
