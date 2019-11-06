package com.wss.sso.server.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;

/**
 * @Description sso授权服务器配置
 * @Author wangshasha
 * @Date 2019-11-05 10:25
 * @Version
 */

@Configuration
@EnableAuthorizationServer
public class AuthServerConfig extends AuthorizationServerConfigurerAdapter {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Override
    public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {

        security.tokenKeyAccess("permitAll()").checkTokenAccess("isAuthenticated()");

    }

    //两个客户端 使用授权码方式
    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        clients.inMemory()
                .withClient("clientId")
                .secret("clientSecret")
                .authorizedGrantTypes("authorization_code")
                .scopes("user_info")
                .autoApprove(false)
                .redirectUris("http://localhost:8081/login")
                .accessTokenValiditySeconds(10)
                .and()
                .withClient("clientId2")
                .secret("clientSecret2")
                .authorizedGrantTypes("authorization_code")
                .scopes("user_info")
                .autoApprove(false)
                .redirectUris("http://localhost:8082/login")
                .accessTokenValiditySeconds(10);
    }

    //使用简单的内存方式发放令牌
    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
        endpoints.authenticationManager(authenticationManager);
    }

    //令牌发放采用jwt
//    @Bean
//    public TokenStore tokenStore() {
//        return new JwtTokenStore(jwtAccessTokenConverter());
//    }
//
//    @Bean
//    public JwtAccessTokenConverter jwtAccessTokenConverter() {
//
//        JwtAccessTokenConverter jwtAccessTokenConverter = new JwtAccessTokenConverter();
//
//        jwtAccessTokenConverter.setSigningKey("sign");
//
//        return jwtAccessTokenConverter;
//    }
}
