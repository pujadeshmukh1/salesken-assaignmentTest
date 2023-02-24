package com.masai.Salesken.repository;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import com.masai.Salesken.model.Student;

public interface StudentRepo extends ElasticsearchRepository<Student, Integer>{
	
	

}
