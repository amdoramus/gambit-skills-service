package com.revature.gambit.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.revature.gambit.entities.BucketDTO;
import com.revature.gambit.repositories.BucketRepository;

/**
 * BucketServiceImpl which is the implementation of BucketService, defines the methods that will be used
 * 
 * @author Josh Dughi and Richard Vo | 1803-USF-MAR26 | Wezley Singleton
 *
 */

@Service
@Transactional
public class BucketServiceImpl implements BucketService{
	
	
	@Autowired
	BucketRepository bucketRepo;
	
	/**
	 * AddBucket method that takes in an integer and creates a BucketDTO object with
	 * only the bucketId field populated with a value then saves it to database.
	 * 
	 * @author Josh Dughi and Richard Vo | 1803-USF-MAR26 | Wezley Singleton
	 *
	 * @param Integer
	 * 		The bucketId for the BucketDTO to be created
	 * @return BucketDTO
	 * 		Returns the bucketDTO which was just created
	 */
	
	@Override
	public BucketDTO addBucket(Integer bucketId) {
		
		BucketDTO bucket = new BucketDTO(bucketId);
		
		BucketDTO savedBucket = bucketRepo.save(bucket);
		
		return savedBucket;
	}

}
