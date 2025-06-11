package com.tap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.tap.Entity.Employee;
import com.tap.dao.EmployeeDAO;
import com.tap.dao.EmployeeDAOImpl;

@Controller
public class HomeController {
	@Autowired 
	private EmployeeDAO impl;
	
	@RequestMapping("/**")
	public String error() {
		return "pageNotFound";
	}
	
	@RequestMapping("/")
	public String register() {
		return "register";
	}
	
	@RequestMapping("/success")
	public String success(@RequestParam("name") String name,
						  @RequestParam("email") String email,
						  @RequestParam("department") String department,
						  @RequestParam("salary") int salary) {
		
		
		Employee e = new Employee(name, email, department, salary);
		impl.addEmployee(e);
		
		return "success";
	}

}

//		System.out.println(name);
//		System.out.println(email);
//		System.out.println(department);
//		System.out.println(salary);
//		model.addAttribute("myName", name);
//		model.addAttribute("myEmail", email);
//		model.addAttribute("myDepartment", department);
//		model.addAttribute("mySalary", salary);