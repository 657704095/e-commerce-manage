package com.example.eorderprovider;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class EOrderProviderApplication {

    public static void main(String[] args) {
        SpringApplication.run(EOrderProviderApplication.class, args);
    }

}
