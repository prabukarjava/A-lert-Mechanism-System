package com.coding.springbootrestmechanismsystem.model;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotBlank;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name="Mechanisamdetails")
@EntityListeners(AuditingEntityListener.class)

public class Mechanisamsystem {
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	 
	 @NotBlank
	 private Long teamid;
	 public Long getTeamid() {
		return teamid;
	}
	public void setTeamid(Long teamid) {
		this.teamid = teamid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getTeamName() {
		return teamName;
	}
	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}
	@NotBlank
	 private String name;
	 @NotBlank
	 private String phoneNumber;
	 @NotBlank
	 private String teamName;

}
