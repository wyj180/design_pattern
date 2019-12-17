package com.study.ppt_demo.entity;

public class StringKeyVo {

    private String name;

    private Long value;

    public String getName() {
        return name;
    }

    public StringKeyVo() {
        super();
    }

    public StringKeyVo(String name, Long value) {
        super();
        this.name = name;
        this.value = value;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getValue() {
        return value;
    }

    public void setValue(Long value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "StringKeyVo [name=" + name + ", value=" + value + "]";
    }

}
