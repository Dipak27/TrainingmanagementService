package com.project.springmvc.model;

import java.io.Serializable;
import javax.persistence.*;

import org.hibernate.validator.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.Date;
import java.util.List;


/**
 * The persistent class for the trainer database table.
 * 
 */
@Entity
@Table(name="trainer")
public class Trainer implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="trainer_id")
	private Integer trainerId;

	
	@Temporal(TemporalType.DATE)
	private Date created;

	@Temporal(TemporalType.DATE)
	private Date modified;

	@NotEmpty
	@Column(name="trainer_email_id",nullable=false)
	private String trainerEmailId;

	@NotEmpty
	@Column(name="trainer_location",nullable=false)
	private String trainerLocation;

	@NotEmpty
	@Column(name="trainer_name",nullable=false)
	private String trainerName;

	@NotEmpty
	@Column(name="trainer_password",nullable=false)
	private String trainerPassword;

	//bi-directional many-to-one association to Session
	@JsonIgnore
	@OneToMany(mappedBy="trainer",fetch = FetchType.EAGER)
	private List<TMSSession> sessions;

	//bi-directional many-to-one association to Admin
	@ManyToOne
	@JoinColumn(name="created_by")
	private Admin admin1;

	//bi-directional many-to-one association to Admin
	@ManyToOne
	@JoinColumn(name="modified_by")
	private Admin admin2;

	//bi-directional many-to-one association to TrainerTechnology
	@JsonIgnore
	@OneToMany(mappedBy="trainer",fetch = FetchType.EAGER)
	private List<TrainerTechnology> trainerTechnologies;

	public Trainer() {
	}

	public int getTrainerId() {
		return this.trainerId;
	}

	public void setTrainerId(int trainerId) {
		this.trainerId = trainerId;
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

	public String getTrainerEmailId() {
		return this.trainerEmailId;
	}

	public void setTrainerEmailId(String trainerEmailId) {
		this.trainerEmailId = trainerEmailId;
	}

	public String getTrainerLocation() {
		return this.trainerLocation;
	}

	public void setTrainerLocation(String trainerLocation) {
		this.trainerLocation = trainerLocation;
	}

	public String getTrainerName() {
		return this.trainerName;
	}

	public void setTrainerName(String trainerName) {
		this.trainerName = trainerName;
	}

	public String getTrainerPassword() {
		return this.trainerPassword;
	}

	public void setTrainerPassword(String trainerPassword) {
		this.trainerPassword = trainerPassword;
	}

	public List<TMSSession> getSessions() {
		return this.sessions;
	}

	public void setSessions(List<TMSSession> sessions) {
		this.sessions = sessions;
	}

	public TMSSession addSession(TMSSession session) {
		getSessions().add(session);
		session.setTrainer(this);

		return session;
	}

	public TMSSession removeSession(TMSSession session) {
		getSessions().remove(session);
		session.setTrainer(null);

		return session;
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

	public List<TrainerTechnology> getTrainerTechnologies() {
		return this.trainerTechnologies;
	}

	public void setTrainerTechnologies(List<TrainerTechnology> trainerTechnologies) {
		this.trainerTechnologies = trainerTechnologies;
	}

	public TrainerTechnology addTrainerTechnology(TrainerTechnology trainerTechnology) {
		getTrainerTechnologies().add(trainerTechnology);
		trainerTechnology.setTrainer(this);

		return trainerTechnology;
	}

	public TrainerTechnology removeTrainerTechnology(TrainerTechnology trainerTechnology) {
		getTrainerTechnologies().remove(trainerTechnology);
		trainerTechnology.setTrainer(null);

		return trainerTechnology;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((admin1 == null) ? 0 : admin1.hashCode());
		result = prime * result + ((admin2 == null) ? 0 : admin2.hashCode());
		result = prime * result + ((created == null) ? 0 : created.hashCode());
		result = prime * result + ((modified == null) ? 0 : modified.hashCode());
		result = prime * result + ((sessions == null) ? 0 : sessions.hashCode());
		result = prime * result + ((trainerEmailId == null) ? 0 : trainerEmailId.hashCode());
		result = prime * result + ((trainerId == null) ? 0 : trainerId.hashCode());
		result = prime * result + ((trainerLocation == null) ? 0 : trainerLocation.hashCode());
		result = prime * result + ((trainerName == null) ? 0 : trainerName.hashCode());
		result = prime * result + ((trainerPassword == null) ? 0 : trainerPassword.hashCode());
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
		Trainer other = (Trainer) obj;
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
		if (trainerEmailId == null) {
			if (other.trainerEmailId != null)
				return false;
		} else if (!trainerEmailId.equals(other.trainerEmailId))
			return false;
		if (trainerId == null) {
			if (other.trainerId != null)
				return false;
		} else if (!trainerId.equals(other.trainerId))
			return false;
		if (trainerLocation == null) {
			if (other.trainerLocation != null)
				return false;
		} else if (!trainerLocation.equals(other.trainerLocation))
			return false;
		if (trainerName == null) {
			if (other.trainerName != null)
				return false;
		} else if (!trainerName.equals(other.trainerName))
			return false;
		if (trainerPassword == null) {
			if (other.trainerPassword != null)
				return false;
		} else if (!trainerPassword.equals(other.trainerPassword))
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
		return "Trainer [trainerId=" + trainerId + ", created=" + created + ", modified=" + modified
				+ ", trainerEmailId=" + trainerEmailId + ", trainerLocation=" + trainerLocation + ", trainerName="
				+ trainerName + ", trainerPassword=" + trainerPassword + ", sessions=" + sessions + ", admin1=" + admin1
				+ ", admin2=" + admin2 + ", trainerTechnologies=" + trainerTechnologies + "]";
	}

	
}