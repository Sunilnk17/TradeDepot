package com.tradedepot.springboot.models;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Getter
@Setter
@Component
public class TokenHolder {
    private String token;

    public void clear() {
        this.token = null;
    }

}
