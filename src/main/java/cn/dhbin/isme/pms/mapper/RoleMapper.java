package cn.dhbin.isme.pms.mapper;

import cn.dhbin.isme.pms.domain.entity.Role;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface RoleMapper extends BaseMapper<Role> {
    List<Role> findRolesByUserId(@Param("userid") Long userId);
}
