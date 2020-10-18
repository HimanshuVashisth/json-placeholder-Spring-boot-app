package com.westpac.jsonplaceholderSpringbootapp.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private static String[] notAuthorizablePaths = {
            //swagger white list
            "/swagger-resources",
            "/v2/api-docs",
            "/swagger-ui.html"
    };
    
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable();
    }

}
