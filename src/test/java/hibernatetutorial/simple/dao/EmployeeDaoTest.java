package hibernatetutorial.simple.dao;

import static org.junit.Assert.assertEquals;
import hibernatetutorial.simple.entity.Department;
import hibernatetutorial.simple.entity.Employee;
import hibernatetutorial.simple.factory.HibernateUtil;

import org.hibernate.Session;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class EmployeeDaoTest {
	private Session session;
	private EmployeeDao dao;
	private DepartmentDao depDao;

	@Before
	public void setUp() {
		session = HibernateUtil.createSession();
		dao = new EmployeeDao(session);
		depDao = new DepartmentDao(session);
	}

	@After
	public void tearDown() {
		if (session != null) {
			session.close();
		}
	}

	@Test
	public void createNewEmployee() {
		session.beginTransaction();
			long totalDepartments = depDao.getTotalCount();
			Department d = depDao.getAll((int) (totalDepartments * Math.random()), 1).get(0);
			Employee e = new Employee();
			e.setName("I am created at " + new java.util.Date());
			e.setPass("my pass");
			e.setDepartment(d);

			long totalEmployees = dao.getTotalCount();
			dao.saveOrUpdate(e);

			assertEquals(totalEmployees + 1, dao.getTotalCount());
		session.getTransaction().commit();
	}
}
