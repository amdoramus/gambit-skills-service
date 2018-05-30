package com.revature.gambit.skill;



import java.util.List;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.revature.gambit.entities.BucketDTO;
import com.revature.gambit.entities.SkillType;
import com.revature.gambit.entities.SkillTypeBucketLookup;
import com.revature.gambit.repositories.SkillTypeBucketLookupRepository;
import com.revature.gambit.services.SkillTypeBucketLookupServiceImpl;



@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class SkillTypeBucketLookupServiceTest {

	@Autowired
	private SkillTypeBucketLookupServiceImpl skillTypeBucketLookupServiceImpl;
	
	@Autowired
	private SkillTypeBucketLookupRepository skillTypeBucketLookupRepo;

	/**
	 * @author Richard Vo | 1803-USF-MAR26 | Wezley Singleton
	 * 
	 * Adds a skill type bucket lookup
	 */
	@Test
	public void addSkillTypeBucketLookup(SkillTypeBucketLookup skillTypeBucketLookup) {
		skillTypeBucketLookupServiceImpl.getAllSkillTypeBucketLookups();
	}
	
	/**
	 * @author Richard Vo | 1803-USF-MAR26 | Wezley Singleton
	 * 
	 * Adds a skill type bucket lookup
	 */
	@Test
	public void addSkillTypeBucketLookups(SkillType skillType, int[] bucketIds, double[] weights) {
		
	}
	
	/**
	 * @author Richard Vo | 1803-USF-MAR26 | Wezley Singleton
	 * 
	 * Updates skill type bucket lookups
	 */
	@Test
	public void updateSkillTypeBucketLookups(SkillType skillType, int[] bucketIds, double[] weights) {
		
	}
	
	/**
	 * @author Richard Vo | 1803-USF-MAR26 | Wezley Singleton
	 * 
	 * Gets a list of skill type bucket lookups
	 */
	@Test
	public void getAllSkillTypeBucketLookups() {
		
	}
	
	/**
	 * @author Richard Vo | 1803-USF-MAR26 | Wezley Singleton
	 * 
	 * Gets a list of skill type bucket lookups by skill type
	 */
	@Test
	public void getSkillTypeBucketLookupsBySkillType(SkillType skillType) {
		
	}
	
	/**
	 * @author Richard Vo | 1803-USF-MAR26 | Wezley Singleton
	 * 
	 * Gets a list of skill type bucket lookups by bucket
	 */
	@Test
	public void getSkillTypeBucketLookupsByBucket(BucketDTO bucket) {
		
	}
	
	/**
	 * @author Richard Vo | 1803-USF-MAR26 | Wezley Singleton
	 * 
	 * Updates skill type bucket lookup
	 * @return 
	 */
	@Test
	public void updateSkillTypeBucketLookup(SkillTypeBucketLookup skillTypeBucketLookup) {
		
	}
	
	/**
	 * @author Richard Vo | 1803-USF-MAR26 | Wezley Singleton
	 * 
	 * Deletes a skill type bucket lookup
	 */
	@Test
	public void deleteSkillTypeBucketLookup(SkillTypeBucketLookup skillTypeBucketLookup) {
		
	}

}
