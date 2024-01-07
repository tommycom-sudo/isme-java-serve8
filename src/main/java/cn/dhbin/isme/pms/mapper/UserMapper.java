package cn.dhbin.isme.pms.mapper;

import cn.dhbin.isme.pms.domain.entity.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
//import com.baomidou.mybatisplus.mapper.BaseMapper;

import java.util.List;
import java.util.Map;

public interface UserMapper extends BaseMapper<User> {

    //@Select("SELECT * FROM  hi_bd_srv")
    List<Map<String,Object>> getUserList();

}
