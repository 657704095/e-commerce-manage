package com.example.eorderprovider;

import com.didispace.swagger.EnableSwagger2Doc;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

@SpringBootApplication
@EnableDiscoveryClient
@EnableSwagger2Doc
@EnableFeignClients
@MapperScan("com.example.eorderprovider.dao")
public class EOrderProviderApplication {

    public static void main(String[] args) {
        SpringApplication.run(EOrderProviderApplication.class, args);
    }

}
