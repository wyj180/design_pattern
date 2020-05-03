package com.study.email.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class SampleInfo implements Serializable {
    private static final Long serialVersionUID = 1L;

    private Info info;
    private List<Item> items = new ArrayList<>();

    public SampleInfo(){

    }

    public SampleInfo(Info info, List<Item> items){
        this.info = info;
        this.items = items;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public Info getInfo() {
        return info;
    }

    public void setInfo(Info info) {
        this.info = info;
    }
}
