package com.example.ewaybillprovide;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class EWaybillProvideApplication {

    public static void main(String[] args) {
        SpringApplication.run(EWaybillProvideApplication.class, args);
    }

}
