package com.microservice.currencyexchangeconversion;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class CurrencyExchangeConversionApplication {

    public static void main(String[] args) {
        SpringApplication.run(CurrencyExchangeConversionApplication.class, args);
    }

}
