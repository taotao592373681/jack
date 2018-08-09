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

public class Test {
    public static void main(String[] args) throws IOException {
        //读取配置文件
        InputStream inputStream = Resources.getResourceAsStream("SqlMapConfig.xml");
        SqlSessionFactoryBuilder builder=new SqlSessionFactoryBuilder();
        SqlSessionFactory build = builder.build(inputStream);
        SqlSession sqlSession = build.openSession();
        //创建Dao代理对象
        IUserDao userDao = sqlSession.getMapper(IUserDao.class);
        System.out.println(userDao.getClass());
        //执行方法
        List<User> all = userDao.findAll();
        for (User user:all) {
            System.out.println(user);
        }
        sqlSession.close();
        inputStream.close();
    }
}
