package com.kadir.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kadir.dao.EmployeeDAO;
import com.kadir.entity.Department;
import com.kadir.entity.Employees;
import com.kadir.entity.Job;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO {

	@Autowired
	SessionFactory sessionFactory;

	@Override
	public List<Employees> getOgrenciler() {

		Session session = sessionFactory.getCurrentSession();

		Query<Employees> query = session.createQuery("from Employees", Employees.class);
		List<Employees> resultList = query.getResultList();
		/*
		 * Department department = session.get(Department.class,
		 * resultList.getDepartment().getDepartmentId());
		 * System.out.println(department);
		 * 
		 * Job job = session.get(Job.class, resultList.getJob().getJobId());
		 * System.out.println(job); System.out.println("employee " + resultList);
		 */

		/*Query<Job> query2 = session.createQuery("from Job", Job.class);
		@SuppressWarnings("unused")
		List<Job> resultList2 = query2.getResultList();

		Query<Department> query3 = session.createQuery("from Department", Department.class);
		@SuppressWarnings("unused")
		List<Department> resultList3 = query3.getResultList();
*/
		return resultList;
	}

	@Override
	public List<Department> getDepartments() {
		Session session = sessionFactory.getCurrentSession();

		Query<Department> query = session.createQuery("from Department", Department.class);
		List<Department> resultList = query.getResultList();

		return resultList;
	}

	@Override
	public List<Job> getJobs() {
		Session session = sessionFactory.getCurrentSession();

		Query<Job> query = session.createQuery("from Job", Job.class);
		List<Job> resultList = query.getResultList();

		return resultList;
	}

	@Override
	public void saveOrUpdate(Employees employee) {
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(employee);

	}

	@Override
	public List<Employees> findByManager(int id) {

		Session session = sessionFactory.getCurrentSession();
		/*
		 * Query<Employees> query3 = session.createQuery("from Employees",
		 * Employees.class);
		 * 
		 * @SuppressWarnings("unused") List<Employees> resultList =
		 * query3.getResultList();
		 */
		Integer managerId = 0;
		Query<Department> query = session.createQuery("from Department where departmentId= :id", Department.class)
				.setParameter("id", id);
		List<Department> resultList1 = query.getResultList();
		// System.out.println(resultList1);

		for (Department department : resultList1) {
			if (department.getManager() != null)
				managerId = department.getManager().getEmployeeId();
		}
		if (managerId == null) {
			return null;
		} else {

			Query<Employees> query2 = session
					.createQuery("from Employees where employeeId= :managerId", Employees.class)
					.setParameter("managerId", managerId);
			List<Employees> resultList2 = query2.getResultList();

			// System.out.println("manager " + resultList2.toString());

			return resultList2;
		}
	}

	@Override
	public Employees getEmployee(int employeeId) {
		Session session = sessionFactory.getCurrentSession();
		Employees employee = session.get(Employees.class, employeeId);

		return employee;
	}

	@Override
	public void deleteEmployee(int employeeId) {
		Session session = sessionFactory.getCurrentSession();
		Employees employee = session.get(Employees.class, employeeId);
		session.delete(employee);
	}

	@Override
	public List<Employees> getAraEmployee(Employees employee) {
		Session session = sessionFactory.getCurrentSession();

		Query<Employees> query = session.createQuery(
				"from Employees e where 1=1 and e.firstName like :araEmpFirstName and e.manager.firstName like  :araManagerFirstName"
				+ " and e.job.jobTitle like :job and e.lastName like :lastName and e.phoneNumber like :phone",
				Employees.class).setParameter("araEmpFirstName", '%' + employee.getFirstName() + '%')
				.setParameter("araManagerFirstName", '%' + employee.getManager().getFirstName() + '%')
				.setParameter("job", '%' + employee.getJob().getJobTitle() + '%')
				.setParameter("lastName", '%' + employee.getLastName() + '%')
				.setParameter("phone", '%' + employee.getPhoneNumber() + '%');
				//.setParameter("dept", employee.getDepartment().getDepartmentName())

		List<Employees> resultList = query.getResultList();
		System.out.println(resultList + "arama");
		return resultList;
	}

}
