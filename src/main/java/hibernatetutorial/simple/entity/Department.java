package hibernatetutorial.simple.entity;

import java.sql.Date;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "DEPT")
public class Department {
	@EmbeddedId
	@AttributeOverrides({
	      @AttributeOverride(name="projectCode", column = @Column(name="PROJ_CD")),
	      @AttributeOverride(name="name", column = @Column(name="DEPT_NAME"))
	    })
	private DepartmentPk id;

	@Column(name = "START_DATE")
	private Date startDate;

	@Column(name = "TYPE")
	private String type;

	public DepartmentPk getId() {
		return id;
	}

	public void setId(DepartmentPk id) {
		this.id = id;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

}
