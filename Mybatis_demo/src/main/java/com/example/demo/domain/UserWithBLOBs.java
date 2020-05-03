package com.example.demo.domain;

public class UserWithBLOBs extends User {
    private String username;

    private String password;

    public UserWithBLOBs(String userName, String passWord, String realName) {
        this.username = userName;
        this.password = passWord;
        this.username = realName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }
}