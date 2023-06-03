package com.example.demo.entity;



import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Document(collection="employee")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Employee {
	@Transient
	public static final String SEQUENCE_NAME="user_sequence";
	@Id
	private int id;
	private String fName;
	private String lName;
	private String email;
	private String age;
	private String address;
	private String department;
	

}
