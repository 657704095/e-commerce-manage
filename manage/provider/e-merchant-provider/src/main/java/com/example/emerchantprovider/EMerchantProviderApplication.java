package com.example.emerchantprovider;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class EMerchantProviderApplication {

    public static void main(String[] args) {
        SpringApplication.run(EMerchantProviderApplication.class, args);
    }

}
