package com.example.demo.entities;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;



@Entity
public class OutilMember {
	@EmbeddedId
	private OutilMemberId id;

	public OutilMember(OutilMemberId id) {
		super();
		this.id = id;
	}

	public OutilMember() {
		super();
	}

	public OutilMemberId getId() {
		return id;
	}

	public void setId(OutilMemberId id) {
		this.id = id;
	}

	
}