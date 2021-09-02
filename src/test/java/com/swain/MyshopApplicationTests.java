package com.swain;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;

import com.swain.myshop.entity.User;
import com.swain.myshop.mapper.UserMapper;
import com.swain.myshop.service.UserService;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;

@SpringBootTest
@MapperScan("com.swain.myshop.mapper")
class MyshopApplicationTests {

    @Autowired
    private UserService userService;

    @Test
    public void testMapper(){
    //    System.out.println(userService.save(new User().setId(3L).setName("lisi").setPassword("123").setPhone("1321331312").setCreatedTime(new Date()).setUpdatedTime(new Date()).setIsDeleted(0)));

        System.out.println(userService.list());
    }

}
