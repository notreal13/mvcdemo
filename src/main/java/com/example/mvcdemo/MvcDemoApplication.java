package com.example.mvcdemo;

import com.example.mvcdemo.entity.Actor;
import com.example.mvcdemo.repository.ActorRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication(proxyBeanMethods = false)
public class MvcDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(MvcDemoApplication.class, args);
    }

    @Bean
    public CommandLineRunner populateData(ActorRepository repository) {
        return (args) -> {
            repository.save(new Actor("PENELOPE", "GUINESS"));
            repository.save(new Actor("NICK", "WAHLBERG"));
            repository.save(new Actor("ED", "CHASE"));
            repository.save(new Actor("JENNIFER", "DAVIS"));
            repository.save(new Actor("JOHNNY", "LOLLOBRIGIDA"));
            repository.save(new Actor("BETTE", "NICHOLSON"));
            repository.save(new Actor("GRACE", "MOSTEL"));
            repository.save(new Actor("MATTHEW", "JOHANSSON"));
            repository.save(new Actor("JOE", "SWANK"));
            repository.save(new Actor("CHRISTIAN", "GABLE"));
            repository.save(new Actor("ZERO", "CAGE"));
            repository.save(new Actor("KARL", "BERRY"));
            repository.save(new Actor("UMA", "WOOD"));
        };
    }

}
