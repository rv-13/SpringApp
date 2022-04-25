package com.example.springsecurityauthserver.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;

@Configuration
@EnableAuthorizationServer
public class AuthServerConfig extends AuthorizationServerConfigurerAdapter {
    private final PasswordEncoder passwordEncoder;

    @Value("${oauth.clientId}")
    private String ClientID;

    @Value("${oauth.clientSecret}")
    private String ClientSecret;

    @Value("${oauth.redirectUris}")
    private String RedirectURLs;

    public AuthServerConfig(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    //This overridden function used for Authorizing Server detail
    @Override
    public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {
        security.tokenKeyAccess("permitAll()").checkTokenAccess("isAuthenticated()");
    }
    //This overridden function used for Authorizing Server with client details
    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        //Using InMemory instead DataBase , so no DB Connection
        clients.inMemory().withClient(ClientID).secret(passwordEncoder.encode(ClientSecret)).authorizedGrantTypes("authorization_code").
                scopes("user_info").autoApprove(true).redirectUris(RedirectURLs);


    }
}