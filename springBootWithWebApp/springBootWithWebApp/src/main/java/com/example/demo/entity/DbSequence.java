package com.example.demo.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document(collection="dbSequence")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DbSequence {
	@Id
	private String id;
	private int seq;

}
