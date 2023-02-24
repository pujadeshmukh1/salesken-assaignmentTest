package com.masai.Salesken.repository;

import java.util.List;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import com.masai.Salesken.model.Semester;



public interface SemesterRepo extends ElasticsearchRepository<Semester, Integer> {
	
	
   List<Semester> findBySemesterNo(Integer semesterNo);
   
   
   
}
