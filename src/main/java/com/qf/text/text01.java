package com.qf.text;

import com.qf.dao.UserDao;
import com.qf.entity.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

public class text01 {
    public static void main(String[] args) throws IOException {
        //读取mybatis-config.xml文件
        InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
        //初始化mybatis,创建SqlSessionFactory类的实例
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
        //创建session实例
        SqlSession sqlSession = sqlSessionFactory.openSession();
        /*
         * 接下来在这里做很多事情,到目前为止,目的已经达到得到了SqlSession对象.通过调用SqlSession里面的方法,
         * 可以测试MyBatis和Dao层接口方法之间的正确性
         */
        UserDao userDao = sqlSession.getMapper(UserDao.class);
        User user = userDao.selectUserById(1);
        User user1 = userDao.selectUserByIdAndPassword(1,"123");
        User user2 = userDao.selectUserByIdA(1);
        User user3 = userDao.selectUserByIdB(1, "123");
        Map map = new HashMap();
        map.put("id",1);
        map.put("password","123");
        User user4 = userDao.selectUserByMap(map);
        User user11 = new User();
        user11.setId(1);
        user11.setPassword("123");
        User user5 = userDao.selectUserByUser(user11);
        System.out.println(user);
        System.out.println("==========================");
        System.out.println(user1);
        System.out.println("==========================");
        System.out.println(user2);
        System.out.println("==========================");
        System.out.println(user3);
        System.out.println("==========================");
        System.out.println(user4);
        System.out.println("==========================");
        System.out.println(user5);

    }
}
