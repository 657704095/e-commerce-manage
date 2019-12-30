package com.example.euserprovider;

import com.didispace.swagger.EnableSwagger2Doc;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

//接口文档开始
@EnableSwagger2Doc
@SpringBootApplication
@EnableDiscoveryClient
public class EUserProviderApplication {

    public static void main(String[] args) {
        SpringApplication.run(EUserProviderApplication.class, args);
    }

}
