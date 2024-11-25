package com.cris.manejo_de_reservas;

import com.cris.manejo_de_reservas.api.ClienteController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.cris.manejo_de_reservas.repositories")
@EntityScan(basePackages = "com.cris.manejo_de_reservas.entities")

public class ManejoDeReservasApplication {

    public static void main(String[] args) {
        SpringApplication.run(ManejoDeReservasApplication.class, args);

    }

}
