package com.example.spring.security.client.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {


    //Authenticate and permitall for the antMatchers url patterns we are defining.
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.antMatcher("/**").authorizeRequests().
                antMatchers("/","/login**").permitAll().anyRequest().authenticated().and().oauth2Login();

    }
}
