package com.revature.gambit.services;

import java.util.List;

import com.revature.gambit.entities.*;

/**
 * @author Josh Dughi | 1803-USF-MAR26 | Wezley Singleton
 * @author Brandon Semba | 1803-USF-MAR26 | Wezley Singleton
 *
 * Interface for the skill type bucket lookup service
 */
public interface SkillTypeBucketLookupService {
	
	/**
	 * @author Josh Dughi | 1803-USF-MAR26 | Wezley Singleton
	 * @author Brandon Semba | 1803-USF-MAR26 | Wezley Singleton
	 * 
	 * Adds a skill type bucket lookup
	 * 
	 * @param skillTypeBucketLookup - skill type bucket lookup to add
	 * @return a skill type bucket lookup
	 */
	public SkillTypeBucketLookup addSkillTypeBucketLookup(SkillTypeBucketLookup skillTypeBucketLookup);
	
	/**
	 * @author Josh Dughi | 1803-USF-MAR26 | Wezley Singleton
	 * @author Brandon Semba | 1803-USF-MAR26 | Wezley Singleton
	 * 
	 * Adds a skill type bucket lookup
	 * 
	 * @param skillType - skill type
	 * @param bucketIds - list of bucket ids
	 * @param weights - a list of weights
	 * @return list of skill type bucket lookups
	 */
	public List<SkillTypeBucketLookup> addSkillTypeBucketLookups(SkillType skillType, int[] bucketIds, double[] weights);
	
	/**
	 * @author Josh Dughi | 1803-USF-MAR26 | Wezley Singleton
	 * @author Brandon Semba | 1803-USF-MAR26 | Wezley Singleton
	 * 
	 * Updates skill type bucket lookups
	 * 
	 * @param skillType - skill type
	 * @param bucketIds - list of bucket ids
	 * @param weights - list of weights
	 * @return an updated list of skill type bucket lookups
	 */
	public List<SkillTypeBucketLookup> updateSkillTypeBucketLookups(SkillType skillType, int[] bucketIds, double[] weights);
	
	/**
	 * @author Josh Dughi | 1803-USF-MAR26 | Wezley Singleton
	 * @author Brandon Semba | 1803-USF-MAR26 | Wezley Singleton
	 * 
	 * Gets a list of skill type bucket lookups
	 * 
	 * @return list of skill type bucket lookups
	 */
	public List<SkillTypeBucketLookup> getAllSkillTypeBucketLookups();
	
	/**
	 * @author Josh Dughi | 1803-USF-MAR26 | Wezley Singleton
	 * @author Brandon Semba | 1803-USF-MAR26 | Wezley Singleton
	 * 
	 * Gets a list of skill type bucket lookups by skill type
	 * 
	 * @param skillType - skill type
	 * @return list of skill type bucket lookups that correspond to a specific skill type
	 */
	public List<SkillTypeBucketLookup> getSkillTypeBucketLookupsBySkillType(SkillType skillType);
	
	/**
	 * @author Josh Dughi | 1803-USF-MAR26 | Wezley Singleton
	 * @author Brandon Semba | 1803-USF-MAR26 | Wezley Singleton
	 * 
	 * Gets a list of skill type bucket lookups by bucket
	 * 
	 * @param bucket - bucket DTO
	 * @return list of skill type bucket lookups that correspond to a specific bucket
	 */
	public List<SkillTypeBucketLookup> getSkillTypeBucketLookupsByBucket(BucketDTO bucket);
	
	/**
	 * @author Josh Dughi | 1803-USF-MAR26 | Wezley Singleton
	 * @author Brandon Semba | 1803-USF-MAR26 | Wezley Singleton
	 * 
	 * Updates skill type bucket lookup
	 * 
	 * @param skillTypeBucketLookup - updated skill type bucket lookup
	 * @return updated skill type bucket lookup
	 */
	public SkillTypeBucketLookup updateSkillTypeBucketLookup(SkillTypeBucketLookup skillTypeBucketLookup);
	
	/**
	 * @author Josh Dughi | 1803-USF-MAR26 | Wezley Singleton
	 * @author Brandon Semba | 1803-USF-MAR26 | Wezley Singleton
	 * 
	 * Deletes a skill type bucket lookup
	 * 
	 * @param skillTypeBucketLookup - skill type bucket lookup to delete
	 */
	public void deleteSkillTypeBucketLookup(SkillTypeBucketLookup skillTypeBucketLookup);

}
