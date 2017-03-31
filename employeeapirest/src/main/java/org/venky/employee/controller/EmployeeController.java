package org.venky.employee.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.venky.employee.model.Employee;
import org.venky.employee.service.EmployeeService;

/**
 * Employee endpoint that support - ADD, DELETE, UPDATE, GET operations. Please check the 
 * swagger endpoint for usage.
 * http://<hostname>:8080/swagger-ui.html#/employee-controller
 * 
 * @author Venky Miryala on 03/29/2017
 */
@RestController
@RequestMapping("/employees")
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService;

	@RequestMapping(value = "/{id}", method=RequestMethod.GET)
	public ResponseEntity<?> getEmployee(@PathVariable int id) {
		Employee employee = employeeService.getEmployee(id);
		if (employee == null) {
			return new ResponseEntity<>("Employee not found for id:" + id, HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(employee, HttpStatus.OK);
	}

	@RequestMapping(value = "/dummy", method=RequestMethod.GET)
	public ResponseEntity<Employee> getDummyEmployee() {
		return new ResponseEntity<>(employeeService.getDummyEmployee(), HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<Employee>> getAllEmployees() {
		return new ResponseEntity<>(employeeService.getAllEmployees(), HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<?> addEmployee(@RequestBody Employee employee) {
		return new ResponseEntity<>(employeeService.addEmployee(employee), HttpStatus.CREATED);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Employee> updateEmployee(@RequestBody Employee employee, @PathVariable int id) {
		return new ResponseEntity<>(employeeService.updateEmployee(employee, id), HttpStatus.OK);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<String> deleteEmployee(@PathVariable int id) {
		ResponseEntity<String> response;

		if (employeeService.deleteEmployee(id)) {
			response = new ResponseEntity<>("Deleted successfully", HttpStatus.OK);
		} else {
			response = new ResponseEntity<>(String.format("Employee with id[%s] not found", id), HttpStatus.NO_CONTENT);
		}

		return response;
	}

}
