package com.example.demo.entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import com.example.demo.beans.PublicationBean;

@Entity
@DiscriminatorValue("ens")
public class EnseignantChercheur extends Membre implements Serializable{
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
