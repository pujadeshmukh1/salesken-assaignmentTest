package com.masai.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.masai.Salesken.model.Student;
import com.masai.Salesken.repository.StudentRepo;



@Controller
public class StudentUIController {

	@Autowired
	private StudentRepo studentRepo;
	
	@GetMapping("/home")
	public String homeLauncher() {
		
		return "welcome";
	}
	

	@GetMapping("/students")
	public String getAllStudent(Model model){
		
		Iterable<Student> stu=studentRepo.findAll();
		
		List<Student> listStu= new ArrayList<>();
		
		stu .forEach(listStu::add);
		
		model.addAttribute("mydata",listStu );
		
		return "result";
		
	}
	
	
}
