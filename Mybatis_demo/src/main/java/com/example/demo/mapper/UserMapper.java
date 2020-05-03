package com.example.demo.mapper;

import com.example.demo.domain.User;
import com.example.demo.domain.UserWithBLOBs;

public interface UserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(UserWithBLOBs record);

    int insertSelective(UserWithBLOBs record);

    UserWithBLOBs selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(UserWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(UserWithBLOBs record);

    int updateByPrimaryKey(User record);
}