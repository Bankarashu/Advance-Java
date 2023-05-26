package com.jspiders.hibernatemanytoone.dto;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.Data;

@Entity
@Data
public class PlayerDTO {
	@Id
	private int id;
	private String name;
	private String role;
	private int age;
	private int jursey;
	@ManyToOne
	private TeamDTO team;

}
