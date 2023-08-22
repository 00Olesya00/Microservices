package org.trip.sights;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EntityScan(basePackages = "org.trip.sights.entity")
@ComponentScan(basePackages = "org.trip.sights")
public class SightsApplication {
    public static void main(String[] args) {
        SpringApplication.run(SightsApplication.class, args);
    }

}
