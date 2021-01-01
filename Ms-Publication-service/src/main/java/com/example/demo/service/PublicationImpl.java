package com.example.demo.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.PublicationRepository;
import com.example.demo.entities.Publication;

@Service
public class PublicationImpl implements IPublicationService {

	@Autowired
	PublicationRepository publicationRepository;

	@Override
	public Publication addPublication(Publication publication) {
		publicationRepository.save(publication);
		return publication;
	}

	@Override
	public void deletePublication(Long id) {
		publicationRepository.deleteById(id);

	}

	@Override
	public Publication updatePublication(Publication publication) {
		return publicationRepository.saveAndFlush(publication);
	}

	@Override
	public Publication findPublication(Long id) {
		return publicationRepository.findById(id).get();
	}

	@Override
	public List<Publication> findAll() {
		return publicationRepository.findAll();
	}

	@Override
	public List<Publication> findByTitreStartingWith(String titre) {
		return publicationRepository.findByTitreStartingWith(titre);
	}

	@Override
	public List<Publication> findByType(String type) {
		return publicationRepository.findByType(type);
	}

	@Override
	public List<Publication> findByDate(Date date) {
		return publicationRepository.findByDate(date);
	}

}
