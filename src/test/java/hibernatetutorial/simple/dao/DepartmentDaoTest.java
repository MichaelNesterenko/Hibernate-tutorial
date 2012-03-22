package hibernatetutorial.simple.dao;

import static org.junit.Assert.assertEquals;

import java.sql.Date;
import java.util.UUID;

import hibernatetutorial.simple.entity.Department;
import hibernatetutorial.simple.entity.DepartmentPk;
import hibernatetutorial.simple.entity.Employee;
import hibernatetutorial.simple.factory.HibernateUtil;

import org.hibernate.Session;
import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

public class DepartmentDaoTest {
	private Session session;
	private DepartmentDao dao;

	@Before
	public void setUp() {
		session = HibernateUtil.createSession();
		dao = new DepartmentDao(session);
	}

	@After
	public void tearDown() {
		if (session != null) {
			session.close();
		}
	}

	@Test
	public void createNewDepartment() {
		session.beginTransaction();
			long countBefore = dao.getTotalCount();
			String deptName = UUID.randomUUID().toString();
			String projectCode = UUID.randomUUID().toString();
			String type = UUID.randomUUID().toString();
			Date startDate = new Date(new java.util.Date().getTime());
	
			Department d = new Department();
			d.setId(new DepartmentPk(projectCode, deptName));
			d.setStartDate(startDate);
			d.setType(type);
	
			dao.saveOrUpdate(d);
			long countAfter = dao.getTotalCount();
			assertEquals(countBefore + 1, countAfter);
		session.getTransaction().commit();
	}
}
