package com.example.mianshi01.base01.a_valitile_05;

/**
 * 验证volatile不保证原子性
 */
public class MyData2 {

    /**
     * 共享变量
     */
    volatile int number = 0;

    /**
     * 修改共享变量
     */
    public /*synchronized*/ void addPlusPlus() {
        this.number++;
    }

}
