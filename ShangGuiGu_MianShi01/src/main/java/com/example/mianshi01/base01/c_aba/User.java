package com.example.mianshi01.base01.c_aba;

class User {
    String userName;
    int age;

    public User(String userName, int age) {
        this.userName = userName;
        this.age = age;
    }

    @Override
    public String toString() {
        return "User [userName=" + userName + ", age=" + age + "]";
    }
}
