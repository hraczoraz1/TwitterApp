package com.tts.TwitterApp.Controllers;

import javax.inject.Inject;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.social.connect.ConnectionFactoryLocator;
import org.springframework.social.connect.support.ConnectionFactoryRegistry;
import org.springframework.social.twitter.api.impl.TwitterTemplate;
import org.springframework.social.twitter.connect.TwitterConnectionFactory;

@Configuration
public class SocialConfig {

    @Inject
    private Environment environment;
	
    @Bean
    public ConnectionFactoryLocator connectionFactoryLocator() {
        ConnectionFactoryRegistry registry = new ConnectionFactoryRegistry();
        registry.addConnectionFactory(new TwitterConnectionFactory(
            environment.getProperty("twitter.consumerKey"),
            environment.getProperty("twitter.consumerSecret")));
        return registry;
    }

    @Value("${spring.social.twitter.appId}")
    private String consumerKey;
    @Value("${spring.social.twitter.appSecret}")
    private String consumerSecret;
    @Value("${twitter.access.token}")
    private String accessToken;
    @Value("${twitter.access.token.secret}")
    private String accessTokenSecret;
    @Bean
    TwitterTemplate getTwtTemplate(){
    return new TwitterTemplate(consumerKey, consumerSecret, accessToken, accessTokenSecret);

    }
}