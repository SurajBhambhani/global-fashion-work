package com.bhambhani.fashion.gallery;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;


@SpringBootApplication
public class GlobalFashionApplication {

  public static void main(String[] args) {
    SpringApplication.run(GlobalFashionApplication.class, args);
  }

}
