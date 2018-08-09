package com.itheima.dao;

import com.itheima.user.User;

import java.util.List;

public interface IUserDao {
    List<User> findAll();
}

