package org.venky.employee.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Component;
import org.venky.employee.model.Employee;

@Component
public class EmployeeService {
	private static List<Employee> allEmployees = new ArrayList<Employee>( Arrays.asList(
			new Employee("Venky", 100000, 1),
			new Employee("Bob", 100001, 2), 
			new Employee("Warren", 100002, 3) ));

	public List<Employee> getAllEmployees() {
		return allEmployees;
	}
	
	public Employee getEmployee(int employeeId) {
		Employee result = null;
		Optional<Employee> findFirst = allEmployees.stream().filter(t -> t.getId() == employeeId).findFirst();
		if ( findFirst.isPresent()) {
			result = findFirst.get();
		}
		return result;
	}
	
	public Employee addEmployee(Employee employee) {
		allEmployees.add(employee);
		return employee;
	}
	
	public boolean deleteEmployee(int employeeId) {
		return allEmployees.removeIf(t -> t.getId() == employeeId);
	}
	
	public Employee updateEmployee(Employee employee, int employeeId) {
		Employee result = null;
		
		for (Employee emp : allEmployees) { 
			if ( emp.getId() == employeeId ) {
				int index = allEmployees.indexOf(emp);
				allEmployees.set(index, employee);
				result = allEmployees.get(index);
				break;
			}
		} 
		return result;
	}
	
	public Employee getDummyEmployee() {
		return new Employee("Dummy", 0.0, 0);
	}

}
