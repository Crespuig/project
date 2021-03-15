package com.project;

import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.project.entities.Coche;
import com.project.repositories.CocheRepository;

import ch.qos.logback.classic.Logger;

@Configuration
class LoadDatabase {

  private static final Logger log = (Logger) LoggerFactory.getLogger(LoadDatabase.class);

  //@Bean
 /*CommandLineRunner initDatabase(CocheRepository repository) {

    return args -> {
      log.info("Preloading " + repository.save(new Coche("Ford", "Mondeo", "12345A")));
      log.info("Preloading " + repository.save(new Coche("Opel", "Astra", "23456B")));
    };
  }*/
}
