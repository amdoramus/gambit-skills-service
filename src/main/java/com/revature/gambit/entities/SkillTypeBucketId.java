package com.revature.gambit.entities;

import java.io.Serializable;

import javax.persistence.*;

@Embeddable
public class SkillTypeBucketId implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@ManyToOne
	@JoinColumn(name="SKILLTYPE_ID")
	private SkillType skillType;
	
	@ManyToOne
	@JoinColumn(name="BUCKET_ID")
	private BucketDTO bucket;

	public SkillTypeBucketId() {
		super();
		// TODO Auto-generated constructor stub
	}

	public SkillTypeBucketId(SkillType skillType, BucketDTO bucket) {
		super();
		this.skillType = skillType;
		this.bucket = bucket;
	}

	public SkillType getSkillType() {
		return skillType;
	}

	public void setSkillType(SkillType skillType) {
		this.skillType = skillType;
	}

	public BucketDTO getBucket() {
		return bucket;
	}

	public void setBucket(BucketDTO bucket) {
		this.bucket = bucket;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((bucket == null) ? 0 : bucket.hashCode());
		result = prime * result + ((skillType == null) ? 0 : skillType.hashCode());
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
		SkillTypeBucketId other = (SkillTypeBucketId) obj;
		if (bucket == null) {
			if (other.bucket != null)
				return false;
		} else if (!bucket.equals(other.bucket))
			return false;
		if (skillType == null) {
			if (other.skillType != null)
				return false;
		} else if (!skillType.equals(other.skillType))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "SkillTypeBucketId [skillType=" + skillType + ", bucket=" + bucket + "]";
	}

}
