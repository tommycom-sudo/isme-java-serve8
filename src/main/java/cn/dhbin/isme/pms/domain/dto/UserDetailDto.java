package cn.dhbin.isme.pms.domain.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public class UserDetailDto {
    private Long id;
    private String username;
    private Boolean enable;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;  //??? oracle是自动更新，SQLSERVER
    private RoleDto currentRole;
    private ProfileDto profile;
    private List<RoleDto> roles;


}
