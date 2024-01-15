package cn.dhbin.isme.pms.domain.request;

import lombok.Data;

@Data
public class LoginRequest {
    private String username;
    private String password;
    private String captcha;
    private String captchaKey;
    private Boolean isQuick; //????
}
