package com.example.demo.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.OutilRepository;
import com.example.demo.entities.Outil;

@Service
public class OutilImpl implements IOutilService {

	@Autowired
	OutilRepository outilRepository;

	@Override
	public Outil addOutil(Outil outil) {
		outilRepository.save(outil);
		return outil;
	}

	@Override
	public void deleteOutil(Long id) {
		outilRepository.deleteById(id);

	}

	@Override
	public Outil updateOutil(Outil outil) {
		return outilRepository.saveAndFlush(outil);
	}

	@Override
	public Outil findOutil(Long id) {
		return outilRepository.findById(id).get();
	}

	@Override
	public List<Outil> findAll() {
		return outilRepository.findAll();
	}

	@Override
	public List<Outil> findByDate(Date date) {
		return outilRepository.findByDate(date);
	}

}
