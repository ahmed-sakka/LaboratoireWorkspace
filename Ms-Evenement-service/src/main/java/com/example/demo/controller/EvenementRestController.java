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

import com.example.demo.entities.Evenement;
import com.example.demo.service.IEvenementService;

@RestController
@CrossOrigin
public class EvenementRestController {

	@Autowired
	IEvenementService evenementService;

	@RequestMapping(value = "/evenements", method = RequestMethod.GET)
	public List<Evenement> findEvenements() {
		return evenementService.findAll();
	}

	@GetMapping(value = "/evenements/{id}")
	public Evenement findOneEvenementById(@PathVariable Long id) {
		return evenementService.findEvenement(id);
	}

	@GetMapping(value = "/evenements/search/titre")
	public List<Evenement> findEvenementsByTitre(@RequestParam String titre) {
		return evenementService.findByTitreStartingWith(titre);
	}

	@GetMapping(value = "/evenements/search/date")
	public List<Evenement> findEvenementsByDate(@RequestParam Date date) {
		return evenementService.findByDate(date);
	}

	@GetMapping(value = "/evenements/search/lieu")
	public List<Evenement> findEvenementsByLieu(@RequestParam String lieu) {
		return evenementService.findByLieu(lieu);
	}

	@PostMapping(value = "/evenements")
	public Evenement addEvenement(@RequestBody Evenement evenement) {
		return evenementService.addEvenement(evenement);
	}

	@DeleteMapping(value = "/evenements/{id}")
	public void deleteEvenement(@PathVariable Long id) {
		evenementService.deleteEvenement(id);
	}

	@PutMapping(value = "/evenements/{id}")
	public Evenement updateEvenement(@PathVariable Long id, @RequestBody Evenement evenement) {
		evenement.setId(id);
		return evenementService.updateEvenement(evenement);
	}
}
