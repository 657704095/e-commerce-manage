package com.example.ehorsemanprovider;

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
@MapperScan("com.example.ehorsemanprovider.dao")
public class EHorsemanProviderApplication {

    public static void main(String[] args) {
        SpringApplication.run(EHorsemanProviderApplication.class, args);
    }

}
