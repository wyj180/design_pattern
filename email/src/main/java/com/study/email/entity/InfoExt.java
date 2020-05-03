package com.study.email.entity;

import java.util.List;

public class InfoExt extends Info {

    private List<Item> items;

    public InfoExt(){

    }

    public InfoExt(String sampleCategory, String odmSupplier, List<Item> items){
        setSample_category(sampleCategory);
        setOdm_supplier(odmSupplier);
        this.items = items;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

}
