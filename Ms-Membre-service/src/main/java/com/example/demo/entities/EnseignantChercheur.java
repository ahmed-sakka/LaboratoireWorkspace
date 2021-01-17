package com.example.demo.entities;

import java.util.Collection;
import java.util.Date;
import java.util.List;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;

import com.example.demo.beans.PublicationBean;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

@Entity
@DiscriminatorValue("ens")
public class EnseignantChercheur extends Membre {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String grade;
	private String etablissement;


	public EnseignantChercheur() {
		super();
		// TODO Auto-generated constructor stub
	}

	public EnseignantChercheur(String cin, String nom, String prenom, Date dateNaissance, String photo, String cv,
			String email, String password, String grade, String etablissement, Collection<PublicationBean> publications) {
		super(cin, nom, prenom, dateNaissance, photo, cv, email, password, publications);
		this.grade = grade;
		this.etablissement = etablissement;
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

	

}
