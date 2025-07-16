package com.example.demo.EmployeeService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.example.demo.EmployeeBean.Employee;

@Component
public class EmployeeService 
{
	
	Map<Integer, Employee> employeeData  = new HashMap<Integer, Employee>();
	
	public EmployeeService() {
		// TODO Auto-generated constructor stub
		employeeData.put(getID(), new Employee("Roshan", 34, 12));
		employeeData.put(getID(),new Employee("Rohan",21 , 1.2));
		employeeData.put(getID(), new Employee("Yash", 22, 2.2));
		employeeData.put(getID(),new Employee("Monika",26, 4.7));
		for(int empID : employeeData.keySet())
		{
			employeeData.get(empID).setEmpId(empID);
		}
	}
	
	public List<Employee> getEmployee()
	{
		List<Employee> empList = new ArrayList<>(employeeData.values());
		return empList;
	}
	
	// get employeeby ID
	public Employee getEmployee(int empID)
	{
		return employeeData.get(empID);
	}
	
	// getEmployee by name
	public Employee getEmployee(String empName)
	{
		Employee employee = null;
		for(int i : employeeData.keySet() )
		{
			if(employeeData.get(i).getEmpName().equalsIgnoreCase(empName))
				employee = employeeData.get(i);
		}
		return employee;
	}
	
	public String addEmployee(Employee emp)
	{
		employeeData.put(getID(), emp);
		emp.setEmpId(getID());
		return "Employee Details added";
	}
	
//	public String addEmployee2(HashMap<String, String> empnm)
//	{
//		Employee emp = new Employee();
//		emp.setEmpName(empnm.get("empName"));
//		employeeData.put(getID(), emp);
//		emp.setEmpId(getID());
//		employeeData.put(emp.getEmpId(), emp);
//		return "Employee Details added";
//	}
	
	
	public String addEmployees(List<Employee> emp)
	{
		for(Employee e: emp)
		{
			employeeData.put(getID(), e);
			e.setEmpId(getID());
		}
		
		return "Employee Details added";
	}
	
	public int getID()
	{
		int max=0;
		for(int i : employeeData.keySet())
		{
			System.out.println(i+" \t"+max);
			if(max<i)
				max=i;
		}
		return (max+1);
	}
	
//	public String updateEmployee(Employee emp)
//	{
//		employeeData.replace(emp.getEmpId(), emp);
//		
//				//employeeData.put(emp.getEmpId(), emp);
//				
//		return "Emplopyee details updated";
//		
//	}
	
	public String updateEmployee(int empId, Employee emp) {
	    if (employeeData.containsKey(empId)) {
	        // Update employee details
	        emp.setEmpId(empId);
	        employeeData.replace(empId, emp);
	        return "Employee details updated";
	    } else {
	        return "Employee not found"; // Or handle the case when the employee ID is not found
	    }
	}
	
	public String patchUpdateEmployee(int empId, Employee emp) {
	    if (employeeData.containsKey(empId)) {
	        // Get the existing employee
	        Employee existingEmployee = employeeData.get(empId);

	        // Update only the fields that are not null in the request
	        if (emp.getEmpName() != null) {
	            existingEmployee.setEmpName(emp.getEmpName());
	        }
	        if (emp.getEmpAge() > 0) {
	            existingEmployee.setEmpAge(emp.getEmpAge());
	        }
	        if (emp.getEmpExp() > 0) {
	            existingEmployee.setEmpExp(emp.getEmpExp());
	        }

	        return "Employee details updated partially";
	    } else {
	        return "Employee not found"; // Or handle the case when the employee ID is not found
	    }
	}
	
	public String deleteEmployee(int empID)
	{
		employeeData.remove(empID);
		return "Employee data removed";
	}
	
	
	
	

}
