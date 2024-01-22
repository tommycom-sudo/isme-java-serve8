package cn.dhbin.isme.pms.domain.dto;


import java.time.LocalDateTime;
import java.util.List;
/*
用户分页数据
 */
public class UserPageDto {
    private Long id;
    private String username;
    private Boolean enable;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;
    private Integer gender;
    private String avatar;
    private String address;
    private String email;
    private List<RoleDto> roles;

}
