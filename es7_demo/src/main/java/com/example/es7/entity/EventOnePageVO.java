package com.example.es7.entity;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.math.BigInteger;
import java.util.Date;

/**
 * 功能描述：<code>EventOnePageVO</code>
 * </p>
 *
 * @author wangyj
 * @version [1.0.0], 2019/8/27 13:59
 */
@Getter
@Setter
@ToString
public class EventOnePageVO {

    private BigInteger id;

    private String no;

    private String product;

    private String supplier;

    private String category;

    // private String partDescription;

    private String pe;

    private String inhouse;

    private String overall_status;

    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    private Date gmt_create;

}
