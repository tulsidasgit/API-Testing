package com.example.demo.EmployeeController;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.EmployeeBean.Employee;
import com.example.demo.EmployeeService.EmployeeService;

@RestController
@RequestMapping("/Employees")
public class EmployeeController {
	
	@Autowired
	EmployeeService employeeService;
	
	@GetMapping()
	public List<Employee> getEmployees()
	{
		return employeeService.getEmployee();
	}
	
	@GetMapping(path="/{empID}")
	public Employee getEmployee(@PathVariable int empID)
	{
		return employeeService.getEmployee(empID);
	}
	
//	@GetMapping()
//	public Employee getEmployee(@RequestParam(value="name") String empName)
//	{
//		return employeeService.getEmployee(empName);
//	}
	
	@PostMapping("/addEmployee")
	public String addEmployee(@RequestBody Employee emp)
	{
		return employeeService.addEmployee(emp);
	}
	
//	@PostMapping("/addEmployee2")
//	public String addEmployee(@RequestBody HashMap<String, String> empnm)
//	{
//		return employeeService.addEmployee2(empnm);
//	}
	
	@PostMapping("/addEmployees")
	public String addEmployees(@RequestBody List<Employee> emp)
	{
		return employeeService.addEmployees(emp);
	}
	
//	@PutMapping("/updateEmployee")
//	public String updateEmployee(@RequestBody Employee emp)
//	{
//		return employeeService.updateEmployee(emp);
//	}
	
	@PutMapping("/updateEmployee/{empId}")
	public String updateEmployee(@PathVariable int empId, @RequestBody Employee emp) {
	    return employeeService.updateEmployee(empId, emp);
	}
	
	@PatchMapping("/updateEmployee/{empId}")
	public String patchUpdateEmployee(@PathVariable int empId, @RequestBody Employee emp) {
	    return employeeService.patchUpdateEmployee(empId, emp);
	}
	
	@DeleteMapping(path="/deleteEmployee/{empID}")
	public String deleteEmployee(@PathVariable int empID)
	{
		return employeeService.deleteEmployee(empID);
	}

}
