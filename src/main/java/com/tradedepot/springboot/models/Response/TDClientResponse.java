package com.tradedepot.springboot.models.Response;

import com.tradedepot.springboot.models.Delivery;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class TDClientResponse {

    private Boolean success;
    private int code;
    private String message;
    private List<Delivery> data;

    public TDClientResponse() {
    }
}
