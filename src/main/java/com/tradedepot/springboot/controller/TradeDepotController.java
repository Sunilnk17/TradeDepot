package com.tradedepot.springboot.controller;

import com.tradedepot.springboot.models.Delivery;
import com.tradedepot.springboot.models.Response.DeliveryResponse;
import com.tradedepot.springboot.service.TradeDepotService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class TradeDepotController {

    @Autowired
    TradeDepotService tradeDepotService;

    @GetMapping(value = "/deliveries", produces = "application/json")
    public ResponseEntity<?> getDeliveries() {
        List<Delivery> deliveries = tradeDepotService.getDeliveries();
        return new ResponseEntity<>(DeliveryResponse.builder().data(deliveries).build(), HttpStatus.OK);
    }

}
