package com.revature.gambit.entities;

import javax.persistence.*;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Creates a BucketDTO
 * 
 * @author Josh Dughi | 1803-USF-MAR26 | Wezley Singleton
 * @author Brandon Semba | 1803-USF-MAR26 | Wezley Singleton
 */
@ApiModel(value = "Bucket DTO", description = "DTO for joining with SkillType")
@Entity
@Table(name = "BUCKET_DTO")
public class BucketDTO {
	
	@ApiModelProperty(value = "id of the Bucket")
	@Id
	@Column(name = "BUCKET_ID")
	private Integer bucketId;

	/**
	 * Constructs a BucketDTO
	 * 
	 * @author Josh Dughi | 1803-USF-MAR26 | Wezley Singleton
	 * @author Brandon Semba | 1803-USF-MAR26 | Wezley Singleton
	 * 
	 * @param bucketId - the Bucket id
	 */
	public BucketDTO(Integer bucketId) {
		super();
		this.bucketId = bucketId;
	}

	/**
	 * Gets a BucketDTO Bucket id
	 * 
	 * @author Josh Dughi | 1803-USF-MAR26 | Wezley Singleton
	 * @author Brandon Semba | 1803-USF-MAR26 | Wezley Singleton
	 * 
	 * @return a Bucket id
	 */
	public Integer getBucketId() {
		return bucketId;
	}

	/**
	 * Sets a BucketDTO's Bucket id
	 * 
	 * @author Josh Dughi | 1803-USF-MAR26 | Wezley Singleton
	 * @author Brandon Semba | 1803-USF-MAR26 | Wezley Singleton
	 * 
	 * @param bucketId - Bucket id to set
	 */
	public void setBucketId(Integer bucketId) {
		this.bucketId = bucketId;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((bucketId == null) ? 0 : bucketId.hashCode());
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
		BucketDTO other = (BucketDTO) obj;
		if (bucketId == null) {
			if (other.bucketId != null)
				return false;
		} else if (!bucketId.equals(other.bucketId))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "BucketDTO [bucketId=" + bucketId + "]";
	}

}
