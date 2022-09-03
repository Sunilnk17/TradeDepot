package com.tradedepot.springboot.Filters;

import com.tradedepot.springboot.models.TokenHolder;
import io.netty.util.internal.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;

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
                response.setContentType("application/json");
                response.getWriter().write("{\"message\": \"Token is mandatory. Please send the valid token to proceed.\"}");
            }


        } finally {
            // Otherwise when a previously used container thread is used, it will have the old token set and
            // if for some reason this filter is skipped, token holder will hold an unreliable value
            this.tokenHolder.clear();
        }
    }
}
