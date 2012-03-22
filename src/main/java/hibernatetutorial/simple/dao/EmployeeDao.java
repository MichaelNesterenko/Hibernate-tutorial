package hibernatetutorial.simple.dao;

import org.hibernate.Session;

import hibernatetutorial.simple.entity.Employee;

public class EmployeeDao extends GenericDao<Employee, Long> {

	public EmployeeDao(Session s) {
		super(s, Employee.class);
	}

}
