package com.example.demo;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

import com.example.demo.entities.Outil;
import com.example.demo.service.IOutilService;

@SpringBootApplication
@EnableDiscoveryClient
public class MsOutilServiceApplication implements CommandLineRunner {

	@Autowired
	IOutilService outilService;

	public static void main(String[] args) {
		SpringApplication.run(MsOutilServiceApplication.class, args);
	}

	public void run(String... args) throws Exception {
/*
		outilService.addOutil(new Outil(new Date(), "url1"));
		outilService.addOutil(new Outil(new Date(), "url2"));
		outilService.addOutil(new Outil(new Date(), "url3"));
*/
	}

}
