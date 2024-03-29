package com.example.demo.entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Lob;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import com.example.demo.beans.EventBean;
import com.example.demo.beans.OutilBean;
import com.example.demo.beans.PublicationBean;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "type_mbr", discriminatorType = DiscriminatorType.STRING)
public abstract class Membre implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String cin;
	private String nom;
	private String prenom;
	private String adress;
	private String phone;
	@Temporal(TemporalType.DATE)
	private Date dateNaissance;
	@Lob
	private String photo;
	private String cv;
	private String email;
	private String password;
	@Transient
	private Collection<PublicationBean> publications;
	@Transient
	private List<EventBean>events;
	private String type;
	
	@Transient
	private List<OutilBean> outils;

	public Membre() {
		super();
	}

	public Membre(String cin, String nom, String prenom, Date dateNaissance, String photo, String cv, String email,
			String password, Collection<PublicationBean> publications) {
		super();
		this.cin = cin;
		this.nom = nom;
		this.prenom = prenom;
		this.dateNaissance = dateNaissance;
		this.photo = photo;
		this.cv = cv;
		this.email = email;
		this.password = password;
		this.publications = publications;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCin() {
		return cin;
	}

	public void setCin(String cin) {
		this.cin = cin;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public Date getDateNaissance() {
		return dateNaissance;
	}

	public void setDateNaissance(Date dateNaissance) {
		this.dateNaissance = dateNaissance;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public String getCv() {
		return cv;
	}

	public void setCv(String cv) {
		this.cv = cv;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Collection<PublicationBean> getPublications() {
		return publications;
	}

	public void setPublications(Collection<PublicationBean> publications) {
		this.publications = publications;
	}

	public List<EventBean> getEvents() {
		return events;
	}

	public void setEvents(List<EventBean> events) {
		this.events = events;
	}

	public List<OutilBean> getOutils() {
		return outils;
	}

	public void setOutils(List<OutilBean> outils) {
		this.outils = outils;
	}

	public String getAdress() {
		return adress;
	}

	public void setAdress(String adress) {
		this.adress = adress;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	

}
