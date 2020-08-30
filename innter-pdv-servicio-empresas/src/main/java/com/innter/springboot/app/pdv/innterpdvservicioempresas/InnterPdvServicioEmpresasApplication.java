package com.innter.springboot.app.pdv.innterpdvservicioempresas;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
@EnableEurekaClient
@SpringBootApplication
public class InnterPdvServicioEmpresasApplication {

	public static void main(String[] args) {
		SpringApplication.run(InnterPdvServicioEmpresasApplication.class, args);
	}

}
