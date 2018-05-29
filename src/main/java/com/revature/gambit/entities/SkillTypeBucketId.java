package com.revature.gambit.entities;

import java.io.Serializable;

import javax.persistence.*;

/**
 * @author Josh Dughi | 1803-USF-MAR26 | Wezley Singleton
 * @author Brandon Semba | 1803-USF-MAR26 | Wezley Singleton
 * 
 * Creates an embeddable composite key
 */
@Embeddable
public class SkillTypeBucketId implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	/**
	 * Represents a skill type
	 */
	@ManyToOne
	@JoinColumn(name="SKILLTYPE_ID")
	private SkillType skillType;
	

	/**
	 * Represents a bucket DTO
	 */
	@ManyToOne
	@JoinColumn(name="BUCKET_ID")
	private BucketDTO bucket;

	/**
	 * Constructs a skill type bucket id
	 */
	public SkillTypeBucketId() {
		super();
	}

	/**
	 * Constructs a skill type bucket id
	 * 
	 * @param skillType - skill type
	 * @param bucket - bucket DTO
	 */
	public SkillTypeBucketId(SkillType skillType, BucketDTO bucket) {
		super();
		this.skillType = skillType;
		this.bucket = bucket;
	}

	/**
	 * Gets a skill type
	 * 
	 * @return skill type
	 */
	public SkillType getSkillType() {
		return skillType;
	}

	/**
	 * Sets a skill type
	 * 
	 * @param skillType - skill type to set
	 */
	public void setSkillType(SkillType skillType) {
		this.skillType = skillType;
	}

	/**
	 * Gets a bucket DTO
	 * 
	 * @return bucket DTO
	 */
	public BucketDTO getBucket() {
		return bucket;
	}

	/**
	 * Sets a bucket DTO
	 * 
	 * @param bucket - bucket DTO to set
	 */
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
