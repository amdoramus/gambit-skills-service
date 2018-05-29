package com.revature.gambit.entities;

import javax.persistence.*;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author Josh Dughi | 1803-USF-MAR26 | Wezley Singleton
 * @author Brandon Semba | 1803-USF-MAR26 | Wezley Singleton
 * 
 * Creates a bucket DTO
 */
@ApiModel(value = "Bucket DTO", description = "DTO for joining with SkillType")
@Entity
@Table(name="BUCKET_DTO")
public class BucketDTO {
	
	@ApiModelProperty(value = "id of the bucket")
	@Id
	@Column(name="BUCKET_ID")
	private Integer bucketId;

	/**
	 * @author Josh Dughi | 1803-USF-MAR26 | Wezley Singleton
	 * @author Brandon Semba | 1803-USF-MAR26 | Wezley Singleton
	 * 
	 * Constructs a bucket DTO
	 * 
	 * @param bucketId - the bucket id
	 */
	public BucketDTO(Integer bucketId) {
		super();
		this.bucketId = bucketId;
	}

	/**
	 * @author Josh Dughi | 1803-USF-MAR26 | Wezley Singleton
	 * @author Brandon Semba | 1803-USF-MAR26 | Wezley Singleton
	 * 
	 * Gets a bucket DTO bucket id
	 * 
	 * @return bucket id
	 */
	public Integer getBucketId() {
		return bucketId;
	}

	/**
	 * @author Josh Dughi | 1803-USF-MAR26 | Wezley Singleton
	 * @author Brandon Semba | 1803-USF-MAR26 | Wezley Singleton
	 * 
	 * Sets a bucket DTO's bucket id
	 * 
	 * @param bucketId - bucket id to set
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
