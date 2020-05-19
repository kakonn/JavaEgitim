package com.kadir.controller;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kadir.entity.Department;

@Controller
@RequestMapping("/dept")
public class DepartmentController {

	private Department dep;
	private Session session;
	private Department depSorgu;
	private Boolean sorgu = true;

	static {
		System.out.println("S.A");

	}

	@RequestMapping("/showform")
	public String showPersonel(Model model) {

		model.addAttribute("dp", new Department());

		return "department-form";
	}

	@RequestMapping("/showform2")
	public String sorgu(Model model, @ModelAttribute("dp") Department dep) {
		SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(Department.class).buildSessionFactory();

		session = sessionFactory.getCurrentSession();

		session.beginTransaction();

		depSorgu = session.get(Department.class, dep.getDepartmentId());
		if (depSorgu.getDepartmentName() == "") {
		
		//	session.close();
			this.sorgu = true;
		} else {
			this.sorgu = false;
			dep.setDepartmentName(depSorgu.getDepartmentName());
			dep.setLocationId(depSorgu.getLocationId());
			dep.setManagerId(depSorgu.getManagerId());
			// session.getTransaction().commit();
			System.out.println(dep.getLocationId());
		}

		return "department-form";
	}

	@RequestMapping("/showform3")
	public String guncelle(Model model, @ModelAttribute("dp") Department dep) {

		SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(Department.class).buildSessionFactory();

		session = sessionFactory.getCurrentSession();

		session.beginTransaction();

		System.out.println(dep.getDepartmentName());
		depSorgu.setDepartmentName(dep.getDepartmentName());
		depSorgu.setLocationId(dep.getLocationId());
		depSorgu.setManagerId(dep.getManagerId());
		// if(session.beginTransaction().getStatus().equals(TransactionStatus.ACTIVE)) {
		session.getTransaction().commit();
		// }

		return "department-form";
	}

	@RequestMapping("/showform4")
	public String sil(Model model, @ModelAttribute("dp") Department dep) {

		SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(Department.class).buildSessionFactory();

		session = sessionFactory.getCurrentSession();

		session.beginTransaction();

		System.out.println(dep.getDepartmentName());
		depSorgu.setDepartmentName(dep.getDepartmentName());
		depSorgu.setLocationId(dep.getLocationId());
		depSorgu.setManagerId(dep.getManagerId());
		session.delete(depSorgu);
		session.getTransaction().commit();

		return "department-form";
	}

	public Department getDep() {
		return dep;
	}

	public void setDep(Department dep) {
		this.dep = dep;
	}

	public Boolean getSorgu() {
		return sorgu;
	}

	public void setSorgu(Boolean sorgu) {
		this.sorgu = sorgu;
	}

}
