package com.revature.gambit.entities;

import java.io.Serializable;

import javax.persistence.*;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author Josh Dughi | 1803-USF-MAR26 | Wezley Singleton
 * @author Brandon Semba | 1803-USF-MAR26 | Wezley Singleton
 * 
 * Creates lookup table for skill type bucket
 */
@ApiModel(value = "Skill Type Bucket Lookup", description = "lookup table for skill type buckets and their assoicated weight")
@Entity
@Table(name = "SKILLTYPE_BUCKET_LOOKUP")
public class SkillTypeBucketLookup implements Serializable {

	private static final long serialVersionUID = 67213928524176831L;

	@ApiModelProperty(value = "skill type bucket id")
	@EmbeddedId
	private SkillTypeBucketId skillTypeBucketId;

	@ApiModelProperty(value = "the weight (importance)")
	@Column(name = "WEIGHT")
	private Double weight;

	/**
	 * @author Josh Dughi | 1803-USF-MAR26 | Wezley Singleton
	 * @author Brandon Semba | 1803-USF-MAR26 | Wezley Singleton
	 * 
	 * Constructs a skill type bucket lookup
	 */
	public SkillTypeBucketLookup() {
		super();
	}
	
	/**
	 * @author Josh Dughi | 1803-USF-MAR26 | Wezley Singleton
	 * @author Brandon Semba | 1803-USF-MAR26 | Wezley Singleton
	 * 
	 * Constructs a skill type bucket lookup
	 * 
	 * @param skillType - skill type
	 * @param bucket - bucket DTO
	 * @param weight - weight
	 */
	public SkillTypeBucketLookup(SkillType skillType, BucketDTO bucket, Double weight) {
		super();
		this.skillTypeBucketId = new SkillTypeBucketId(skillType, bucket);
		this.weight = weight;
	}

	/**
	 * @author Josh Dughi | 1803-USF-MAR26 | Wezley Singleton
	 * @author Brandon Semba | 1803-USF-MAR26 | Wezley Singleton
	 * 
	 * Constructs a skill type bucket lookup
	 * 
	 * @param skillTypeBucketId - skill stype bucket id
	 * @param weight - weight
	 */
	public SkillTypeBucketLookup(SkillTypeBucketId skillTypeBucketId, Double weight) {
		super();
		this.skillTypeBucketId = skillTypeBucketId;
		this.weight = weight;
	}

	/**
	 * @author Josh Dughi | 1803-USF-MAR26 | Wezley Singleton
	 * @author Brandon Semba | 1803-USF-MAR26 | Wezley Singleton
	 * 
	 * Gets the skill type bucket id
	 * 
	 * @return skill type bucket id
	 */
	public SkillTypeBucketId getSkillTypeBucketId() {
		return skillTypeBucketId;
	}

	/**
	 * @author Josh Dughi | 1803-USF-MAR26 | Wezley Singleton
	 * @author Brandon Semba | 1803-USF-MAR26 | Wezley Singleton
	 * 
	 * Sets the skill type bucket it
	 * 
	 * @param skillTypeBucketId - skill type bucket id to set
	 */
	public void setSkillTypeBucketId(SkillTypeBucketId skillTypeBucketId) {
		this.skillTypeBucketId = skillTypeBucketId;
	}

	/**
	 * @author Josh Dughi | 1803-USF-MAR26 | Wezley Singleton
	 * @author Brandon Semba | 1803-USF-MAR26 | Wezley Singleton
	 * 
	 * Gets the weight
	 * 
	 * @return weight
	 */
	public Double getWeight() {
		return weight;
	}

	/**
	 * @author Josh Dughi | 1803-USF-MAR26 | Wezley Singleton
	 * @author Brandon Semba | 1803-USF-MAR26 | Wezley Singleton
	 * 
	 * Sets the weight
	 * 
	 * @param weight - weight to set
	 */
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
