package com.example.demo.mapper;

import com.example.demo.entity.User;

// 在启动类中写了 @MapperScan("com.example.demo.mapper") 之后，这里就不用写@Repository了
public interface OldUserMapper {
    User sel(Integer id);
}
