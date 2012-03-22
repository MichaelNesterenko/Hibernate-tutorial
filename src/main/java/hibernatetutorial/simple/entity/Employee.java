package hibernatetutorial.simple.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

@Entity
@Table(name = "EMPLOYEE")
public class Employee {
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "autogen")
	@TableGenerator(name = "autogen", initialValue = 1, allocationSize = 1, table = "hibernate_sequence")
	@Column(name = "PSNO")
	private Integer id;

	@Column(name = "NAME")
	private String name;

	@Column(name = "PASS")
	private String pass;

	@ManyToOne
	@JoinColumns({@JoinColumn(referencedColumnName = "PROJ_CD", name = "PROJ_CD"),
			@JoinColumn(name = "DEPT_NAME", referencedColumnName = "DEPT_NAME")})
	private Department department;

	public Integer getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}
}
