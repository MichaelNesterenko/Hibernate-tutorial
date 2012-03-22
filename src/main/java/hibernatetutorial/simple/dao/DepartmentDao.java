package hibernatetutorial.simple.dao;

import org.hibernate.Session;

import hibernatetutorial.simple.entity.Department;
import hibernatetutorial.simple.entity.DepartmentPk;

public class DepartmentDao extends GenericDao<Department, DepartmentPk>{

	public DepartmentDao(Session s) {
		super(s, Department.class);
	}

}
