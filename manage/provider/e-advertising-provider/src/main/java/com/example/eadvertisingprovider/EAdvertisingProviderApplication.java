package com.example.eadvertisingprovider;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class EAdvertisingProviderApplication {

    public static void main(String[] args) {
        SpringApplication.run(EAdvertisingProviderApplication.class, args);
    }

}
