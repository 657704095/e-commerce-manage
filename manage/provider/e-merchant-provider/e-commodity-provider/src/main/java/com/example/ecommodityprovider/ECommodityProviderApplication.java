package com.example.ecommodityprovider;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class ECommodityProviderApplication {

    public static void main(String[] args) {
        SpringApplication.run(ECommodityProviderApplication.class, args);
    }

}
