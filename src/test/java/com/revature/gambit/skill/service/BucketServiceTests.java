package com.revature.gambit.skill.service;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.revature.gambit.entities.BucketDTO;
import com.revature.gambit.services.BucketService;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class BucketServiceTests {
	
	@Autowired
	BucketService bucketService;
	
	@Test
	public void addBucketTest() {
		
		Integer bucketId = 1;
		
		BucketDTO bucket = bucketService.addBucket(bucketId);
		
		assertEquals(bucketId, bucket.getBucketId());
	}

}
