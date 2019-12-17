package com.geely.design.principle.singleresponsibility;

/**
 * Created by geely
 */
// 单一职责原则在方法中的使用，即每个方法都只做一件事
public class Method {
    // // 非单一职责, 更新两个字段
    private void updateUserInfo(String userName, String address) {
        userName = "geely";
        address = "beijing";
    }

    // 非单一职责
    private void updateUserInfo(String userName, String... properties) {
        userName = "geely";
//        address = "beijing";
    }

    // 单一职责，只更新一个字段
    private void updateUsername(String userName) {
        userName = "geely";
    }

    // 单一职责，只更新一个字段
    private void updateUserAddress(String address) {
        address = "beijing";
    }

    // 非单一职责，根据传入的参数做不同的操作
    private void updateUserInfo(String userName, String address, boolean bool) {
        if (bool) {
            //todo something1
        } else {
            //todo something2
        }
        userName = "geely";
        address = "beijing";
    }
}
