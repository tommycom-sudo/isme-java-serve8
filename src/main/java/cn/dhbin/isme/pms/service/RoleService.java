package cn.dhbin.isme.pms.service;

import cn.dhbin.isme.pms.domain.entity.Role;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

public interface RoleService extends IService<Role> {

    List<Role> findRolesByUserId(Long userId);

}
