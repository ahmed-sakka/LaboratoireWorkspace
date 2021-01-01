package com.example.demo;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

import com.example.demo.entities.Evenement;
import com.example.demo.service.IEvenementService;

@SpringBootApplication
@EnableDiscoveryClient
public class MsEvenementServiceApplication implements CommandLineRunner {

	@Autowired
	IEvenementService evenementService;

	public static void main(String[] args) {
		SpringApplication.run(MsEvenementServiceApplication.class, args);
	}

	public void run(String... args) throws Exception {
/*
		evenementService.addEvenement(new Evenement("pyfac", new Date(), "sfax"));
		evenementService.addEvenement(new Evenement("xtreme", new Date(), "sfax"));
		evenementService.addEvenement(new Evenement("hashcode", new Date(), "tunis"));
*/	
	}

}
