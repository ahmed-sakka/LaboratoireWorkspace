package com.example.demo.entities;
import java.io.Serializable;

import javax.persistence.Embeddable;



@Embeddable
public class EventMemberId implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long eventId;
	private Long memberId;
	public Long getEventId() {
		return eventId;
	}
	public void setEventId(Long eventId) {
		this.eventId = eventId;
	}
	public Long getMemberId() {
		return memberId;
	}
	public void setMemberId(Long memberId) {
		this.memberId = memberId;
	}
	public EventMemberId(Long eventId, Long memberId) {
		super();
		this.eventId = eventId;
		this.memberId = memberId;
	}
	public EventMemberId() {
		super();
	}

	
	
}
