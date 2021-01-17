package com.example.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.webmvc.RepositoryRestController;

import com.example.demo.entities.Etudiant;

@RepositoryRestController
public interface EtudiantRepository extends JpaRepository<Etudiant, Long> {
	List<Etudiant> findByDiplome(String diplome);
	List<Etudiant> findByDiplomeOrderByDateInscriptionDesc(String diplome);
	List<Etudiant>findByEncadrantId(Long id);
}
