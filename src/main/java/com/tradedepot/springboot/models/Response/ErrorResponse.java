package com.tradedepot.springboot.models.Response;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Builder
@Getter
@Setter
public class ErrorResponse {

    //RFC Error format

    private final String type;
    private final String title;
    private final String detail;
    private final int statusCode;
}
