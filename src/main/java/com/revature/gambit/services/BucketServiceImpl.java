package com.revature.gambit.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.revature.gambit.entities.BucketDTO;
import com.revature.gambit.repositories.BucketRepository;

/**
 * BucketServiceImpl which is the implementation of BucketService,<br>
 * defines the methods that will be used
 * 
 * @author Josh Dughi | 1803-USF-MAR26 | Wezley Singleton
 * @author Richard Vo | 1803-USF-MAR26 | Wezley Singleton
 */
@Service
public class BucketServiceImpl implements BucketService {
	
	@Autowired
	BucketRepository bucketRepo;
	
	@Transactional
	@Override
	public BucketDTO addBucket(Integer bucketId) {
		BucketDTO bucket = new BucketDTO(bucketId);
		return bucketRepo.save(bucket);
	}

}
