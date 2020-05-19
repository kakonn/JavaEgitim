package com.kadir.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.kadir.entity.Department;
import com.kadir.entity.Employees;
import com.kadir.entity.ExcludeProxiedFields;
import com.kadir.entity.Job;
import com.kadir.service.EmployeeService;

@Controller
@RequestMapping("/employee")
public class EmployeeController {

	@Autowired
	EmployeeService employeeService;

	private int salar;

	@GetMapping("/list")
	public String employeeList(Model model, HttpSession oturum, ModelMap modelMap) {

		String oturumEmail = (String) oturum.getAttribute("oturumIsim");

		if (oturumEmail == null) {
			// modelMap.put("giris", "Hop");
			return "redirect:/user/login";
		} else {

			List<Employees> empList = employeeService.getEmployees();
			// List<Employees> araList = employeeService.getAraEmployee();
			// System.out.println("dfa"+ employee);
		
			model.addAttribute("employees", empList);
		
			Employees employee1 = new Employees();
			model.addAttribute("ara", employee1);

			return "employee-list";
		}
	}

	@PostMapping("/search")
	public String EmployeeAra(@ModelAttribute("ara") Employees employee, Model model) {

		List<Employees> empList = employeeService.getAraEmployee(employee);
		model.addAttribute("employees", empList);
		return "employee-list";

	}

	@GetMapping("/employee-ekle")
	public String employeeEkle(Model model, HttpSession oturum) {
		String oturumEmail = (String) oturum.getAttribute("oturumIsim");

		if (oturumEmail == null) {
			// modelMap.put("giris", "Hop");
			return "redirect:/user/login";
		} else {
			Employees employee = new Employees();
			model.addAttribute("employee", employee);
			return "employee-form";
		}
	}

	@GetMapping("/employee-guncelle")
	public String employeeUpdate(@RequestParam("employeeId") int employeeId, Model model, HttpSession oturum) {

		String oturumEmail = (String) oturum.getAttribute("oturumIsim");

		if (oturumEmail == null) {
			// modelMap.put("giris", "Hop");
			return "redirect:/user/login";
		} else {
			Employees employee = employeeService.getEmployee(employeeId);

			model.addAttribute("employee", employee);

			return "employee-update";
		}
	}

	@GetMapping("/employee-delete")
	public String employeeDelete(@RequestParam("employeeId") int employeeId, HttpSession oturum) {

		String oturumEmail = (String) oturum.getAttribute("oturumIsim");

		if (oturumEmail == null) {
			// modelMap.put("giris", "Hop");
			return "redirect:/user/login";
		} else {
			employeeService.deleteEmployee(employeeId);

			return "redirect:/employee/list";
		}
	}

	@ResponseBody
	@GetMapping("load/{id}")
	public String loadManager(@PathVariable("id") int id) {
		Gson gson = new GsonBuilder().setExclusionStrategies(new ExcludeProxiedFields()).create();
		// employeeService.findByManager(id).clear();
		// System.out.println(employeeService.findByManager(id)+"dgsfgsfbcvcggetgr");

		if (!employeeService.findByManager(id).isEmpty()) {
			// System.out.println("asdasdgdagfg"+employeeService.findByManager(id).get(0).getSalary());
			setSalar(employeeService.findByManager(id).get(0).getSalary());
		}
		return gson.toJson(employeeService.findByManager(id));

	}

	@PostMapping("/employee-kaydet")
	public String employeeSaveOrUpdate(@ModelAttribute("employee") @Valid Employees employee,
			BindingResult bindingResult, ModelMap modelMap) {
		if (bindingResult.hasErrors()) {
			return "employee-form";
		}
		System.out.println("empamn "+employee.getManager().getSalary());
		List<Employees> empList = employeeService.getEmployees();
		
		
				for (Employees employees : empList) {
				if (employee.getEmail().equals(employees.getEmail())) {

					modelMap.put("lastna", "Uniqie key");
					return "employee-form";
				}
			
		}
		if (employee.getManager() == null) {
			employeeService.saveOrUpdate(employee);
			
			return "redirect:/employee/list";
		} else {
			if (employee != null && (employee.getSalary() < getSalar())) {

				employeeService.saveOrUpdate(employee);

				return "redirect:/employee/list";
			} else {
				modelMap.put("error", "Yavaaaaþþþþþþ");
				return "employee-form";
			}
		}
	}
	@PostMapping("/employee-update")
	public String employeeUpdate(@ModelAttribute("employee") @Valid Employees employee,
			BindingResult bindingResult, ModelMap modelMap) {
		if (bindingResult.hasErrors()) {
			return "employee-update";
		}
		
		if (employee.getManager() == null) {
			employeeService.saveOrUpdate(employee);
			
			return "redirect:/employee/list";
		} else {
			if (employee != null && (employee.getSalary() < getSalar())) {

				employeeService.saveOrUpdate(employee);

				return "redirect:/employee/list";
			} else {
				modelMap.put("error", "Yavaaaaþþþþþþ");
				return "employee-update";
			}
		}
	}
	
	@ModelAttribute("jobs")
	public Map<String, String> getJobs() {

		List<Job> jobList = employeeService.getJobs();
		Map<String, String> jobbs = new HashMap<String, String>();
		for (Job job : jobList) {
			jobbs.put(job.getJobId(), job.getJobTitle());
		}

		return jobbs;
	}

	@ModelAttribute("departments")
	public Map<Integer, String> getDepartment() {

		List<Department> depList = employeeService.getDepartments();
		Map<Integer, String> depts = new HashMap<Integer, String>();
		for (Department department : depList) {
			// if (department.getManager() != null)
			depts.put(department.getDepartmentId(), department.getDepartmentName());
		}

		return depts;
	}

	/*
	 * @ModelAttribute("employees") public List<Employees> getEmployee(Employees
	 * employee) { // EmployeeAramaMotoru araEmployee = null; if
	 * (employee.getFirstName()==null) { List<Employees> empList =
	 * employeeService.getEmployees(); return empList; } else {
	 * 
	 * return empList; }
	 * 
	 * }
	 */
	public int getSalar() {
		return salar;
	}

	public void setSalar(int salar) {
		this.salar = salar;
	}
}
