package com.project.springmvc.model;
import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the trainer_technology database table.
 * 
 */
@Entity
@Table(name="trainer_technology")
public class TrainerTechnology implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="trainer_tech_id")
	private Integer trainerTechId;

	//bi-directional many-to-one association to Technology
	@ManyToOne
	@JoinColumn(name="tech_id")
	private Technology technology;

	//bi-directional many-to-one association to Trainer
	@ManyToOne
	@JoinColumn(name="trainer_id")
	private Trainer trainer;

	public TrainerTechnology() {
	}

	public int getTrainerTechId() {
		return this.trainerTechId;
	}

	public void setTrainerTechId(int trainerTechId) {
		this.trainerTechId = trainerTechId;
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
		result = prime * result + ((technology == null) ? 0 : technology.hashCode());
		result = prime * result + ((trainer == null) ? 0 : trainer.hashCode());
		result = prime * result + ((trainerTechId == null) ? 0 : trainerTechId.hashCode());
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
		TrainerTechnology other = (TrainerTechnology) obj;
		if (technology == null) {
			if (other.technology != null)
				return false;
		} else if (!technology.equals(other.technology))
			return false;
		if (trainer == null) {
			if (other.trainer != null)
				return false;
		} else if (!trainer.equals(other.trainer))
			return false;
		if (trainerTechId == null) {
			if (other.trainerTechId != null)
				return false;
		} else if (!trainerTechId.equals(other.trainerTechId))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "TrainerTechnology [trainerTechId=" + trainerTechId + ", technology=" + technology + ", trainer="
				+ trainer + "]";
	}

	
}