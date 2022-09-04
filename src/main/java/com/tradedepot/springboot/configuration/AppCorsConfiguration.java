package com.tradedepot.springboot.configuration;


<<<<<<< HEAD
=======
import org.springframework.beans.factory.annotation.Value;
>>>>>>> e4056e6 (Fixes to CORS endpoints)
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import java.util.Collections;

@Configuration
public class AppCorsConfiguration {
<<<<<<< HEAD
=======

    @Value("${tdFrontEndUrl}")
    private String tdFrontEndUrl;

>>>>>>> e4056e6 (Fixes to CORS endpoints)
    @Bean
    public FilterRegistrationBean corsFilter() {
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        CorsConfiguration config = new CorsConfiguration();
        config.setAllowCredentials(true);
<<<<<<< HEAD
        config.setAllowedOriginPatterns(Collections.singletonList("https://trade-depot-frontend-app.azurewebsites.net"));
=======
        config.setAllowedOriginPatterns(Collections.singletonList(tdFrontEndUrl));
>>>>>>> e4056e6 (Fixes to CORS endpoints)
        config.addAllowedHeader("*");
        config.addAllowedMethod("*");
        source.registerCorsConfiguration("/**", config);
        FilterRegistrationBean bean = new FilterRegistrationBean(new CorsFilter(source));
        bean.setOrder(0);
        return bean;
    }
}
