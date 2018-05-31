package com.revature.gambit.skill.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.revature.gambit.services.SkillTypeBucketLookupService;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class SkillTypeBucketLookupServiceTests {
	
	@Autowired
	SkillTypeBucketLookupService skillTypeBucketLookupService;
	
	@Test
	public void testGetAllSkillTypeBucketLookups() {
		
	}

}
