package com.project.springmvc.model;

import java.io.Serializable;
import javax.persistence.*;
import org.hibernate.validator.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.List;


/**
 * The persistent class for the technology database table.
 * 
 */
@Entity
@Table(name="technology")
public class Technology implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="tech_id")
	private Integer techId;

	@NotEmpty
	@Column(name="tech_name",nullable=false)
	private String techName;

	//bi-directional many-to-one association to BatchTechnology
	@JsonIgnore
	@OneToMany(mappedBy="technology",fetch = FetchType.EAGER, cascade={CascadeType.ALL})
	private List<BatchTechnology> batchTechnologies;

	//bi-directional many-to-one association to Session
	@JsonIgnore
	@OneToMany(mappedBy="technology",fetch = FetchType.EAGER, cascade={CascadeType.ALL})
	private List<TMSSession> sessions;

	//bi-directional many-to-one association to TrainerTechnology
	@JsonIgnore
	@OneToMany(mappedBy="technology",fetch = FetchType.EAGER, cascade={CascadeType.ALL})
	private List<TrainerTechnology> trainerTechnologies;

	public Technology() {
	}

	public int getTechId() {
		return this.techId;
	}

	public void setTechId(int techId) {
		this.techId = techId;
	}

	public String getTechName() {
		return this.techName;
	}

	public void setTechName(String techName) {
		this.techName = techName;
	}

	public List<BatchTechnology> getBatchTechnologies() {
		return this.batchTechnologies;
	}

	public void setBatchTechnologies(List<BatchTechnology> batchTechnologies) {
		this.batchTechnologies = batchTechnologies;
	}

	public BatchTechnology addBatchTechnology(BatchTechnology batchTechnology) {
		getBatchTechnologies().add(batchTechnology);
		batchTechnology.setTechnology(this);

		return batchTechnology;
	}

	public BatchTechnology removeBatchTechnology(BatchTechnology batchTechnology) {
		getBatchTechnologies().remove(batchTechnology);
		batchTechnology.setTechnology(null);

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
		session.setTechnology(this);

		return session;
	}

	public TMSSession removeSession(TMSSession session) {
		getSessions().remove(session);
		session.setTechnology(null);

		return session;
	}

	public List<TrainerTechnology> getTrainerTechnologies() {
		return this.trainerTechnologies;
	}

	public void setTrainerTechnologies(List<TrainerTechnology> trainerTechnologies) {
		this.trainerTechnologies = trainerTechnologies;
	}

	public TrainerTechnology addTrainerTechnology(TrainerTechnology trainerTechnology) {
		getTrainerTechnologies().add(trainerTechnology);
		trainerTechnology.setTechnology(this);

		return trainerTechnology;
	}

	public TrainerTechnology removeTrainerTechnology(TrainerTechnology trainerTechnology) {
		getTrainerTechnologies().remove(trainerTechnology);
		trainerTechnology.setTechnology(null);

		return trainerTechnology;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((batchTechnologies == null) ? 0 : batchTechnologies.hashCode());
		result = prime * result + ((sessions == null) ? 0 : sessions.hashCode());
		result = prime * result + ((techId == null) ? 0 : techId.hashCode());
		result = prime * result + ((techName == null) ? 0 : techName.hashCode());
		result = prime * result + ((trainerTechnologies == null) ? 0 : trainerTechnologies.hashCode());
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
		Technology other = (Technology) obj;
		if (batchTechnologies == null) {
			if (other.batchTechnologies != null)
				return false;
		} else if (!batchTechnologies.equals(other.batchTechnologies))
			return false;
		if (sessions == null) {
			if (other.sessions != null)
				return false;
		} else if (!sessions.equals(other.sessions))
			return false;
		if (techId == null) {
			if (other.techId != null)
				return false;
		} else if (!techId.equals(other.techId))
			return false;
		if (techName == null) {
			if (other.techName != null)
				return false;
		} else if (!techName.equals(other.techName))
			return false;
		if (trainerTechnologies == null) {
			if (other.trainerTechnologies != null)
				return false;
		} else if (!trainerTechnologies.equals(other.trainerTechnologies))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Technology [techId=" + techId + ", techName=" + techName + ", batchTechnologies=" + batchTechnologies
				+ ", sessions=" + sessions + ", trainerTechnologies=" + trainerTechnologies + "]";
	}
	
	
}