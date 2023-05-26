package com.jspiders.hibernateonetoone.dto;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import lombok.Data;


@Entity
@Data
public class PersonDTO {
	@Id
	private int id;
	private long contact;
	private String dob;
	private String name;
	private String address;
	@OneToOne
	private AadharDTO aadhar;

}
