package com.atguigu.service;

import com.atguigu.pojo.User;

import java.util.List;

public interface UserService {

    /**
     * 注册用户
     * @param user
     */
    void registUser(User user);

    /**
     * 登录
     * @param user
     * @return
     */
    User login(User user);

    /**
     * 检查用户名是否存在
     * @param username
     * @return 返回true，用户名已存在，返回false，用户名可用
     */
    boolean existsUsername(String username);

    /**
     * 获取全部用户信息
     * @return
     */
    List<User> getAllUser();
}
