package com.butchjgo.linkservice.uploadsystem;

import com.butchjgo.linkservice.uploadsystem.entity.AccountInfo;
import com.butchjgo.linkservice.uploadsystem.entity.RequestData;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

@SpringBootApplication
@ComponentScan(basePackages = "com.butchjgo.linkservice.uploadsystem")
public class LinkserviceUploadsystemApplication {

    public static void main(String[] args) {
        SpringApplication.run(LinkserviceUploadsystemApplication.class, args);
    }

    @Bean
    LinkedList<RequestData> requestPool() {
        return new LinkedList<>();
    }

    @Bean
    Set<AccountInfo> accountSet() {
        return new HashSet<>();
    }

}
