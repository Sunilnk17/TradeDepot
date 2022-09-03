package com.tradedepot.springboot.service;

import com.tradedepot.springboot.models.Delivery;
import com.tradedepot.springboot.repository.TradeDepotRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@CacheConfig(cacheNames = {"deliveries"})
public class TradeDepotService {

    @Autowired
    TradeDepotRepository tradeDepotRepository;

    @Cacheable
    public List<Delivery> getDeliveries() {
        return tradeDepotRepository.fetchDeliveries();
    }

}
