package com.atguigu.test;

import com.atguigu.dao.UserDao;
import com.atguigu.dao.impl.UserDaoImpl;
import com.atguigu.pojo.User;
import junit.framework.TestCase;

public class UserDaoImplTest extends TestCase {
    UserDao dao = new UserDaoImpl();

    public void testQueryUserByUsername() {
        String username = "admin";
        User user = dao.queryUserByUsername(username);
        if (user != null) System.out.println("用户已存在");
        else System.out.println("用户名不存在");
    }

    public void testQueryUserByUsernameAndPassword() {
        String username = "admin";
        String password = "admin12";
        User user = dao.queryUserByUsernameAndPassword(username, password);
        if (user != null) System.out.println("登录成功");
        else System.out.println("用户名或密码错误");
    }

    public void testSaveUser() {
        User user = new User(1, "admin", "Jaemin", "Jaemin@gamail.com");
        int insertCount = dao.saveUser(user);
        if (insertCount > 0) System.out.println("保存成功");
        else System.out.println("保存失败");
    }
}