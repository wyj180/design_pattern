package com.lenovo.cd.mf.authcenter.domain;

import java.math.BigDecimal;
import java.util.Date;

public class AcDictItem {
    private Integer id;

    private String realmkey;

    private Integer dictid;

    private String itemKey;

    private String itemValue;

    private String description;

    private BigDecimal ordering;

    private Integer state;

    private Date created;

    private Date lastmodified;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRealmkey() {
        return realmkey;
    }

    public void setRealmkey(String realmkey) {
        this.realmkey = realmkey == null ? null : realmkey.trim();
    }

    public Integer getDictid() {
        return dictid;
    }

    public void setDictid(Integer dictid) {
        this.dictid = dictid;
    }

    public String getItemKey() {
        return itemKey;
    }

    public void setItemKey(String itemKey) {
        this.itemKey = itemKey == null ? null : itemKey.trim();
    }

    public String getItemValue() {
        return itemValue;
    }

    public void setItemValue(String itemValue) {
        this.itemValue = itemValue == null ? null : itemValue.trim();
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    public BigDecimal getOrdering() {
        return ordering;
    }

    public void setOrdering(BigDecimal ordering) {
        this.ordering = ordering;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Date getLastmodified() {
        return lastmodified;
    }

    public void setLastmodified(Date lastmodified) {
        this.lastmodified = lastmodified;
    }
}