package com.kadir.rest;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kadir.domain.Employee;

@RestController
@RequestMapping("/employee")
public class EmployeeRestController {

	// alt 1
	/*
	 * static List<Employee> employees = new ArrayList<Employee>();
	 * 
	 * static { employees.add(new Employee("Kadir", "Kondur")); employees.add(new
	 * Employee("Ali", "Can")); employees.add(new Employee("Ayse", "Ayseli"));
	 * employees.add(new Employee("Murat", "Muratlý")); }
	 */

	// alt 2
	List<Employee> employees;

	@PostConstruct
	public void loadData() {
		employees = new ArrayList<Employee>();
		employees.add(new Employee("Kadir", "Kondur"));
		employees.add(new Employee("Ali", "Can"));
		employees.add(new Employee("Ayse", "Ayseli"));
		employees.add(new Employee("Murat", "Muratlý"));
	}

	@GetMapping("/mrb")
	public String merhaba() {
		return "merhaba";
	}

	@GetMapping("/emp")
	public Employee emp() {

		Employee man = new Employee("Ali", "Can");
		Employee emp = new Employee("Kadir", "Kondur");
		emp.setManager(man);
		return emp;

	}

	@GetMapping("/emps")
	public List<Employee> emps() {

		return employees;
		/*
		 * Employee man = new Employee("Ali","Can"); Employee emp = new
		 * Employee("Kadir","Kondur");
		 * 
		 * 
		 * List<Employee> emps = new ArrayList<Employee>(); emp.setManager(man);
		 * emps.add(emp); emps.add(man); emps.add(new Employee("Ayþe", "Ayþe"));
		 * 
		 * return emps;
		 */

	}

	@GetMapping("/emps/{indeks}")
	public Employee getEmp(@PathVariable int indeks) {
		if (indeks >= employees.size() || indeks < 0) {
			if(indeks==5)
				throw new RuntimeException("Olmaz olsun böyle hata");
			
			throw new EmployeeNotFoundException("Böyle bir employee id mevcut degil : " + indeks);

		}

			
		
			return employees.get(indeks);

	}
	
	@ExceptionHandler
	public ResponseEntity<EmployeeErrorResponse> hataYakala(EmployeeNotFoundException exc){
		EmployeeErrorResponse hata = new EmployeeErrorResponse();
		
		hata.setStatus(HttpStatus.NOT_FOUND.value());
		hata.setMessage(exc.getMessage());
		
		return new ResponseEntity<>(hata,HttpStatus.NOT_FOUND);
	}
	
	
	
}
