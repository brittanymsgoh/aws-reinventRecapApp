package com.amazonaws.samples.reinventrecapapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import software.amazon.awssdk.services.secretsmanager.SecretsManagerClient;

@SpringBootApplication
public class ReinventRecapAppApplication {

    public static void main(String[] args) {
        SpringApplication.run(ReinventRecapAppApplication.class, args);
    }

}
