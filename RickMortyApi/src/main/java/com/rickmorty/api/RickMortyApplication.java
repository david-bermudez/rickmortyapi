package com.rickmorty.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RickMortyApplication {

    public static void main(String[] args) {
        SpringApplication springApplication=new SpringApplication(RickMortyApplication.class);
        springApplication.run(args);

    }
}