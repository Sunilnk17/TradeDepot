package com.tradedepot.springboot;

import com.tradedepot.springboot.Filters.TokenFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import javax.servlet.Filter;

@SpringBootApplication
@EnableCaching
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
