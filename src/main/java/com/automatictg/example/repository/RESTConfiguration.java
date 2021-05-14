package com.automatictg.example.repository;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RESTConfiguration 
{
    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
  
}