package com.tradedepot.springboot.controller;

import com.tradedepot.springboot.models.Delivery;
import com.tradedepot.springboot.models.Response.DeliveryResponse;
import com.tradedepot.springboot.service.TradeDepotService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
@AllArgsConstructor
@Slf4j
public class TradeDepotController {

    private static final Logger logger = LoggerFactory.getLogger(TradeDepotController.class);
    @Autowired
    private final TradeDepotService tradeDepotService;

    @GetMapping(value = "/deliveries", produces = "application/json")
    public ResponseEntity<?> getDeliveries() throws Exception {
        List<Delivery> deliveries = tradeDepotService.getDeliveries();
        logger.info("Received deliveries of size: " + deliveries.size());
        return new ResponseEntity<>(DeliveryResponse.builder().data(deliveries).build(), HttpStatus.OK);
    }

}
