package com.example.demo.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.EvenementRepository;
import com.example.demo.entities.Evenement;

@Service
public class EvenementImpl implements IEvenementService {

	@Autowired
	EvenementRepository evenementRepository;

	@Override
	public Evenement addEvenement(Evenement evenement) {
		evenementRepository.save(evenement);
		return evenement;
	}

	@Override
	public void deleteEvenement(Long id) {
		evenementRepository.deleteById(id);
		
	}

	@Override
	public Evenement updateEvenement(Evenement evenement) {
		return evenementRepository.saveAndFlush(evenement);
	}

	@Override
	public Evenement findEvenement(Long id) {
		return evenementRepository.findById(id).get();
	}

	@Override
	public List<Evenement> findAll() {
		return evenementRepository.findAll();
	}

	@Override
	public List<Evenement> findByTitreStartingWith(String titre) {
		return evenementRepository.findByTitreStartingWith(titre);
	}

	@Override
	public List<Evenement> findByLieu(String lieu) {
		return evenementRepository.findByLieu(lieu);
	}

	@Override
	public List<Evenement> findByDate(Date date) {
		return evenementRepository.findByDate(date);
	}
	
}
