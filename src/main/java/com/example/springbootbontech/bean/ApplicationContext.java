package com.example.springbootbontech.bean;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationContext {

    @Bean
    public org.modelmapper.ModelMapper modelMapperConfig(){
        return new org.modelmapper.ModelMapper();
    }
}
