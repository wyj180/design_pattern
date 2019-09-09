package com.example.demo.entity.queryParam;

import lombok.Data;

@Data
public class EventListPageQuery extends BasePageQuery {
    private String key;

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }
}