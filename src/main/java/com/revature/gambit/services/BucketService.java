package com.revature.gambit.services;

import com.revature.gambit.entities.BucketDTO;

/**
 * @author Josh Dughi | 1803-USF-MAR26 | Wezley Singleton
 * @author Richard Vo | 1803-USF-MAR26 | Wezley Singleton
 * 
 * Bucket service interface that can be used with BucketServiceImpl
 */
public interface BucketService {

	/**
	 * AddBucket method that takes in an integer and creates a BucketDTO object with<br>
	 * only the bucketId field populated with a value then saves it to database
	 * 
	 * @author Josh Dughi | 1803-USF-MAR26 | Wezley Singleton
	 * @author Richard Vo | 1803-USF-MAR26 | Wezley Singleton
	 *
	 * @param bucketId - bucketId for the bucketDTO to be created
	 * @return BucketDTO - bucketDTO which was just created
	 */
	public BucketDTO addBucket(Integer bucketId);

}
