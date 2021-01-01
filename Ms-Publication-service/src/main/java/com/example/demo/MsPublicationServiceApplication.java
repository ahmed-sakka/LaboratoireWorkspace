package com.example.demo;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

import com.example.demo.entities.Publication;
import com.example.demo.service.IPublicationService;

@SpringBootApplication
@EnableDiscoveryClient
public class MsPublicationServiceApplication implements CommandLineRunner {

	@Autowired
	IPublicationService publicationService;
	@Autowired
	RepositoryRestConfiguration configuration;
	
	public static void main(String[] args) {
		SpringApplication.run(MsPublicationServiceApplication.class, args);
	}

	public void run(String... args) throws Exception {
		
		// Expose the id
		configuration.exposeIdsFor(Publication.class);
/*
		publicationService.addPublication(new Publication("type1", "pub1", "lien1", new Date(), "source1"));
		publicationService.addPublication(new Publication("type2", "pub2", "lien2", new Date(), "source2"));
		publicationService.addPublication(new Publication("type1", "pub3", "lien3", new Date(), "source3"));
*/	
	}
	

}
