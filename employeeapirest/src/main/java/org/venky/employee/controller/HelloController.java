package org.venky.employee.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello")
public class HelloController{
	@RequestMapping(method=RequestMethod.GET)
	public String showMessage() {
		return String.format("Hello World!!");
	}
}
