package com.atguigu.test;

import com.atguigu.pojo.User;
import com.atguigu.service.UserService;
import com.atguigu.service.impl.UserServiceImpl;
import junit.framework.TestCase;

public class UserServiceTest extends TestCase {

    UserService userService = new UserServiceImpl();

    public void testRegistUser() {
        User user = new User(1,"wayv","wayv","wayv@gmail.com");
        userService.registUser(user);
    }

    public void testLogin() {
        User user = userService.login(new User(1, "wayv", "wayv", "wayv@gmail.com"));
        System.out.println(user);
    }

    public void testExistsUsername() {
        System.out.println(userService.existsUsername("add"));
    }
}