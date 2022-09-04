package com.tradedepot.springboot.Filters;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.tradedepot.springboot.models.Response.ErrorResponse;
import com.tradedepot.springboot.models.TokenHolder;
import io.netty.util.internal.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class TokenFilter implements Filter {

    @Autowired
    TokenHolder tokenHolder;

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        HttpServletRequest request = (HttpServletRequest) servletRequest;
        String token = request.getHeader("Authorization");
        try {
            if (!StringUtil.isNullOrEmpty(token)) {
                this.tokenHolder.setToken(token);
                filterChain.doFilter(servletRequest, servletResponse);
            } else {
                HttpServletResponse response = (HttpServletResponse) servletResponse;
                response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
                response.setContentType(MediaType.APPLICATION_JSON_VALUE);

                ErrorResponse errorResponse = ErrorResponse
                        .builder()
                        .type("https://trade-depot.com/#invalid-token-error")
                        .title("Invalid Token")
                        .statusCode(HttpStatus.BAD_REQUEST.value())
                        .detail("Token is mandatory. Please send the valid token to proceed").build();

                response.getWriter().write(new ObjectMapper().writeValueAsString(errorResponse));
            }


        } finally {
            // Otherwise when a previously used container thread is used, it will have the old token set and
            // if for some reason this filter is skipped, token holder will hold an unreliable value
            this.tokenHolder.clear();
        }
    }
}
