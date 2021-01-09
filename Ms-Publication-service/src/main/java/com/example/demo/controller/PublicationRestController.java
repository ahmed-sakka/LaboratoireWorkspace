package com.example.demo.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.Publication;
import com.example.demo.service.IPublicationService;

@RestController

public class PublicationRestController {

	@Autowired
	IPublicationService publicationService;

	@RequestMapping(value = "/publications", method = RequestMethod.GET)
	public List<Publication> findPublications() {
		return publicationService.findAll();
	}

	@GetMapping(value = "/publications/{id}")
	public Publication findOnePublicationById(@PathVariable Long id) {
		return publicationService.findPublication(id);
	}

	@GetMapping(value = "/publications/search/titre")
	public List<Publication> findPublicationsByTitre(@RequestParam String titre) {
		return publicationService.findByTitreStartingWith(titre);
	}

	@GetMapping(value = "/publications/search/date")
	public List<Publication> findPublicationsByDate(@RequestParam Date date) {
		return publicationService.findByDate(date);
	}

	@GetMapping(value = "/publications/search/type")
	public List<Publication> findPublicationsByType(@RequestParam String type) {
		return publicationService.findByType(type);
	}

	@PostMapping(value = "/publications")
	public Publication addPublication(@RequestBody Publication publication) {
		return publicationService.addPublication(publication);
	}

	@DeleteMapping(value = "/publications/{id}")
	public void deletePublication(@PathVariable Long id) {
		publicationService.deletePublication(id);
	}

	@PutMapping(value = "/publications/{id}")
	public Publication updatePublication(@PathVariable Long id, @RequestBody Publication publication) {
		publication.setId(id);
		return publicationService.updatePublication(publication);
	}
}
