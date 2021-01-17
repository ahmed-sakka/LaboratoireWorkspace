package com.example.demo.service;

import java.lang.reflect.Member;
import java.util.List;

import org.springframework.hateoas.EntityModel;

import com.example.demo.beans.EventBean;
import com.example.demo.beans.OutilBean;
import com.example.demo.beans.PublicationBean;
import com.example.demo.entities.EnseignantChercheur;
import com.example.demo.entities.Etudiant;
import com.example.demo.entities.Membre;

public interface IMemberService {
	// Crud sur les membres
	public Membre addMember(Membre m);

	public void deleteMember(Long id);

	public Membre updateMember(Membre p);

	public Membre findMember(Long id);

	public List<Membre> findAll();

	// Filtrage par propriété
	public Membre findByCin(String cin);

	public Membre findByEmail(String email);

	public List<Membre> findByNom(String nom);

	// recherche spécifique des étudiants
	public List<Etudiant> findAllEtudiants();

	public List<Etudiant> findByDiplome(String diplome);

	// recherche spécifique des enseignants
	public List<EnseignantChercheur> findByGrade(String grade);
	public List<EnseignantChercheur> findAllEnseignantChercheur();

	public List<EnseignantChercheur> findByEtablissement(String etablissement);
	// other ...

	public void affecterEncadrantToEtudiant(Long idetd, Long idens);

	public void affecterAuteurToPublication(Long idauteur, Long idpub);

	public List<PublicationBean> findPublicationParAuteur(Long idauteur);
	

	 
	 void affecterEventToMember(Long idEvent , Long idMember);
	 List<EventBean> findMemberEvents(Long idMember);
	 
	 void affecterOutilToMember(Long idOutil , Long idMember);
	 List<OutilBean> findMemberOutils(Long idMember);
	 List<Membre> findWithEventId(Long idevent);
	 List<Membre> findWithPublicationId(Long idPub);
	 List<Membre> findWithOutil(Long idOutil);
	 void deleteAffectationOutil(Long outilId);
	 void deleteAffectationPublication(Long publicationId);
	 void deleteAffectationEvent(Long eventId);
	 
	 void deleteAffectationOutil(Long outilId, Long idMember);
	 void deleteAffectationPublication(Long publicationId,Long idMember);
	 void deleteAffectationEvent(Long eventId,Long idMember);
	 
	 List<Etudiant>findEnsStudent(Long id);
	 

}
