package cn.dhbin.isme.pms.service.impl;

import cn.dev33.satoken.stp.SaLoginConfig;
import cn.dev33.satoken.stp.SaTokenInfo;
import cn.dhbin.isme.common.auth.SaTokenConfigure;
import cn.dhbin.isme.common.exception.BizException;
import cn.dhbin.isme.common.response.BizResponseCode;
import cn.dhbin.isme.pms.domain.dto.LoginTokenDto;
import cn.dhbin.isme.pms.domain.dto.UserDetailDto;
import cn.dhbin.isme.pms.domain.dto.UserPageDto;
import cn.dhbin.isme.pms.domain.entity.Role;
import cn.dhbin.isme.pms.domain.entity.User;
import cn.dhbin.isme.pms.domain.request.*;
import cn.dhbin.isme.pms.mapper.UserMapper;
import cn.dhbin.isme.pms.service.CaptchaService;
import cn.dhbin.isme.pms.service.RoleService;
import cn.dhbin.isme.pms.service.UserService;
import cn.hutool.core.util.StrUtil;
import cn.hutool.crypto.digest.BCrypt;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import cn.dev33.satoken.stp.StpUtil;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
    private final CaptchaService captchaService;

    private final RoleService roleService;
    @Override
    public LoginTokenDto login(LoginRequest request) {
        User user = lambdaQuery().eq(User::getUsername, request.getUsername()).one();
        if (user == null){
            throw new BizException(BizResponseCode.ERR_10002);
        }
        // 预览环境下可快速登录，不用验证码
        //if (Boolean.TRUE.equals(request.getIsQuick()) && Boolean.TRUE.equals())4
        if (StrUtil.isBlank(request.getCaptchaKey())
            || !captchaService.verify(request.getCaptchaKey(), request.getCaptcha())) {
            throw new BizException(BizResponseCode.ERR_10003);
        }
        return login(request, user);
    }

    private LoginTokenDto login(LoginRequest request, User user) {
        boolean checkPw = BCrypt.checkpw(request.getPassword(), user.getPassword());
        if (checkPw) {
            // 查询用户的角色
            List<Role> roles = roleService.findRolesByUserId(user.getId());
            return generateToken(user, roles, roles.isEmpty() ? "" : roles.get(0).getCode());  //JDK21 . role.getFirst().getCode())
        } else {
            throw new BizException(BizResponseCode.ERR_10002);
        }
    }

    private LoginTokenDto generateToken(User user, List<Role> roles, String currentRoleCode) {
        //密码验证成功
        StpUtil.login(user.getId(),
                SaLoginConfig.setExtra(SaTokenConfigure.JWT_USER_ID_KEY, user.getId())
                        .setExtra(SaTokenConfigure.JWT_USERNAME_KEY, user.getUsername())
                        .setExtra(SaTokenConfigure.JWT_CURRENT_ROLE_KEY, currentRoleCode)
                        .setExtra(SaTokenConfigure.JWT_ROLE_LIST_KEY, roles));
        SaTokenInfo tokenInfo = StpUtil.getTokenInfo();
        LoginTokenDto dto = new LoginTokenDto();
        dto.setAccessToken(tokenInfo.getTokenValue());
        return dto;
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
