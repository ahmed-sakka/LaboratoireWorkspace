package com.example.demo.entities;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class MembrePubId implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long publicationId;
	private Long auteur_id;

	public MembrePubId() {
		super();
	}

	public MembrePubId(Long publication_id, Long auteur_id) {
		super();
		this.publicationId = publication_id;
		this.auteur_id = auteur_id;
	}

	public Long getPublication_id() {
		return publicationId;
	}

	public void setPublication_id(Long publication_id) {
		this.publicationId = publication_id;
	}

	public Long getAuteur_id() {
		return auteur_id;
	}

	public void setAuteur_id(Long auteur_id) {
		this.auteur_id = auteur_id;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((auteur_id == null) ? 0 : auteur_id.hashCode());
		result = prime * result + ((publicationId == null) ? 0 : publicationId.hashCode());
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
		MembrePubId other = (MembrePubId) obj;
		if (auteur_id == null) {
			if (other.auteur_id != null)
				return false;
		} else if (!auteur_id.equals(other.auteur_id))
			return false;
		if (publicationId == null) {
			if (other.publicationId != null)
				return false;
		} else if (!publicationId.equals(other.publicationId))
			return false;
		return true;
	}

}
