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

import com.example.demo.entities.Outil;
import com.example.demo.service.IOutilService;

@RestController
public class OutilRestController {

	@Autowired
	IOutilService outilService;

	@RequestMapping(value = "/outils", method = RequestMethod.GET)
	public List<Outil> findOutils() {
		return outilService.findAll();
	}

	@GetMapping(value = "/outils/{id}")
	public Outil findOneOutilById(@PathVariable Long id) {
		return outilService.findOutil(id);
	}

	@GetMapping(value = "/outils/search/date")
	public List<Outil> findOutilsByDate(@RequestParam Date date) {
		return outilService.findByDate(date);
	}

	@PostMapping(value = "/outils")
	public Outil addOutil(@RequestBody Outil outil) {
		return outilService.addOutil(outil);
	}

	@DeleteMapping(value = "/outils/{id}")
	public void deleteOutil(@PathVariable Long id) {
		outilService.deleteOutil(id);
	}

	@PutMapping(value = "/outils/{id}")
	public Outil updateOutil(@PathVariable Long id, @RequestBody Outil outil) {
		outil.setId(id);
		return outilService.updateOutil(outil);
	}
}
