package com.mayikt.mapper;

import com.mayikt.entity.UserEntity;

import java.util.List;

public interface UserMapper {
    /**
     * 调用 UserMapper.getByUserAll 方法时 自动查找 userMapper.xml getByUserAll 的 sql 语句
     * sqi 语句的id值与接口方法名称对应
     */
    List<UserEntity> getByUsersAll();
}
