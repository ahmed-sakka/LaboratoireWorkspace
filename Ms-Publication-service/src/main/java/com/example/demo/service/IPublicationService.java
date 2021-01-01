package com.example.demo.service;

import java.util.Date;
import java.util.List;

import com.example.demo.entities.Publication;

public interface IPublicationService {

	public Publication addPublication(Publication publication);

	public void deletePublication(Long id);

	public Publication updatePublication(Publication publication);

	public Publication findPublication(Long id);

	public List<Publication> findAll();

	public List<Publication> findByTitreStartingWith(String titre);

	public List<Publication> findByType(String type);

	public List<Publication> findByDate(Date date);

}
