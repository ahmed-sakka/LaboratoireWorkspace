package com.example.demo.service;

import java.util.Date;
import java.util.List;

import com.example.demo.entities.Evenement;

public interface IEvenementService {

	public Evenement addEvenement(Evenement evenement);

	public void deleteEvenement(Long id);

	public Evenement updateEvenement(Evenement evenement);

	public Evenement findEvenement(Long id);

	public List<Evenement> findAll();

	public List<Evenement> findByTitreStartingWith(String titre);

	public List<Evenement> findByLieu(String lieu);
	
	public List<Evenement> findByDate(Date date);

}
