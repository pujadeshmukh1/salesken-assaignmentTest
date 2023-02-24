package com.masai.controller;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.masai.Salesken.model.Semester;
import com.masai.Salesken.model.Student;
import com.masai.Salesken.repository.SemesterRepo;
import com.masai.Salesken.repository.StudentRepo;

@RestController
public class StudentController {

	@Autowired
	private StudentRepo stuRepo;
	
	
	@Autowired
	private SemesterRepo semRepo;
	
	
	// this method add the basic student details only
	
	@PostMapping("/saveStudents")
	public Student saveStudent(@RequestBody Student student) {
		
		return stuRepo.save(student);
		
	}
	
	
	
	@GetMapping("/students")
	public List<Student> getAllStudent(){
		
		Iterable<Student> stu=stuRepo.findAll();
		
		List<Student> listStu= new ArrayList<>();
		
		stu .forEach(listStu::add);
		
		return listStu;
		
	}
	
	
	// this method save the record of student like the semester no , subject details , marks obtain in each subject
	
	
	@PostMapping("/saveStudentReport")
	
	public Semester saveStudentReport(Semester semester) {
		
		return semRepo.save(semester);
		
	}
	
	
	
	// this method return the average mark of the student
	@GetMapping("studentMark/{id}")
	
	public String getTheAvgMark(@PathVariable("id") Integer id) {
		
		Optional<Semester> semesterOptional=semRepo.findById(id);
		
		Semester semester = semesterOptional.get();
		
		Double avgMark = (semester.getSubject1Mark() + semester.getSubject2Mark() + semester.getSubject3Mark())/3;
		
		return "your average of marks is :" + avgMark;
		
	}
	
	
	@GetMapping("studentPercentage/{semesterNo}")
	
	public String getThepercentage(@PathVariable("semesterNo") Integer semesterNo) {
		
	  List<Semester>  listsemesters =semRepo.findBySemesterNo(semesterNo);
	     
	  int count=0;
	  
	  Double singleStudentmark = 0.0;
	  
	  for(Semester sem:listsemesters) {
		  
		  singleStudentmark += sem.getSubject1Mark() + sem.getSubject2Mark() + sem.getSubject3Mark();
		  
		  count++;
	  }
	  
	  Double percentage=singleStudentmark/count;
	  
	  return "Your Average Percentage of semester "+semesterNo+" is :"+percentage;
		
	}
	
	
	
	
	
	
	
}
