package com.example.demo.entities;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;


@Entity
public class EventMember {
	@EmbeddedId
	private EventMemberId id;

	public EventMember(EventMemberId id) {
		super();
		this.id = id;
	}

	public EventMember() {
		super();
	}

	public EventMemberId getId() {
		return id;
	}

	public void setId(EventMemberId id) {
		this.id = id;
	}
	
	

}
