package com.masai.Salesken.model;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.annotations.CascadeType;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(indexName = "student")
public class Student{
	
	// This Entity class only contains the basic details of students (roll and name)
	
	@Id
	private Integer StudentRoll;
	private String studentName;
	private String email;
	private String address;

	//@OneToMany(cascade = CascadeType.ALL)
	private List<Semester> semesterNo = new ArrayList<>();
}
