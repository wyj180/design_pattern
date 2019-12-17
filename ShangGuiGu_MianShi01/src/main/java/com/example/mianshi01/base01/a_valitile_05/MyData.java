package com.example.mianshi01.base01.a_valitile_05;

public class MyData {

    /**
     * 共享变量
     */
    /*volatile*/ int number = 0;

    /**
     * 修改共享变量
     */
    public void addTo60() {
        this.number = 60;
    }

}
