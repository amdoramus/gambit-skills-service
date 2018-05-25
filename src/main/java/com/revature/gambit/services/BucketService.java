package com.revature.gambit.services;

import com.revature.gambit.entities.BucketDTO;
/**
 * Bucket service interface that can be used with bucketserviceimpl
 * 
 * @author Josh Dughi and Richard Vo | 1803-USF-MAR26 | Wezley Singleton
 *
 */
public interface BucketService {

	public BucketDTO addBucket (Integer bucketId);
}
