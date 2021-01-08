package com.example.demo.entities;
import java.io.Serializable;

import javax.persistence.Embeddable;



@Embeddable
public class OutilMemberId implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long outilId;
	private Long memberId;
	public Long getOutilId() {
		return outilId;
	}
	public void setOutilId(Long outilId) {
		this.outilId = outilId;
	}
	public Long getMemberId() {
		return memberId;
	}
	public void setMemberId(Long memberId) {
		this.memberId = memberId;
	}
	public OutilMemberId(Long outilId, Long memberId) {
		super();
		this.outilId = outilId;
		this.memberId = memberId;
	}
	public OutilMemberId() {
		super();
	}
	
	
	

}