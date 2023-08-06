package com.mayikt.test;

import com.mayikt.entity.UserEntity;
import com.mayikt.mapper.UserMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class Test01 {
    public static void main(String[] args) throws IOException {
        // 1.读取加载mybatis-config.xml
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        // 2.创建 sqlSessionFactory
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        // 3.获取 sqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();
//        // 4.根据 mapper id=getByAllUsers 执行该s  ql 语句 通过  sql语句得到我们的对象 orm
//        List<UserEntity> userEntitys = sqlSession.selectList("userMapper.getByUsersAll", UserEntity.class);
//        System.out.println(userEntitys);
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        List<UserEntity> users = userMapper.getByUsersAll();
        System.out.println(users);
        sqlSession.close();
    }
}
