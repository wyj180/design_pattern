package com.geely.design.principle.singleresponsibility;

/**
 * Created by geely
 */
public class Bird {
    // 非单一职责，根据鸟的名称判断移动方式
    public void mainMoveMode(String birdName) {
        if ("鸵鸟".equals(birdName)) {
            System.out.println(birdName + "用脚走");
        } else {
            System.out.println(birdName + "用翅膀飞");
        }
    }
}
