package hibernatetutorial.simple.entity;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class DepartmentPk implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1520790276999574193L;

	private String projectCode;
	private String name;

	public DepartmentPk() {
	}

	public DepartmentPk(final String projCode, final String depName) {
		projectCode = projCode;
		name = depName;
	}

	public String getProjectCode() {
		return projectCode;
	}
	public void setProjectCode(String projectCode) {
		this.projectCode = projectCode;
	}
	public String getName() {
		return name;
	}
	public void setName(String deptName) {
		this.name = deptName;
	}

	@Override
	public boolean equals(final Object o) {
		if (!(o instanceof DepartmentPk)) {
			return false;
		}
		DepartmentPk od = (DepartmentPk) o;
		return (od.name == name || name != null && name.equals(od.name))
				&& (od.projectCode == projectCode || projectCode != null && projectCode.equals(od.projectCode));
	}

	@Override
	public int hashCode() {
		return (projectCode == null ? 0 : projectCode.hashCode()) ^ (name == null ? 0 : name.hashCode());
	}
}
