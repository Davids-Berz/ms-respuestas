package com.mservice.app.respuestas;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
@EntityScan({"com.mservice.app.respuestas.models.entity","com.mservice.commons.alumnos.models.entity",
			 "com.mservice.commons.examenes.models.entity"})
public class MsRespuestasApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsRespuestasApplication.class, args);
	}

}
