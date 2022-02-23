package com.example.demo.player;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class PlayerConfig {

    @Bean
    CommandLineRunner commandLineRunner(PlayerRepository repository){
        return args -> {
            Player federico = new Player(
                    "federico",
                    "pepito",
                    0,
                    0,
                    0,
                    0,
                    (short)5000
            );
            repository.saveAll(List.of(federico));
        };

    }
}
