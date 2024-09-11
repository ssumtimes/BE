package org.sometimes.sometimes;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class SometimesApplication {

    public static void main(String[] args) {
        SpringApplication.run(SometimesApplication.class, args);
    }

}
