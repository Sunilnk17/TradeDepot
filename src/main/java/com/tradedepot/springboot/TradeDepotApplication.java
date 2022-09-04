package com.tradedepot.springboot;

import com.tradedepot.springboot.Filters.TokenFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.client.RestTemplate;

import javax.servlet.Filter;

@SpringBootApplication
public class TradeDepotApplication {

    public static void main(String[] args) {
        SpringApplication.run(TradeDepotApplication.class, args);
    }

    @Bean
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }

    @Bean
    public Filter tokenFilter() {
        return new TokenFilter();
    }

}
