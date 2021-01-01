package com.example.demo.entities;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;

@Entity
public class Membre_Publication {

	@EmbeddedId
	private Membre_Pub_Ids id;
	@ManyToOne
	@MapsId("auteur_id")
	private Membre auteur;

	public Membre_Publication() {
		super();
	}

	public Membre_Publication(Membre_Pub_Ids id, Membre auteur) {
		super();
		this.id = id;
		this.auteur = auteur;
	}

	public Membre_Pub_Ids getId() {
		return id;
	}

	public void setId(Membre_Pub_Ids id) {
		this.id = id;
	}

	public Membre getAuteur() {
		return auteur;
	}

	public void setAuteur(Membre auteur) {
		this.auteur = auteur;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((auteur == null) ? 0 : auteur.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Membre_Publication other = (Membre_Publication) obj;
		if (auteur == null) {
			if (other.auteur != null)
				return false;
		} else if (!auteur.equals(other.auteur))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
