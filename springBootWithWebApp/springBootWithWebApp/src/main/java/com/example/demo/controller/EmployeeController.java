package com.example.demo.controller;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.entity.Employee;
import com.example.demo.repository.EmployeeRepository;
import com.example.demo.service.SequenceGeneratorService;

@Controller
public class EmployeeController {
	@Autowired
	private SequenceGeneratorService services;
	@Autowired 
	private EmployeeRepository eRepo;
	
	@GetMapping({"/home","/login","/"})
	public ModelAndView home() {
		ModelAndView mv=new ModelAndView("home");
		return mv;
		}
		
	@GetMapping({"/showEmployee","/list"})
	public ModelAndView showEmployees() {
		ModelAndView mv=new ModelAndView("list-employee");
		List<Employee> employee = eRepo.findAll();
		mv.addObject("employee",employee);
		return mv;
		}
	@GetMapping({"/actionEmployee"})
	public ModelAndView actionEmployees() {
		ModelAndView mv=new ModelAndView("Action");
		List<Employee> employee = eRepo.findAll();
		mv.addObject("employee",employee);
		return mv;
		}
	@GetMapping("/addEmployeeForm")
	 public ModelAndView addEmployeeForm() {
		ModelAndView mv= new ModelAndView("add-employee-form");
		
		Employee newEmployee= new Employee();
		mv.addObject("employee",newEmployee);
		return mv;
	}
	
	@PostMapping("/saveEmployee")
	public String saveEmployee( @ModelAttribute Employee employee) {
		
		employee.setId(services.getSequenceNumber(Employee.SEQUENCE_NAME));
		eRepo.save(employee);
		return"redirect:/list";
		
		
	}
	@GetMapping("/showUpdateForm")
	public ModelAndView showUpdateForm(@RequestParam int employeeId) {
		ModelAndView mv=new ModelAndView("update-employee-form");
		Employee employee = eRepo.findById(employeeId).get();
		mv.addObject("employee",employee);
		return mv;
		
	}

	@PostMapping("/saveEmployee1")
	public String saveEmployee1(@ModelAttribute Employee employee) {
		
		
		eRepo.save(employee);
		return"redirect:/list";
		
		
	}
	@GetMapping("/deleteEmployee")
	public String deleteEmployee(@RequestParam int employeeId) {
		eRepo.deleteById(employeeId);
		return "redirect:/list";
	}
	

}
