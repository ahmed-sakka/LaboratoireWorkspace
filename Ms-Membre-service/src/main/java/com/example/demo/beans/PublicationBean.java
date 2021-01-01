package com.example.demo.beans;

import java.util.Date;

public class PublicationBean {

	private Long id;
	private String type;
	private String titre;
	private String lien;
	private Date date;
	private String source;

	public PublicationBean() {
		super();
	}

	public PublicationBean(String type, String titre, String lien, Date date, String source) {
		super();
		this.type = type;
		this.titre = titre;
		this.lien = lien;
		this.date = date;
		this.source = source;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	public String getLien() {
		return lien;
	}

	public void setLien(String lien) {
		this.lien = lien;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

}
