package com.jspiders.springmvc.contoller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.jspiders.springmvc.pojo.StudentPOJO;
import com.jspiders.springmvc.service.StudentService;

@Controller
public class StudentController {

	@Autowired
	private StudentService service;

	// Home Controller
	@GetMapping("/home")
	public String home() {
		return "Home";
	}

	@GetMapping("/add")
	public String addStudent() {
		return "AddStudent";
	}

//Add Data Controller
	@PostMapping("/add")
	public String addStudent(@RequestParam String name, @RequestParam String email, @RequestParam long mobile,
			@RequestParam String address, ModelMap map) {
		StudentPOJO pojo = service.addStudent(name, email, mobile, address);
		if (pojo != null) {
			map.addAttribute("student", pojo);
			map.addAttribute("msg", "Record Added Sucessfully.");
			return "AddStudent";

		}
		map.addAttribute("msg", "Record Does not added");
		return "AddStudent";

	}

	@GetMapping("/search")
	public String searchStudent() {
		return "SearchStudent";
	}

//Search Data Controller
	@PostMapping("/search")
	public String searchStudent(@RequestParam int id, ModelMap map) {
		StudentPOJO pojo = service.searchStudent(id);
		if (pojo != null) {
			map.addAttribute("student", pojo);
			map.addAttribute("msg", "Studnet Record Found");
			return "SearchStudent";
		}

		// Failure
		map.addAttribute("msg", "Student data does not exist.");
		return "SearchStudent";
	}

	@GetMapping("/update")
	public String updateStudent(ModelMap map) {
		List<StudentPOJO> students = service.allStudent();
		map.addAttribute("student1", students);
		return "UpdateStudent";
	}

//Update Data Controller
	@PostMapping("/update")
	public String updateStudnet(@RequestParam int id, @RequestParam String name, @RequestParam String email,
			@RequestParam long mobile, @RequestParam String address, ModelMap map) {
		StudentPOJO pojo = service.updateStudent(id, name, email, mobile, address);

		if (pojo != null) {
			map.addAttribute("student", pojo);
			map.addAttribute("msg", "Student Record Updated");
			return "UpdateStudent";

		}
		map.addAttribute("msg", "Record Not Found.");
		return "UpdateStudent";
	}

	@GetMapping("/delete")
	public String deleteStudent(ModelMap map) {
		List<StudentPOJO> students = service.allStudent();

		map.addAttribute("student1", students);
		return "DeleteStudent";

	}

//Delete Data Controller
	@PostMapping("/delete")
	public String deleteStudent(@RequestParam int id, ModelMap map) {
		StudentPOJO pojo = service.deleteStudent(id);
		if (pojo != null) {
			map.addAttribute("student", pojo);
			map.addAttribute("msg", "Record Deleted Successfully.");
			return "DeleteStudent";
		}
		map.addAttribute("msg", "Record Does Not Found.");
		return "DeleteStudent";

	}

}
