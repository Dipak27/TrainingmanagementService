package com.project.springmvc.model;

import java.io.Serializable;
import javax.persistence.*;
import org.hibernate.validator.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.List;


/**
 * The persistent class for the admin database table.
 * 
 */
@Entity
@Table(name="admin")
public class Admin implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="admin_id")
	private Integer adminId;

	@NotEmpty
	@Column(name="admin_email_id",unique=true,nullable=false)
	private String adminEmailId;

	@NotEmpty
	@Column(name="admin_name",unique=true,nullable=false)
	private String adminName;

	@NotEmpty
	@Column(name="admin_password",unique=true,nullable=false)
	private String adminPassword;

	//bi-directional many-to-one association to Batch
	@JsonIgnore
	@OneToMany(mappedBy="admin1",fetch = FetchType.EAGER, cascade={CascadeType.ALL})
	private List<Batch> batches1;

	//bi-directional many-to-one association to Batch
	@JsonIgnore
	@OneToMany(mappedBy="admin2",fetch = FetchType.EAGER, cascade={CascadeType.ALL})
	private List<Batch> batches2;

	//bi-directional many-to-one association to Employee
	@JsonIgnore
	@OneToMany(mappedBy="admin1",fetch = FetchType.EAGER, cascade={CascadeType.ALL})
	private List<Employee> employees1;

	//bi-directional many-to-one association to Employee
	@JsonIgnore
	@OneToMany(mappedBy="admin2",fetch = FetchType.EAGER, cascade={CascadeType.ALL})
	private List<Employee> employees2;

	//bi-directional many-to-one association to Session
	@JsonIgnore
	@OneToMany(mappedBy="admin1",fetch = FetchType.EAGER, cascade={CascadeType.ALL})
	private List<TMSSession> sessions1;

	//bi-directional many-to-one association to Session
	@JsonIgnore
	@OneToMany(mappedBy="admin2",fetch = FetchType.EAGER, cascade={CascadeType.ALL})
	private List<TMSSession> sessions2;

	//bi-directional many-to-one association to Trainer
	@JsonIgnore
	@OneToMany(mappedBy="admin1",fetch = FetchType.EAGER, cascade={CascadeType.ALL})
	private List<Trainer> trainers1;

	//bi-directional many-to-one association to Trainer
	@JsonIgnore
	@OneToMany(mappedBy="admin2",fetch = FetchType.EAGER, cascade={CascadeType.ALL})
	private List<Trainer> trainers2;

	public Admin() {
	}

	public int getAdminId() {
		return this.adminId;
	}

	public void setAdminId(int adminId) {
		this.adminId = adminId;
	}

	public String getAdminEmailId() {
		return this.adminEmailId;
	}

	public void setAdminEmailId(String adminEmailId) {
		this.adminEmailId = adminEmailId;
	}

	public String getAdminName() {
		return this.adminName;
	}

	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}

	public String getAdminPassword() {
		return this.adminPassword;
	}

	public void setAdminPassword(String adminPassword) {
		this.adminPassword = adminPassword;
	}

	public List<Batch> getBatches1() {
		return this.batches1;
	}

	public void setBatches1(List<Batch> batches1) {
		this.batches1 = batches1;
	}

	public Batch addBatches1(Batch batches1) {
		getBatches1().add(batches1);
		batches1.setAdmin1(this);

		return batches1;
	}

	public Batch removeBatches1(Batch batches1) {
		getBatches1().remove(batches1);
		batches1.setAdmin1(null);

		return batches1;
	}

	public List<Batch> getBatches2() {
		return this.batches2;
	}

	public void setBatches2(List<Batch> batches2) {
		this.batches2 = batches2;
	}

	public Batch addBatches2(Batch batches2) {
		getBatches2().add(batches2);
		batches2.setAdmin2(this);

		return batches2;
	}

	public Batch removeBatches2(Batch batches2) {
		getBatches2().remove(batches2);
		batches2.setAdmin2(null);

		return batches2;
	}

	public List<Employee> getEmployees1() {
		return this.employees1;
	}

	public void setEmployees1(List<Employee> employees1) {
		this.employees1 = employees1;
	}

	public Employee addEmployees1(Employee employees1) {
		getEmployees1().add(employees1);
		employees1.setAdmin1(this);

		return employees1;
	}

	public Employee removeEmployees1(Employee employees1) {
		getEmployees1().remove(employees1);
		employees1.setAdmin1(null);

		return employees1;
	}

	public List<Employee> getEmployees2() {
		return this.employees2;
	}

	public void setEmployees2(List<Employee> employees2) {
		this.employees2 = employees2;
	}

	public Employee addEmployees2(Employee employees2) {
		getEmployees2().add(employees2);
		employees2.setAdmin2(this);

		return employees2;
	}

	public Employee removeEmployees2(Employee employees2) {
		getEmployees2().remove(employees2);
		employees2.setAdmin2(null);

		return employees2;
	}

	public List<TMSSession> getSessions1() {
		return this.sessions1;
	}

	public void setSessions1(List<TMSSession> sessions1) {
		this.sessions1 = sessions1;
	}

	public TMSSession addSessions1(TMSSession sessions1) {
		getSessions1().add(sessions1);
		sessions1.setAdmin1(this);

		return sessions1;
	}

	public TMSSession removeSessions1(TMSSession sessions1) {
		getSessions1().remove(sessions1);
		sessions1.setAdmin1(null);

		return sessions1;
	}

	public List<TMSSession> getSessions2() {
		return this.sessions2;
	}

	public void setSessions2(List<TMSSession> sessions2) {
		this.sessions2 = sessions2;
	}

	public TMSSession addSessions2(TMSSession sessions2) {
		getSessions2().add(sessions2);
		sessions2.setAdmin2(this);

		return sessions2;
	}

	public TMSSession removeSessions2(TMSSession sessions2) {
		getSessions2().remove(sessions2);
		sessions2.setAdmin2(null);

		return sessions2;
	}

	public List<Trainer> getTrainers1() {
		return this.trainers1;
	}

	public void setTrainers1(List<Trainer> trainers1) {
		this.trainers1 = trainers1;
	}

	public Trainer addTrainers1(Trainer trainers1) {
		getTrainers1().add(trainers1);
		trainers1.setAdmin1(this);

		return trainers1;
	}

	public Trainer removeTrainers1(Trainer trainers1) {
		getTrainers1().remove(trainers1);
		trainers1.setAdmin1(null);

		return trainers1;
	}

	public List<Trainer> getTrainers2() {
		return this.trainers2;
	}

	public void setTrainers2(List<Trainer> trainers2) {
		this.trainers2 = trainers2;
	}

	public Trainer addTrainers2(Trainer trainers2) {
		getTrainers2().add(trainers2);
		trainers2.setAdmin2(this);

		return trainers2;
	}

	public Trainer removeTrainers2(Trainer trainers2) {
		getTrainers2().remove(trainers2);
		trainers2.setAdmin2(null);

		return trainers2;
	}
	
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((adminEmailId == null) ? 0 : adminEmailId.hashCode());
		result = prime * result + ((adminId == null) ? 0 : adminId.hashCode());
		result = prime * result + ((adminName == null) ? 0 : adminName.hashCode());
		result = prime * result + ((adminPassword == null) ? 0 : adminPassword.hashCode());
		result = prime * result + ((batches1 == null) ? 0 : batches1.hashCode());
		result = prime * result + ((batches2 == null) ? 0 : batches2.hashCode());
		result = prime * result + ((employees1 == null) ? 0 : employees1.hashCode());
		result = prime * result + ((employees2 == null) ? 0 : employees2.hashCode());
		result = prime * result + ((sessions1 == null) ? 0 : sessions1.hashCode());
		result = prime * result + ((sessions2 == null) ? 0 : sessions2.hashCode());
		result = prime * result + ((trainers1 == null) ? 0 : trainers1.hashCode());
		result = prime * result + ((trainers2 == null) ? 0 : trainers2.hashCode());
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
		Admin other = (Admin) obj;
		if (adminEmailId == null) {
			if (other.adminEmailId != null)
				return false;
		} else if (!adminEmailId.equals(other.adminEmailId))
			return false;
		if (adminId == null) {
			if (other.adminId != null)
				return false;
		} else if (!adminId.equals(other.adminId))
			return false;
		if (adminName == null) {
			if (other.adminName != null)
				return false;
		} else if (!adminName.equals(other.adminName))
			return false;
		if (adminPassword == null) {
			if (other.adminPassword != null)
				return false;
		} else if (!adminPassword.equals(other.adminPassword))
			return false;
		if (batches1 == null) {
			if (other.batches1 != null)
				return false;
		} else if (!batches1.equals(other.batches1))
			return false;
		if (batches2 == null) {
			if (other.batches2 != null)
				return false;
		} else if (!batches2.equals(other.batches2))
			return false;
		if (employees1 == null) {
			if (other.employees1 != null)
				return false;
		} else if (!employees1.equals(other.employees1))
			return false;
		if (employees2 == null) {
			if (other.employees2 != null)
				return false;
		} else if (!employees2.equals(other.employees2))
			return false;
		if (sessions1 == null) {
			if (other.sessions1 != null)
				return false;
		} else if (!sessions1.equals(other.sessions1))
			return false;
		if (sessions2 == null) {
			if (other.sessions2 != null)
				return false;
		} else if (!sessions2.equals(other.sessions2))
			return false;
		if (trainers1 == null) {
			if (other.trainers1 != null)
				return false;
		} else if (!trainers1.equals(other.trainers1))
			return false;
		if (trainers2 == null) {
			if (other.trainers2 != null)
				return false;
		} else if (!trainers2.equals(other.trainers2))
			return false;
		return true;
	}

	@Override
	public String toString() {
		
		return "Admin [ID=" + adminId + ", EmailId=" + adminEmailId + ", password=" + adminPassword
                + ", Name=" + adminName +"]";
	}

}