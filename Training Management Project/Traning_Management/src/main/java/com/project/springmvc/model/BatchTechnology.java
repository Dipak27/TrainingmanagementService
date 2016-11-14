package com.project.springmvc.model;
import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the batch_technology database table.
 * 
 */
@Entity
@Table(name="batch_technology")
@NamedQuery(name="BatchTechnology.findAll", query="SELECT b FROM BatchTechnology b")
public class BatchTechnology implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="batch_tech_id")
	private Integer batchTechId;

	//bi-directional many-to-one association to Batch
	@ManyToOne
	@JoinColumn(name="batch_id")
	private Batch batch;

	//bi-directional many-to-one association to Technology
	@ManyToOne
	@JoinColumn(name="tech_id")
	private Technology technology;

	public BatchTechnology() {
	}

	public int getBatchTechId() {
		return this.batchTechId;
	}

	public void setBatchTechId(int batchTechId) {
		this.batchTechId = batchTechId;
	}

	public Batch getBatch() {
		return this.batch;
	}

	public void setBatch(Batch batch) {
		this.batch = batch;
	}

	public Technology getTechnology() {
		return this.technology;
	}

	public void setTechnology(Technology technology) {
		this.technology = technology;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((batch == null) ? 0 : batch.hashCode());
		result = prime * result + ((batchTechId == null) ? 0 : batchTechId.hashCode());
		result = prime * result + ((technology == null) ? 0 : technology.hashCode());
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
		BatchTechnology other = (BatchTechnology) obj;
		if (batch == null) {
			if (other.batch != null)
				return false;
		} else if (!batch.equals(other.batch))
			return false;
		if (batchTechId == null) {
			if (other.batchTechId != null)
				return false;
		} else if (!batchTechId.equals(other.batchTechId))
			return false;
		if (technology == null) {
			if (other.technology != null)
				return false;
		} else if (!technology.equals(other.technology))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "BatchTechnology [batchTechId=" + batchTechId + ", batch=" + batch + ", technology=" + technology + "]";
	}

	
}