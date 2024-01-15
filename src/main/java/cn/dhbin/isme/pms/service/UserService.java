package cn.dhbin.isme.pms.service;

import cn.dhbin.isme.pms.domain.dto.LoginTokenDto;
import cn.dhbin.isme.pms.domain.dto.UserDetailDto;
import cn.dhbin.isme.pms.domain.dto.UserPageDto;
import cn.dhbin.isme.pms.domain.entity.User;
import cn.dhbin.isme.pms.domain.request.*;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;

public interface UserService extends IService<User> {
    LoginTokenDto login(LoginRequest request);

    UserDetailDto detail(Long userId, String roleCode);

    LoginTokenDto switchRole(Long userId, String roleCode);

    //注册用户
    void register(RegisterUserRequest request);

    //刷新token
    LoginTokenDto refreshToken();

    //修改密码
    void changePassword(ChangePasswordRequest request);

    //分页查询
    Page<UserPageDto> queryPage(UserPageRequest request);

    //删除用户，不能删除自己
    void removeUser(Long id);
    //重置密码
    void resetPassword(Long userid,   updatePasswordRequest request);

    //给用户分配角色
    void addRoles(Long userId, AddUserRoleRequest request);

    //更新用户信息
    void updateProfile(Long id, UpdateProfileRequest request);




}
