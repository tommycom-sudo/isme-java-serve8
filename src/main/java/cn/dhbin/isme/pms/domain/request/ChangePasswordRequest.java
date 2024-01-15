package cn.dhbin.isme.pms.domain.request;

import lombok.Data;

import javax.validation.constraints.NotNull;
@Data
public class ChangePasswordRequest {
    @NotNull(message="旧密码不能为空")
    private String oldPassword;

    @NotNull(message = "新密码不能为空")
    private String newPassword;

}
