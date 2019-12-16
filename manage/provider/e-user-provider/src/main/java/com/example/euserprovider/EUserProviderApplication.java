package com.example.euserprovider;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class EUserProviderApplication {

    public static void main(String[] args) {
        SpringApplication.run(EUserProviderApplication.class, args);
    }

}
