package com.example.demo.entities;

import java.util.Collection;
import java.util.Date;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;

import com.example.demo.beans.PublicationBean;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@DiscriminatorValue("etd")
public class Etudiant extends Membre {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Date dateInscription;
	private String diplome;

	@ManyToOne
	@JsonIgnore
	private EnseignantChercheur encadrant;

	public Etudiant() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Etudiant(String cin, String nom, String prenom, Date dateNaissance, Byte[] photo, String cv, String email,
			String password, Date dateInscription, String diplome, EnseignantChercheur encadrant, Collection<PublicationBean> publications) {
		super(cin, nom, prenom, dateNaissance, photo, cv, email, password, publications);
		this.dateInscription = dateInscription;
		this.diplome = diplome;
		this.encadrant = encadrant;
	}

	public Date getDateInscription() {
		return dateInscription;
	}

	public void setDateInscription(Date dateInscription) {
		this.dateInscription = dateInscription;
	}

	public String getDiplome() {
		return diplome;
	}

	public void setDiplome(String diplome) {
		this.diplome = diplome;
	}

	public EnseignantChercheur getEncadrant() {
		return encadrant;
	}

	public void setEncadrant(EnseignantChercheur encadrant) {
		this.encadrant = encadrant;
	}

}