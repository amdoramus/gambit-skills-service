package com.revature.gambit.entities;

import java.io.Serializable;

import javax.persistence.*;

@Entity
@Table(name = "SKILLTYPE_BUCKET_LOOKUP")
public class SkillTypeBucketLookup implements Serializable {

	private static final long serialVersionUID = 67213928524176831L;

	@EmbeddedId
	private SkillTypeBucketId skillTypeBucketId;

	@Column(name = "WEIGHT")
	private Double weight;

	public SkillTypeBucketLookup() {
		super();
	}
	
	public SkillTypeBucketLookup(SkillType skillType, BucketDTO bucket, Double weight) {
		super();
		this.skillTypeBucketId = new SkillTypeBucketId(skillType, bucket);
		this.weight = weight;
	}

	public SkillTypeBucketLookup(SkillTypeBucketId skillTypeBucketId, Double weight) {
		super();
		this.skillTypeBucketId = skillTypeBucketId;
		this.weight = weight;
	}

	public SkillTypeBucketId getSkillTypeBucketId() {
		return skillTypeBucketId;
	}

	public void setSkillTypeBucketId(SkillTypeBucketId skillTypeBucketId) {
		this.skillTypeBucketId = skillTypeBucketId;
	}

	public Double getWeight() {
		return weight;
	}

	public void setWeight(Double weight) {
		this.weight = weight;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((skillTypeBucketId == null) ? 0 : skillTypeBucketId.hashCode());
		result = prime * result + ((weight == null) ? 0 : weight.hashCode());
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
		SkillTypeBucketLookup other = (SkillTypeBucketLookup) obj;
		if (skillTypeBucketId == null) {
			if (other.skillTypeBucketId != null)
				return false;
		} else if (!skillTypeBucketId.equals(other.skillTypeBucketId))
			return false;
		if (weight == null) {
			if (other.weight != null)
				return false;
		} else if (!weight.equals(other.weight))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "SkillTypeBucketLookup [skillTypeBucketId=" + skillTypeBucketId + ", weight=" + weight + "]";
	}

}
