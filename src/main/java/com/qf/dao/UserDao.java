package com.qf.dao;

import com.qf.entity.User;
import org.apache.ibatis.annotations.Param;

import java.nio.channels.Pipe;
import java.util.Map;

public interface UserDao {
    public User selectUserById(int id);
    public User selectUserByIdAndPassword(int id,String password);
    public User selectUserByIdA(int id);
    public User selectUserByIdB(@Param("id")int id,@Param("password")String password);
    public User selectUserByMap(Map map);
    public User selectUserByUser(User user);

}
