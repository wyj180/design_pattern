package com.study.freemarker_demo.entity;

import java.io.Serializable;

public class Info implements Serializable {
    private static final Long serialVersionUID = 1L;

    private String id= "";
    private String create_date= "";
    private String ls_status= "";
    private String sample_category= ""; //样品申请类型(封样类型) *
    private String odm_inhouse= "";     //产品类型
    private String odm_supplier= "";    //供应商名 *
    private String project= "";         //产品(项目)代码 *
    private String part_description= "";         //部件描述
    private String part= "";
    private String fpy= "";
    private String suit_all= "";
    private String color= "";
    private String part_supplier= "";
    private String bug_name= "";
    private String bug_desc= "";
    private String ratio= "";
    private String pic_upload= "";
    private String suit_sku= "";
    private String unsuit_region= "";
    private String expiration_type= "";
    private String expiration= "";
    private String expiration_unit= "";
    private Integer main_number= 0;         //批次自增编码 *

    public Info(){

    }

    public Info(String sample_category, String odm_supplier){
        this.sample_category = sample_category= sample_category;
        this.odm_supplier = odm_supplier= odm_supplier;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCreate_date() {
        return create_date;
    }

    public void setCreate_date(String create_date) {
        this.create_date = create_date;
    }

    public String getLs_status() {
        return ls_status;
    }

    public void setLs_status(String ls_status) {
        this.ls_status = ls_status;
    }

    public String getSample_category() {
        return sample_category;
    }

    public void setSample_category(String sample_category) {
        this.sample_category = sample_category;
    }

    public String getOdm_inhouse() {
        return odm_inhouse;
    }

    public void setOdm_inhouse(String odm_inhouse) {
        this.odm_inhouse = odm_inhouse;
    }

    public String getOdm_supplier() {
        return odm_supplier;
    }

    public void setOdm_supplier(String odm_supplier) {
        this.odm_supplier = odm_supplier;
    }

    public String getProject() {
        return project;
    }

    public void setProject(String project) {
        this.project = project;
    }

    public String getPart_description() {
        return part_description;
    }

    public void setPart_description(String part_description) {
        this.part_description = part_description;
    }

    public String getPart() {
        return part;
    }

    public void setPart(String part) {
        this.part = part;
    }

    public String getFpy() {
        return fpy;
    }

    public void setFpy(String fpy) {
        this.fpy = fpy;
    }

    public String getSuit_all() {
        return suit_all;
    }

    public void setSuit_all(String suit_all) {
        this.suit_all = suit_all;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getPart_supplier() {
        return part_supplier;
    }

    public void setPart_supplier(String part_supplier) {
        this.part_supplier = part_supplier;
    }

    public String getBug_name() {
        return bug_name;
    }

    public void setBug_name(String bug_name) {
        this.bug_name = bug_name;
    }

    public String getBug_desc() {
        return bug_desc;
    }

    public void setBug_desc(String bug_desc) {
        this.bug_desc = bug_desc;
    }

    public String getRatio() {
        return ratio;
    }

    public void setRatio(String ratio) {
        this.ratio = ratio;
    }

    public String getPic_upload() {
        return pic_upload;
    }

    public void setPic_upload(String pic_upload) {
        this.pic_upload = pic_upload;
    }

    public String getSuit_sku() {
        return suit_sku;
    }

    public void setSuit_sku(String suit_sku) {
        this.suit_sku = suit_sku;
    }

    public String getUnsuit_region() {
        return unsuit_region;
    }

    public void setUnsuit_region(String unsuit_region) {
        this.unsuit_region = unsuit_region;
    }

    public String getExpiration_type() {
        return expiration_type;
    }

    public void setExpiration_type(String expiration_type) {
        this.expiration_type = expiration_type;
    }

    public String getExpiration() {
        return expiration;
    }

    public void setExpiration(String expiration) {
        this.expiration = expiration;
    }

    public String getExpiration_unit() {
        return expiration_unit;
    }

    public void setExpiration_unit(String expiration_unit) {
        this.expiration_unit = expiration_unit;
    }

    public Integer getMain_number() {
        return main_number;
    }

    public void setMain_number(Integer main_number) {
        this.main_number = main_number;
    }
}
