package com.project.springmvc.model;
import java.io.Serializable;
import javax.persistence.*;

import org.hibernate.validator.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.Date;
import java.util.List;


/**
 * The persistent class for the batch database table.
 * 
 */
@Entity
@Table(name="batch")
public class Batch implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="batch_id")
	private Integer batchId;

	@NotEmpty
	@Temporal(TemporalType.DATE)
	@Column(name="batch_end_date",nullable=false)
	private Date batchEndDate;

	@NotEmpty
	@Column(name="batch_location",unique=true,nullable=false)
	private String batchLocation;

	@NotEmpty
	@Column(name="batch_name",unique=true,nullable=false)
	private String batchName;

	@NotEmpty
	@Temporal(TemporalType.DATE)
	@Column(name="batch_start_date",nullable=false)
	private Date batchStartDate;

	
	@NotEmpty
	@Column(name="batch_type",unique=true,nullable=false)
	private String batchType;

	@Temporal(TemporalType.DATE)
	private Date created;

	@Temporal(TemporalType.DATE)
	private Date modified;

	//bi-directional many-to-one association to Admin
	@ManyToOne
	@JoinColumn(name="created_by")
	private Admin admin1;

	//bi-directional many-to-one association to Admin
	@ManyToOne
	
	@JoinColumn(name="modified_by")
	private Admin admin2;

	//bi-directional many-to-one association to BatchEmployee
	@JsonIgnore
	@OneToMany(mappedBy="batch",fetch = FetchType.EAGER, cascade={CascadeType.ALL})
	private List<BatchEmployee> batchEmployees;

	//bi-directional many-to-one association to BatchTechnology
	@OneToMany(mappedBy="batch",fetch = FetchType.EAGER, cascade={CascadeType.ALL})
	private List<BatchTechnology> batchTechnologies;

	//bi-directional many-to-one association to Session
	@JsonIgnore
	@OneToMany(mappedBy="batch",fetch = FetchType.EAGER, cascade={CascadeType.ALL})
	private List<TMSSession> sessions;

	public Batch() {
	}

	public int getBatchId() {
		return this.batchId;
	}

	public void setBatchId(int batchId) {
		this.batchId = batchId;
	}

	public Date getBatchEndDate() {
		return this.batchEndDate;
	}

	public void setBatchEndDate(Date batchEndDate) {
		this.batchEndDate = batchEndDate;
	}

	public String getBatchLocation() {
		return this.batchLocation;
	}

	public void setBatchLocation(String batchLocation) {
		this.batchLocation = batchLocation;
	}

	public String getBatchName() {
		return this.batchName;
	}

	public void setBatchName(String batchName) {
		this.batchName = batchName;
	}

	public Date getBatchStartDate() {
		return this.batchStartDate;
	}

	public void setBatchStartDate(Date batchStartDate) {
		this.batchStartDate = batchStartDate;
	}

	public String getBatchType() {
		return this.batchType;
	}

	public void setBatchType(String batchType) {
		this.batchType = batchType;
	}

	public Date getCreated() {
		return this.created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	public Date getModified() {
		return this.modified;
	}

	public void setModified(Date modified) {
		this.modified = modified;
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

	public List<BatchEmployee> getBatchEmployees() {
		return this.batchEmployees;
	}

	public void setBatchEmployees(List<BatchEmployee> batchEmployees) {
		this.batchEmployees = batchEmployees;
	}

	public BatchEmployee addBatchEmployee(BatchEmployee batchEmployee) {
		getBatchEmployees().add(batchEmployee);
		batchEmployee.setBatch(this);

		return batchEmployee;
	}

	public BatchEmployee removeBatchEmployee(BatchEmployee batchEmployee) {
		getBatchEmployees().remove(batchEmployee);
		batchEmployee.setBatch(null);

		return batchEmployee;
	}

	public List<BatchTechnology> getBatchTechnologies() {
		return this.batchTechnologies;
	}

	public void setBatchTechnologies(List<BatchTechnology> batchTechnologies) {
		this.batchTechnologies = batchTechnologies;
	}

	public BatchTechnology addBatchTechnology(BatchTechnology batchTechnology) {
		getBatchTechnologies().add(batchTechnology);
		batchTechnology.setBatch(this);

		return batchTechnology;
	}

	public BatchTechnology removeBatchTechnology(BatchTechnology batchTechnology) {
		getBatchTechnologies().remove(batchTechnology);
		batchTechnology.setBatch(null);

		return batchTechnology;
	}

	public List<TMSSession> getSessions() {
		return this.sessions;
	}

	public void setSessions(List<TMSSession> sessions) {
		this.sessions = sessions;
	}

	public TMSSession addSession(TMSSession session) {
		getSessions().add(session);
		session.setBatch(this);

		return session;
	}

	public TMSSession removeSession(TMSSession session) {
		getSessions().remove(session);
		session.setBatch(null);

		return session;
	}
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((admin1 == null) ? 0 : admin1.hashCode());
		result = prime * result + ((admin2 == null) ? 0 : admin2.hashCode());
		result = prime * result + ((batchEmployees == null) ? 0 : batchEmployees.hashCode());
		result = prime * result + ((batchEndDate == null) ? 0 : batchEndDate.hashCode());
		result = prime * result + ((batchId == null) ? 0 : batchId.hashCode());
		result = prime * result + ((batchLocation == null) ? 0 : batchLocation.hashCode());
		result = prime * result + ((batchName == null) ? 0 : batchName.hashCode());
		result = prime * result + ((batchStartDate == null) ? 0 : batchStartDate.hashCode());
		result = prime * result + ((batchTechnologies == null) ? 0 : batchTechnologies.hashCode());
		result = prime * result + ((batchType == null) ? 0 : batchType.hashCode());
		result = prime * result + ((created == null) ? 0 : created.hashCode());
		result = prime * result + ((modified == null) ? 0 : modified.hashCode());
		result = prime * result + ((sessions == null) ? 0 : sessions.hashCode());
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
		Batch other = (Batch) obj;
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
		if (batchEndDate == null) {
			if (other.batchEndDate != null)
				return false;
		} else if (!batchEndDate.equals(other.batchEndDate))
			return false;
		if (batchId == null) {
			if (other.batchId != null)
				return false;
		} else if (!batchId.equals(other.batchId))
			return false;
		if (batchLocation == null) {
			if (other.batchLocation != null)
				return false;
		} else if (!batchLocation.equals(other.batchLocation))
			return false;
		if (batchName == null) {
			if (other.batchName != null)
				return false;
		} else if (!batchName.equals(other.batchName))
			return false;
		if (batchStartDate == null) {
			if (other.batchStartDate != null)
				return false;
		} else if (!batchStartDate.equals(other.batchStartDate))
			return false;
		if (batchTechnologies == null) {
			if (other.batchTechnologies != null)
				return false;
		} else if (!batchTechnologies.equals(other.batchTechnologies))
			return false;
		if (batchType == null) {
			if (other.batchType != null)
				return false;
		} else if (!batchType.equals(other.batchType))
			return false;
		if (created == null) {
			if (other.created != null)
				return false;
		} else if (!created.equals(other.created))
			return false;
		if (modified == null) {
			if (other.modified != null)
				return false;
		} else if (!modified.equals(other.modified))
			return false;
		if (sessions == null) {
			if (other.sessions != null)
				return false;
		} else if (!sessions.equals(other.sessions))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Batch [batchId=" + batchId + ", batchEndDate=" + batchEndDate + ", batchLocation=" + batchLocation
				+ ", batchName=" + batchName + ", batchStartDate=" + batchStartDate + ", batchType=" + batchType
				+ ", created=" + created + ", modified=" + modified + ", admin1=" + admin1 + ", admin2=" + admin2
				+ ", batchEmployees=" + batchEmployees + ", batchTechnologies=" + batchTechnologies + ", sessions="
				+ sessions + "]";
	}
	
	

}