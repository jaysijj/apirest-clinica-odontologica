package br.edu.unichristus.backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;

@SpringBootApplication
@OpenAPIDefinition(
	    info = @Info(
	        title = "Clínica Odontologia",
	        version = "1.0",
	        description = "Documentação de API",
	        contact = @Contact(
	        	    name = "Jaime Jaysi",
	        	    email = "jaimejaysi@hotmail.com",
	        	     url = "https://unichristus.edu.br")
	    )
	)
public class BackendClinicaOdontologiaApplication {

	public static void main(String[] args) {
		SpringApplication.run(BackendClinicaOdontologiaApplication.class, args);
	}

}
