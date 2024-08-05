package com.kirara.docker_test.config;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ThreadConfig {


    @Bean
    public Executor executor() {
        return Executors.newFixedThreadPool(10);
    }

}
