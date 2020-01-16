package com.example.eadminprovider;

import com.didispace.swagger.EnableSwagger2Doc;
//import com.spring4all.swagger.EnableSwagger2Doc;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

//接口文档开始
@EnableSwagger2Doc
@SpringBootApplication
@EnableDiscoveryClient
@MapperScan("com.example.eadminprovider.dao")
@EnableFeignClients
public class EAdminProviderApplication {
    /**
     * http://localhost:8080/swagger-ui.html 接口文档登录网址
     * @param args main方法字符串输入
     */
    public static void main(String[] args) {
        SpringApplication.run(EAdminProviderApplication.class, args);
    }

}
