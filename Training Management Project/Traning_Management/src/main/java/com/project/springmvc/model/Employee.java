package com.project.springmvc.model;

import java.io.Serializable;
import javax.persistence.*;

import org.hibernate.validator.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.Date;
import java.util.List;


/**
 * The persistent class for the employee database table.
 * 
 */
@Entity
@Table(name="employee")
public class Employee implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="emp_id")
	private Integer empId;

	@Temporal(TemporalType.DATE)
	private Date created;
	
	@NotEmpty
	@Column(name="emp_email_id",unique=true,nullable=false)
	private String empEmailId;

	@NotEmpty
	@Column(name="emp_location",unique=true,nullable=false)
	private String empLocation;

	@NotEmpty
	@Column(name="emp_name",unique=true,nullable=false)
	private String empName;

	@NotEmpty
	@Column(name="emp_password",unique=true,nullable=false)
	private String empPassword;

	@Temporal(TemporalType.DATE)
	private Date modified;

	//bi-directional many-to-one association to BatchEmployee
	@JsonIgnore
	@OneToMany(mappedBy="employee",fetch = FetchType.EAGER, cascade={CascadeType.ALL})
	private List<BatchEmployee> batchEmployees;

	//bi-directional many-to-one association to Admin
	@ManyToOne
	@JoinColumn(name="created_by")
	private Admin admin1;

	//bi-directional many-to-one association to Admin
	@ManyToOne
	@JoinColumn(name="modified_by")
	private Admin admin2;

	public Employee() {
	}

	public int getEmpId() {
		return this.empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public Date getCreated() {
		return this.created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	public String getEmpEmailId() {
		return this.empEmailId;
	}

	public void setEmpEmailId(String empEmailId) {
		this.empEmailId = empEmailId;
	}

	public String getEmpLocation() {
		return this.empLocation;
	}

	public void setEmpLocation(String empLocation) {
		this.empLocation = empLocation;
	}

	public String getEmpName() {
		return this.empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public String getEmpPassword() {
		return this.empPassword;
	}

	public void setEmpPassword(String empPassword) {
		this.empPassword = empPassword;
	}

	public Date getModified() {
		return this.modified;
	}

	public void setModified(Date modified) {
		this.modified = modified;
	}

	public List<BatchEmployee> getBatchEmployees() {
		return this.batchEmployees;
	}

	public void setBatchEmployees(List<BatchEmployee> batchEmployees) {
		this.batchEmployees = batchEmployees;
	}

	public BatchEmployee addBatchEmployee(BatchEmployee batchEmployee) {
		getBatchEmployees().add(batchEmployee);
		batchEmployee.setEmployee(this);

		return batchEmployee;
	}

	public BatchEmployee removeBatchEmployee(BatchEmployee batchEmployee) {
		getBatchEmployees().remove(batchEmployee);
		batchEmployee.setEmployee(null);

		return batchEmployee;
	}

	public Admin getAdmin1() {
		return this.admin1;
	}

	public void setAdmin1(Admin admin1) {
		this.admin1 = admin1;
	}

	public Admin getAdmin2() {
		return this.admin2;
	}

	public void setAdmin2(Admin admin2) {
		this.admin2 = admin2;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((admin1 == null) ? 0 : admin1.hashCode());
		result = prime * result + ((admin2 == null) ? 0 : admin2.hashCode());
		result = prime * result + ((batchEmployees == null) ? 0 : batchEmployees.hashCode());
		result = prime * result + ((created == null) ? 0 : created.hashCode());
		result = prime * result + ((empEmailId == null) ? 0 : empEmailId.hashCode());
		result = prime * result + ((empId == null) ? 0 : empId.hashCode());
		result = prime * result + ((empLocation == null) ? 0 : empLocation.hashCode());
		result = prime * result + ((empName == null) ? 0 : empName.hashCode());
		result = prime * result + ((empPassword == null) ? 0 : empPassword.hashCode());
		result = prime * result + ((modified == null) ? 0 : modified.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		if (admin1 == null) {
			if (other.admin1 != null)
				return false;
		} else if (!admin1.equals(other.admin1))
			return false;
		if (admin2 == null) {
			if (other.admin2 != null)
				return false;
		} else if (!admin2.equals(other.admin2))
			return false;
		if (batchEmployees == null) {
			if (other.batchEmployees != null)
				return false;
		} else if (!batchEmployees.equals(other.batchEmployees))
			return false;
		if (created == null) {
			if (other.created != null)
				return false;
		} else if (!created.equals(other.created))
			return false;
		if (empEmailId == null) {
			if (other.empEmailId != null)
				return false;
		} else if (!empEmailId.equals(other.empEmailId))
			return false;
		if (empId == null) {
			if (other.empId != null)
				return false;
		} else if (!empId.equals(other.empId))
			return false;
		if (empLocation == null) {
			if (other.empLocation != null)
				return false;
		} else if (!empLocation.equals(other.empLocation))
			return false;
		if (empName == null) {
			if (other.empName != null)
				return false;
		} else if (!empName.equals(other.empName))
			return false;
		if (empPassword == null) {
			if (other.empPassword != null)
				return false;
		} else if (!empPassword.equals(other.empPassword))
			return false;
		if (modified == null) {
			if (other.modified != null)
				return false;
		} else if (!modified.equals(other.modified))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", created=" + created + ", empEmailId=" + empEmailId + ", empLocation="
				+ empLocation + ", empName=" + empName + ", empPassword=" + empPassword + ", modified=" + modified
				+ ", batchEmployees=" + batchEmployees + ", admin1=" + admin1 + ", admin2=" + admin2 + "]";
	}
	
	

}