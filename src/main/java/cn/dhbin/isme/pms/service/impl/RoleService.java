package cn.dhbin.isme.pms.service.impl;

import cn.dhbin.isme.pms.domain.entity.Role;
import cn.dhbin.isme.pms.mapper.RoleMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class RoleService extends ServiceImpl<RoleMapper, Role> implements cn.dhbin.isme.pms.service.RoleService {
    @Override
    public List<Role> findRolesByUserId(Long userId) {
        return getBaseMapper().findRolesByUserId(userId);
    }
}
