package com.cris.manejo_de_reservas.dto;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ModelMapperConfiguracion {
    @Bean
    ModelMapper modelMapper(){return  new ModelMapper();}

}
