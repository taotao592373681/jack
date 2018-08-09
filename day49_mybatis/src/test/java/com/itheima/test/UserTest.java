package com.itheima.test;

import com.itheima.dao.IUserDao;
import com.itheima.user.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class UserTest {
    public static void main(String[] args) throws IOException {
        //1.读取配置文件
        InputStream inputStream = Resources.getResourceAsStream("SqlMapConfig.xml");
        //2.根据读的取配置文件创建SqlSessionFactory
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory sqlSessionFactory = builder.build(inputStream);
        //        //3.创建session
        SqlSession session = sqlSessionFactory.openSession();
        //4.创建dao代理对象
        IUserDao userDao = session.getMapper(IUserDao.class);
        System.out.println(userDao.getClass());
        //5.执行方法
        List<User> list = userDao.findAll();
        for(User user : list){
            System.out.println(user);
        }
        session.close();
        inputStream.close();

    }
}
