package com.qf.dao;

import com.qf.entity.User;

import java.nio.channels.Pipe;

public interface UserDao {
    public User selectUserById(int id);
    public User selectUserByIdAndPassword(int id,String password);
    public User selectUserByIdA(int id);
}
