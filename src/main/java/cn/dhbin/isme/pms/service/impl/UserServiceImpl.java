package cn.dhbin.isme.pms.service.impl;

import cn.dhbin.isme.demos.web.User;
import cn.dhbin.isme.pms.domain.dto.LoginTokenDto;
import cn.dhbin.isme.pms.domain.dto.UserDetailDto;
import cn.dhbin.isme.pms.domain.dto.UserPageDto;
import cn.dhbin.isme.pms.domain.request.*;
import cn.dhbin.isme.pms.mapper.UserMapper;
import cn.dhbin.isme.pms.service.UserService;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    @Override
    public LoginTokenDto login(LoginRequest request) {
        return null;
    }

    @Override
    public UserDetailDto detail(Long userId, String roleCode) {
        return null;
    }

    @Override
    public LoginTokenDto switchRole(Long userId, String roleCode) {
        return null;
    }

    @Override
    public void register(RegisterUserRequest request) {

    }

    @Override
    public LoginTokenDto refreshToken() {
        return null;
    }

    @Override
    public void changePassword(ChangePasswordRequest request) {

    }

    @Override
    public Page<UserPageDto> queryPage(UserPageRequest request) {
        return null;
    }

    @Override
    public void removeUser(Long id) {

    }

    @Override
    public void resetPassword(Long userid, updatePasswordRequest request) {

    }

    @Override
    public void addRoles(Long userId, AddUserRoleRequest request) {

    }

    @Override
    public void updateProfile(Long id, UpdateProfileRequest request) {

    }

}
