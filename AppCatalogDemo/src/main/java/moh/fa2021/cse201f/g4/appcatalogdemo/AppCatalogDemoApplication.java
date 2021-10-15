package moh.fa2021.cse201f.g4.appcatalogdemo;

import moh.fa2021.cse201f.g4.appcatalogdemo.services.AppService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableAutoConfiguration
@ComponentScan(basePackages = {"moh.fa2021.cse201f.g4.appcatalogdemo"})
public class AppCatalogDemoApplication {
    @Autowired
    public static void main(String[] args) {
        SpringApplication.run(AppCatalogDemoApplication.class, args);


    }

}
