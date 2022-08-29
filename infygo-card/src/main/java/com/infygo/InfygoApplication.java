package com.infygo;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class InfygoApplication  {

	public static void main(String[] args) {
		SpringApplication.run(InfygoApplication.class, args);
	
	}

	//first add dependancies in pom.xml
	// modelmapper maven serach and copy dependencies 
	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}


	
}
