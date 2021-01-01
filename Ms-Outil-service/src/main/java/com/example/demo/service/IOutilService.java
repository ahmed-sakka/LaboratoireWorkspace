package com.example.demo.service;

import java.util.Date;
import java.util.List;

import com.example.demo.entities.Outil;

public interface IOutilService {

	public Outil addOutil(Outil outil);

	public void deleteOutil(Long id);

	public Outil updateOutil(Outil outil);

	public Outil findOutil(Long id);

	public List<Outil> findAll();

	public List<Outil> findByDate(Date date);

}
