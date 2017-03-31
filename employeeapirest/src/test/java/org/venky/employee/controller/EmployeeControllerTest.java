package org.venky.employee.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.venky.employee.boot.EmployeeApp;
import org.venky.employee.model.Employee;
import org.venky.employee.service.EmployeeService;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = EmployeeApp.class)
@WebMvcTest(controllers = EmployeeController.class)
public class EmployeeControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private EmployeeService employeeService;

	Employee mockEmployee = new Employee("Venky", 100000, 1);

	@Test
	public void getEmployee() throws Exception {
		Mockito.when(employeeService.getEmployee(Mockito.anyInt())).thenReturn(mockEmployee);

		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/employees/1").accept(MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();

		System.out.println(result.getResponse());
		String expected = "{id:1,name:Venky, salary:100000.0}";

		JSONAssert.assertEquals(expected, result.getResponse().getContentAsString(), false);
	}

}
