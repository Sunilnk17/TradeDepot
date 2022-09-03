package com.tradedepot.springboot.service;

import com.tradedepot.springboot.models.Delivery;
import com.tradedepot.springboot.repository.TradeDepotRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TradeDepotService {

    @Autowired
    TradeDepotRepository tradeDepotRepository;

    public List<Delivery> getDeliveries() throws Exception {
        return tradeDepotRepository.fetchDeliveries();
    }

}
