package com.jspiders.springcoreannotations.beans;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@Component
public class AadharBean {
	@Value("1")
	int id;
	@Value("14-June-2014")
	String date_of_issue;
	@Value("123456789012")
	long aadhar_no;

}
