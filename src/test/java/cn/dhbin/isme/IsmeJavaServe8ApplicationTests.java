package cn.dhbin.isme;


import cn.dhbin.isme.pms.domain.entity.User;
import cn.dhbin.isme.pms.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import org.springframework.util.Assert;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

@SpringBootTest

class IsmeJavaServe8ApplicationTests {

    @Test
    void contextLoads() {
    }
    @Autowired
    private UserMapper userMapper;

 //   @Test
//    public void testSelect() {
//        System.out.println(("----- selectAll method test ------"));
//        List<User> userList = userMapper.selectList(null);
//        List<Map<String,Object>> mapList = new ArrayList<>();
//        mapList = userMapper.getUserList();
//        for (User u : userList) {
//            System.out.println(u);
//        }
//        //Assert.isTrue(1 == userList.size(), "");
//        userList.forEach(System.out::println);
//    }
    public static void main(String[] args) {
        String s = "hello";
        String t = s;
        s = "world";
        System.out.println(t); // t是"hello"还是"world"?
        List<Integer> integers = Arrays.asList(-1,2,3,4,5);


        System.out.printf(String.valueOf(Math.abs(-1)));
    }
}
