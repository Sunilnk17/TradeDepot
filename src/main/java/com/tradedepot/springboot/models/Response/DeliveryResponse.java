package com.tradedepot.springboot.models.Response;

import com.tradedepot.springboot.models.Delivery;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Builder
public class DeliveryResponse {
    private final List<Delivery> data;
}
