package com.tradedepot.springboot.repository;

import com.tradedepot.springboot.models.Delivery;
import com.tradedepot.springboot.models.Response.TDExternalClientResponse;
import com.tradedepot.springboot.models.TokenHolder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Objects;

@Repository
public class TradeDepotRepository {
    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private TokenHolder tokenHolder;

    @Value("${tdUrl}")
    private String tdUrl;

    public List<Delivery> fetchDeliveries() throws Exception {

        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", tokenHolder.getToken());

        HttpEntity<String> entity = new HttpEntity<String>("parameters", headers);
        try {
            ResponseEntity<TDExternalClientResponse> exchange = restTemplate.exchange(tdUrl, HttpMethod.POST, entity, TDExternalClientResponse.class);
            return Objects.requireNonNull(exchange.getBody()).getData();
        } catch (Exception e) {
            throw new Exception("Something went wrong from External Client side call!");
        }
    }
}
