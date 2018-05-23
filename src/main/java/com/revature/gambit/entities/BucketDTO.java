package com.revature.gambit.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 
 * @author defto
 *
 */
@Entity
@Table(name="BUCKET_DTO")
public class BucketDTO {
	
	@Id
	@Column(name="BUCKET_ID")
	private Integer bucketId;

	public BucketDTO(Integer bucketId) {
		super();
		this.bucketId = bucketId;
	}

	public Integer getBucketId() {
		return bucketId;
	}

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