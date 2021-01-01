package com.example.demo.entities;

import java.util.Collection;
import java.util.Date;
import java.util.List;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;

import com.example.demo.beans.PublicationBean;

@Entity
@DiscriminatorValue("ens")
public class EnseignantChercheur extends Membre {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String grade;
	private String etablissement;

	@OneToMany(mappedBy="encadrant", fetch = FetchType.EAGER)
	private List<Etudiant> etudiants;

	public EnseignantChercheur() {
		super();
		// TODO Auto-generated constructor stub
	}

	public EnseignantChercheur(String cin, String nom, String prenom, Date dateNaissance, Byte[] photo, String cv,
			String email, String password, String grade, String etablissement, List<Etudiant> etudiants, Collection<PublicationBean> publications) {
		super(cin, nom, prenom, dateNaissance, photo, cv, email, password, publications);
		this.grade = grade;
		this.etablissement = etablissement;
		this.etudiants = etudiants;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public String getEtablissement() {
		return etablissement;
	}

	public void setEtablissement(String etablissement) {
		this.etablissement = etablissement;
	}

	public List<Etudiant> getEtudiants() {
		return etudiants;
	}

	public void setEtudiants(List<Etudiant> etudiants) {
		this.etudiants = etudiants;
	}

}
