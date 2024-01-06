package cn.dhbin.isme;


import cn.dhbin.isme.pms.domain.entity.User;
import cn.dhbin.isme.pms.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

import java.util.List;

@SpringBootTest
class IsmeJavaServe8ApplicationTests {

    @Test
    void contextLoads() {
    }
    @Autowired
    private UserMapper userMapper;

    @Test
    public void testSelect() {
        System.out.println(("----- selectAll method test ------"));
        List<User> userList = userMapper.selectList(null);

        Assert.isTrue(1 == userList.size(), "");
        userList.forEach(System.out::println);
    }
}
