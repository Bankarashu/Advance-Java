package com.jspiders.hibernate_file.dto;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;


@Entity
@Data
public class StudentDTO {
	@Id
	private int sid;
	private String sname;
	private String sadd;
	private int smarks;
	private String semail;
	
	

}
