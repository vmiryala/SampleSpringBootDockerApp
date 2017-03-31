package org.venky.employee.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="employee")
public class Employee {
	private int id;
	private String name;
	private double salary;

	public Employee(String name, double salary, int id) {
		this.name = name;
		this.salary = salary;
		this.id = id;
	}

	public Employee() {
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return id + "::" + name + "::" + salary;
	}

}