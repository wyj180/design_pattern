package com.example.demo.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class User {

    private Integer id;
    private String userName;
    private String passWord;
    private String realName;

    public User(String userName, String passWord, String realName) {
        this.userName = userName;
        this.passWord = passWord;
        this.realName = realName;
    }
}
