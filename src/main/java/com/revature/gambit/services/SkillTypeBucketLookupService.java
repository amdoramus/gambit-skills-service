package com.revature.gambit.services;

import java.util.List;

import com.revature.gambit.entities.*;

/**
 * Interface for the SkillTypeBucketLookup service
 * 
 * @author Josh Dughi | 1803-USF-MAR26 | Wezley Singleton
 * @author Brandon Semba | 1803-USF-MAR26 | Wezley Singleton
 */
public interface SkillTypeBucketLookupService {
	
	/**
	 * Adds a SkillTypeBucketLookup
	 * 
	 * @author Josh Dughi | 1803-USF-MAR26 | Wezley Singleton
	 * @author Brandon Semba | 1803-USF-MAR26 | Wezley Singleton
	 * 
	 * @param skillTypeBucketLookup - SkillTypeBucketLookup to add
	 * @return a SkillTypeBucketLookup
	 */
	public SkillTypeBucketLookup addSkillTypeBucketLookup(SkillTypeBucketLookup skillTypeBucketLookup);
	
	/**
	 * Adds a SkillTypeBucketLookup
	 * 
	 * @author Josh Dughi | 1803-USF-MAR26 | Wezley Singleton
	 * @author Brandon Semba | 1803-USF-MAR26 | Wezley Singleton
	 * 
	 * @param skillType - SkillType
	 * @param bucketIds - list of Bucket ids
	 * @param weights - a list of weights
	 * @return list of SkillTypeBucketLookups
	 */
	public List<SkillTypeBucketLookup> addSkillTypeBucketLookups(SkillType skillType, int[] bucketIds, double[] weights);
	
	/**
	 * Updates SkillTypeBucketLookups
	 * 
	 * @author Josh Dughi | 1803-USF-MAR26 | Wezley Singleton
	 * @author Brandon Semba | 1803-USF-MAR26 | Wezley Singleton
	 * 
	 * @param skillType - SkillType
	 * @param bucketIds - list of Bucket ids
	 * @param weights - list of weights
	 * @return an updated list of SkillTypeBucketLookups
	 */
	public List<SkillTypeBucketLookup> updateSkillTypeBucketLookups(SkillType skillType, int[] bucketIds, double[] weights);
	
	/**
	 * Gets a list of SkillTypeBucketLookups
	 * 
	 * @author Josh Dughi | 1803-USF-MAR26 | Wezley Singleton
	 * @author Brandon Semba | 1803-USF-MAR26 | Wezley Singleton
	 * 
	 * @return list of SkillTypeBucketLookups
	 */
	public List<SkillTypeBucketLookup> getAllSkillTypeBucketLookups();
	
	/**
	 * Gets a list of SkillTypeBucketLookups by SkillType
	 * 
	 * @author Josh Dughi | 1803-USF-MAR26 | Wezley Singleton
	 * @author Brandon Semba | 1803-USF-MAR26 | Wezley Singleton
	 * 
	 * @param skillType - SkillType
	 * @return list of SkillTypeBucketLookups that correspond to a specific SkillType
	 */
	public List<SkillTypeBucketLookup> getSkillTypeBucketLookupsBySkillType(SkillType skillType);
	
	/**
	 * Gets a list of SkillTypeBucketLookups by Bucket
	 * 
	 * @author Josh Dughi | 1803-USF-MAR26 | Wezley Singleton
	 * @author Brandon Semba | 1803-USF-MAR26 | Wezley Singleton
	 * 
	 * @param bucket - BucketDTO
	 * @return list of SkillTypeBucketLookups that correspond to a specific Bucket
	 */
	public List<SkillTypeBucketLookup> getSkillTypeBucketLookupsByBucket(BucketDTO bucket);
	
	/**
	 * Updates SkillTypeBucketLookup
	 * 
	 * @author Josh Dughi | 1803-USF-MAR26 | Wezley Singleton
	 * @author Brandon Semba | 1803-USF-MAR26 | Wezley Singleton
	 * 
	 * @param skillTypeBucketLookup - updated SkillTypeBucketLookup
	 * @return updated SkillTypeBucketLookup
	 */
	public SkillTypeBucketLookup updateSkillTypeBucketLookup(SkillTypeBucketLookup skillTypeBucketLookup);
	
	/**
	 * Deletes a SkillTypeBucketLookup
	 * 
	 * @author Josh Dughi | 1803-USF-MAR26 | Wezley Singleton
	 * @author Brandon Semba | 1803-USF-MAR26 | Wezley Singleton
	 * 
	 * @param skillTypeBucketLookup - SkillTypeBucketLookup to delete
	 */
	public void deleteSkillTypeBucketLookup(SkillTypeBucketLookup skillTypeBucketLookup);

}
