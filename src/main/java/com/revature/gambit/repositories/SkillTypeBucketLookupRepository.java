package com.revature.gambit.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revature.gambit.entities.*;

/**
 * Repository layer for SkillTypeBucketLookup
 *  
 * @author Josh Dughi | 1803-USF-MAR26 | Wezley Singleton
 * @author Brandon Semba | 1803-USF-MAR26 | Wezley Singleton
 */
@Repository
public interface SkillTypeBucketLookupRepository extends JpaRepository<SkillTypeBucketLookup, Integer>{

	/**
	 * Finds the list of SkillTypeBucketLookups that pertain to<br>
	 * SkillTypeBucketId SkillTypes
	 * 
	 * @author Josh Dughi | 1803-USF-MAR26 | Wezley Singleton
	 * @author Brandon Semba | 1803-USF-MAR26 | Wezley Singleton
	 * 
	 * @param skillType - a SkillType
	 * @return list of SkillTypeBucketLookups
	 */
	List<SkillTypeBucketLookup> findSkillTypeBucketLookupsBySkillTypeBucketIdSkillType(SkillType skillType);
	
	/**
	 * Finds SkillTypeBucketLookups by SkillTypeBucketId given a specific BucketDTO
	 * 
	 * @author Josh Dughi | 1803-USF-MAR26 | Wezley Singleton
	 * @author Brandon Semba | 1803-USF-MAR26 | Wezley Singleton
	 * 
	 * @param bucket - a BucketDTO
	 * @return list of SkillTypeBucketLookups
	 */
	List<SkillTypeBucketLookup> findSkillTypeBucketLookupsBySkillTypeBucketIdBucket(BucketDTO bucket);

}
