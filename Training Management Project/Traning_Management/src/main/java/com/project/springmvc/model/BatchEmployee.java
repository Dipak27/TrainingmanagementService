package com.project.springmvc.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the batch_employee database table.
 * 
 */
@Entity
@Table(name="batch_employee")
public class BatchEmployee implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="batch_emp_id")
	private Integer batchEmpId;

	//bi-directional many-to-one association to Batch
	@ManyToOne
	@JoinColumn(name="batch_id")
	private Batch batch;

	//bi-directional many-to-one association to Employee
	@ManyToOne
	@JoinColumn(name="emp_id")
	private Employee employee;

	public BatchEmployee() {
	}

	public int getBatchEmpId() {
		return this.batchEmpId;
	}

	public void setBatchEmpId(int batchEmpId) {
		this.batchEmpId = batchEmpId;
	}

	public Batch getBatch() {
		return this.batch;
	}

	public void setBatch(Batch batch) {
		this.batch = batch;
	}

	public Employee getEmployee() {
		return this.employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((batch == null) ? 0 : batch.hashCode());
		result = prime * result + ((batchEmpId == null) ? 0 : batchEmpId.hashCode());
		result = prime * result + ((employee == null) ? 0 : employee.hashCode());
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
		BatchEmployee other = (BatchEmployee) obj;
		if (batch == null) {
			if (other.batch != null)
				return false;
		} else if (!batch.equals(other.batch))
			return false;
		if (batchEmpId == null) {
			if (other.batchEmpId != null)
				return false;
		} else if (!batchEmpId.equals(other.batchEmpId))
			return false;
		if (employee == null) {
			if (other.employee != null)
				return false;
		} else if (!employee.equals(other.employee))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "BatchEmployee [batchEmpId=" + batchEmpId + ", batch=" + batch + ", employee=" + employee + "]";
	}

	
}