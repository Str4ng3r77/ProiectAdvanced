package com.example.proiect_adv;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
@Configuration
public class LoadDataBase {
    private static final Logger log = LoggerFactory.getLogger(LoadDataBase.class);

    @Bean
    CommandLineRunner initDatabase(MaterieRpository repository) {

        return args -> {
            log.info("Preloading " + repository.save(new Materie(1, "Matematica", 10, true, Dificultate.AVANSAT, 20)));
            log.info("Preloading " + repository.save(new Materie(2, "Romana", 5, false, Dificultate.MEDIU, 12)));
            log.info("Preloading " + repository.save(new Materie(10, "Romana", 1, false, Dificultate.INCEPATOR, 2)));
        };
    }
}
