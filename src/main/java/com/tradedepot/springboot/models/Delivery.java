package com.tradedepot.springboot.models;

import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;
import java.time.Instant;

@Getter
@Setter
public class Delivery {
    private String id;
    private String trackingNumber;
    private String cannoteNumber;
    private String orderCompany;
    private String orderShippingFee;
    private String orderPostcodeFrom;
    private String orderRegionFrom;
    private String orderPostcodeTo;
    private String orderRegionTo;
    private Double orderCbm;
    private Double orderWeight;
    private Double orderValue;
    private Double orderDistance;
    private String orderType;
    private Timestamp orderTime;
    private Timestamp createTime;
    private Integer isDeleted;
    private Integer isSuccess;
    private String shipStatus;
    private Timestamp shipStatusUpdateTime;
    private String invoiceid;
    private String storeid;

    public Delivery() {
    }
}
