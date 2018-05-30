package com.revature.gambit.entities;

import java.io.Serializable;

import javax.persistence.*;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Creates lookup table for skill type bucket
 * 
 * @author Josh Dughi | 1803-USF-MAR26 | Wezley Singleton
 * @author Brandon Semba | 1803-USF-MAR26 | Wezley Singleton
 */
@ApiModel(value = "SkillTypeBucketLookup", description = "lookup table for skill type buckets and their assoicated weight")
@Entity
@Table(name = "SKILLTYPE_BUCKET_LOOKUP")
public class SkillTypeBucketLookup implements Serializable {

	private static final long serialVersionUID = 67213928524176831L;

	@ApiModelProperty(value = "SkillTypeBucketId")
	@EmbeddedId
	private SkillTypeBucketId skillTypeBucketId;

	@ApiModelProperty(value = "the weight (importance)")
	@Column(name = "WEIGHT")
	private Double weight;

	/**
	 * Constructs a SkillTypeBucketLookup
	 * 
	 * @author Josh Dughi | 1803-USF-MAR26 | Wezley Singleton
	 * @author Brandon Semba | 1803-USF-MAR26 | Wezley Singleton
	 */
	public SkillTypeBucketLookup() {
		super();
	}
	
	/**
	 * Constructs a SkillTypeBucketLookup
	 * 
	 * @author Josh Dughi | 1803-USF-MAR26 | Wezley Singleton
	 * @author Brandon Semba | 1803-USF-MAR26 | Wezley Singleton
	 * 
	 * @param skillType - SkillType
	 * @param bucket - BucketDTO
	 * @param weight - weight
	 */
	public SkillTypeBucketLookup(SkillType skillType, BucketDTO bucket, Double weight) {
		super();
		this.skillTypeBucketId = new SkillTypeBucketId(skillType, bucket);
		this.weight = weight;
	}

	/**
	 * Constructs a SkillTypeBucketLookup
	 * 
	 * @author Josh Dughi | 1803-USF-MAR26 | Wezley Singleton
	 * @author Brandon Semba | 1803-USF-MAR26 | Wezley Singleton
	 * 
	 * @param skillTypeBucketId - SkillTypeBucketId
	 * @param weight - weight
	 */
	public SkillTypeBucketLookup(SkillTypeBucketId skillTypeBucketId, Double weight) {
		super();
		this.skillTypeBucketId = skillTypeBucketId;
		this.weight = weight;
	}

	/**
	 * Gets the SkillTypeBucketId
	 * 
	 * @author Josh Dughi | 1803-USF-MAR26 | Wezley Singleton
	 * @author Brandon Semba | 1803-USF-MAR26 | Wezley Singleton
	 * 
	 * @return a SkillTypeBucketId
	 */
	public SkillTypeBucketId getSkillTypeBucketId() {
		return skillTypeBucketId;
	}

	/**
	 * Sets the SkillTypeBucketId
	 * 
	 * @author Josh Dughi | 1803-USF-MAR26 | Wezley Singleton
	 * @author Brandon Semba | 1803-USF-MAR26 | Wezley Singleton
	 * 
	 * @param skillTypeBucketId - SkillTypeBucketId to set
	 */
	public void setSkillTypeBucketId(SkillTypeBucketId skillTypeBucketId) {
		this.skillTypeBucketId = skillTypeBucketId;
	}

	/**
	 * Gets the weight
	 * 
	 * @author Josh Dughi | 1803-USF-MAR26 | Wezley Singleton
	 * @author Brandon Semba | 1803-USF-MAR26 | Wezley Singleton
	 * 
	 * @return weight
	 */
	public Double getWeight() {
		return weight;
	}

	/**
	 * Sets the weight
	 * 
	 * @author Josh Dughi | 1803-USF-MAR26 | Wezley Singleton
	 * @author Brandon Semba | 1803-USF-MAR26 | Wezley Singleton
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
