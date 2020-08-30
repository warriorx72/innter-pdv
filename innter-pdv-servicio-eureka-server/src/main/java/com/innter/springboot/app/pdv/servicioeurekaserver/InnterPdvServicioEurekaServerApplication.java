package com.innter.springboot.app.pdv.servicioeurekaserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
@EnableEurekaServer
@SpringBootApplication
public class InnterPdvServicioEurekaServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(InnterPdvServicioEurekaServerApplication.class, args);
	}

}
