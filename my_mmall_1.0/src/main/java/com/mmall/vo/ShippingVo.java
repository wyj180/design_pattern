package com.mmall.vo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * 收获地址Vo
 */
@Getter
@Setter
@ToString
public class ShippingVo {
    private String receiverName;

    private String receiverPhone;

    private String receiverMobile;

    private String receiverProvince;

    private String receiverCity;

    private String receiverDistrict;

    private String receiverAddress;

    private String receiverZip;

}
