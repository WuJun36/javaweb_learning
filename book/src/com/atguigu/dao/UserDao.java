package com.atguigu.dao;

import com.atguigu.pojo.User;

import java.util.List;

public interface UserDao {

    /**
     * 根据用户名查询用户信息
     * @param username 用户名
     * @return 返回null，说明没有这个用户，否则，表明用户存在
     */
    User queryUserByUsername(String username);

    /**
     * 保存用户信息
     * @param user
     * @return
     */
    int saveUser(User user);

    /**
     * 根据用户名和密码查询用户
     * @param username
     * @param password
     * @return 返回为null，表明
     */
    User queryUserByUsernameAndPassword(String username,String password);

    /**
     * 查询全部用户信息
     * @return
     */
    List<User> queryForAllUser();
}
