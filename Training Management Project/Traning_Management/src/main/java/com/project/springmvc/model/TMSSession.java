package com.project.springmvc.model;
import java.io.Serializable;
import javax.persistence.*;

import org.hibernate.validator.constraints.NotEmpty;

import java.util.Date;


/**
 * The persistent class for the session database table.
 * 
 */
@Entity
@Table(name="session")
public class TMSSession implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="session_id")
	private Integer sessionId;

	@Temporal(TemporalType.DATE)
	private Date created;

	@Temporal(TemporalType.DATE)
	private Date modified;

	@NotEmpty
	@Column(name="session_conducted",nullable=false)
	private String sessionConducted;

	@NotEmpty
	@Temporal(TemporalType.DATE)
	@Column(name="session_date",nullable=false)
	private Date sessionDate;

	@NotEmpty
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="session_end_time",nullable=false)
	private Date sessionEndTime;

	@NotEmpty
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="session_start_time",nullable=false)
	private Date sessionStartTime;

	@NotEmpty
	@Column(name="topic_covered",nullable=false)
	private String topicCovered;

	//bi-directional many-to-one association to Batch
	@ManyToOne
	@JoinColumn(name="batch_id")
	private Batch batch;

	//bi-directional many-to-one association to Admin
	@ManyToOne
	@JoinColumn(name="created_by")
	private Admin admin1;

	//bi-directional many-to-one association to Admin
	@ManyToOne
	@JoinColumn(name="modified_by")
	private Admin admin2;

	//bi-directional many-to-one association to Technology
	@ManyToOne
	@JoinColumn(name="tech_id")
	private Technology technology;

	//bi-directional many-to-one association to Trainer
	@ManyToOne
	@JoinColumn(name="trainer_id")
	private Trainer trainer;

	public TMSSession() {
	}

	public int getSessionId() {
		return this.sessionId;
	}

	public void setSessionId(int sessionId) {
		this.sessionId = sessionId;
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

	public String getSessionConducted() {
		return this.sessionConducted;
	}

	public void setSessionConducted(String sessionConducted) {
		this.sessionConducted = sessionConducted;
	}

	public Date getSessionDate() {
		return this.sessionDate;
	}

	public void setSessionDate(Date sessionDate) {
		this.sessionDate = sessionDate;
	}

	public Date getSessionEndTime() {
		return this.sessionEndTime;
	}

	public void setSessionEndTime(Date sessionEndTime) {
		this.sessionEndTime = sessionEndTime;
	}

	public Date getSessionStartTime() {
		return this.sessionStartTime;
	}

	public void setSessionStartTime(Date sessionStartTime) {
		this.sessionStartTime = sessionStartTime;
	}

	public String getTopicCovered() {
		return this.topicCovered;
	}

	public void setTopicCovered(String topicCovered) {
		this.topicCovered = topicCovered;
	}

	public Batch getBatch() {
		return this.batch;
	}

	public void setBatch(Batch batch) {
		this.batch = batch;
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

	public Technology getTechnology() {
		return this.technology;
	}

	public void setTechnology(Technology technology) {
		this.technology = technology;
	}

	public Trainer getTrainer() {
		return this.trainer;
	}

	public void setTrainer(Trainer trainer) {
		this.trainer = trainer;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((admin1 == null) ? 0 : admin1.hashCode());
		result = prime * result + ((admin2 == null) ? 0 : admin2.hashCode());
		result = prime * result + ((batch == null) ? 0 : batch.hashCode());
		result = prime * result + ((created == null) ? 0 : created.hashCode());
		result = prime * result + ((modified == null) ? 0 : modified.hashCode());
		result = prime * result + ((sessionConducted == null) ? 0 : sessionConducted.hashCode());
		result = prime * result + ((sessionDate == null) ? 0 : sessionDate.hashCode());
		result = prime * result + ((sessionEndTime == null) ? 0 : sessionEndTime.hashCode());
		result = prime * result + ((sessionId == null) ? 0 : sessionId.hashCode());
		result = prime * result + ((sessionStartTime == null) ? 0 : sessionStartTime.hashCode());
		result = prime * result + ((technology == null) ? 0 : technology.hashCode());
		result = prime * result + ((topicCovered == null) ? 0 : topicCovered.hashCode());
		result = prime * result + ((trainer == null) ? 0 : trainer.hashCode());
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
		TMSSession other = (TMSSession) obj;
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
		if (batch == null) {
			if (other.batch != null)
				return false;
		} else if (!batch.equals(other.batch))
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
		if (sessionConducted == null) {
			if (other.sessionConducted != null)
				return false;
		} else if (!sessionConducted.equals(other.sessionConducted))
			return false;
		if (sessionDate == null) {
			if (other.sessionDate != null)
				return false;
		} else if (!sessionDate.equals(other.sessionDate))
			return false;
		if (sessionEndTime == null) {
			if (other.sessionEndTime != null)
				return false;
		} else if (!sessionEndTime.equals(other.sessionEndTime))
			return false;
		if (sessionId == null) {
			if (other.sessionId != null)
				return false;
		} else if (!sessionId.equals(other.sessionId))
			return false;
		if (sessionStartTime == null) {
			if (other.sessionStartTime != null)
				return false;
		} else if (!sessionStartTime.equals(other.sessionStartTime))
			return false;
		if (technology == null) {
			if (other.technology != null)
				return false;
		} else if (!technology.equals(other.technology))
			return false;
		if (topicCovered == null) {
			if (other.topicCovered != null)
				return false;
		} else if (!topicCovered.equals(other.topicCovered))
			return false;
		if (trainer == null) {
			if (other.trainer != null)
				return false;
		} else if (!trainer.equals(other.trainer))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "TMSSession [sessionId=" + sessionId + ", created=" + created + ", modified=" + modified
				+ ", sessionConducted=" + sessionConducted + ", sessionDate=" + sessionDate + ", sessionEndTime="
				+ sessionEndTime + ", sessionStartTime=" + sessionStartTime + ", topicCovered=" + topicCovered
				+ ", batch=" + batch + ", admin1=" + admin1 + ", admin2=" + admin2 + ", technology=" + technology
				+ ", trainer=" + trainer + "]";
	}
	

}