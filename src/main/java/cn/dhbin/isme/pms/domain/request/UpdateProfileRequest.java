package cn.dhbin.isme.pms.domain.request;

import lombok.Data;

@Data
public class UpdateProfileRequest {
    private Long id;
    private Integer gender;
    private String address;
    private String email;
    private String nickName;
}
