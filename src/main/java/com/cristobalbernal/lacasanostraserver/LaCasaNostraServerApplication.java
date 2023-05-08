package com.cristobalbernal.lacasanostraserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LaCasaNostraServerApplication {
    public static boolean DEBUG = true;
    public static String CONFIG_FILE =  null;
    public static void main(String[] args) {
        SpringApplication.run(LaCasaNostraServerApplication.class, args);
    }

}
