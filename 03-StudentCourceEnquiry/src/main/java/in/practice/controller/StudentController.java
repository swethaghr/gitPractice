package in.practice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import in.practice.binding.Student;
import in.practice.service.StudentService;

@Controller
public class StudentController {

	@Autowired
	private StudentService service;
	
	@GetMapping("/")
	public String loadIndexPage(Model model) {
		
		model.addAttribute("student", new Student());
		
		return "index";
	}
	
	@PostMapping("/save")
	public String saveStudent(Student student, Model model) {
		
	boolean isSaved	=service.saveStudent(student);
	model.addAttribute("student", new Student());
	if(isSaved) {
		model.addAttribute("msg", "Data Saved.....");
	}
	
		return "index";
	}

}
