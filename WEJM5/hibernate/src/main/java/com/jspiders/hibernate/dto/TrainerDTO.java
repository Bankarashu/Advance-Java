package com.jspiders.hibernate.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name = "trainer_details")
public class TrainerDTO {
	@Id
	@Column(name = "t_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	@Column(name = "t_name")
	private String name;
	@Column(name = "mail")
	private String email;
	@Column(name = "sub")
	private String subject;

}
