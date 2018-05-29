package com.revature.gambit.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revature.gambit.entities.*;

/**
 * @author Josh Dughi | 1803-USF-MAR26 | Wezley Singleton
 * @author Brandon Semba | 1803-USF-MAR26 | Wezley Singleton
 *
 * Repository layer for skill type bucket lookup
 */
@Repository
public interface SkillTypeBucketLookupRepository extends JpaRepository<SkillTypeBucketLookup, Integer>{

	/**
	 * @author Josh Dughi | 1803-USF-MAR26 | Wezley Singleton
	 * @author Brandon Semba | 1803-USF-MAR26 | Wezley Singleton
	 * 
	 * Finds the list of skill type bucket lookups that pertain to skill<br>
	 * type bucket id skill types
	 * 
	 * @param skillType - a skill type
	 * @return list of skill type bucket lookups
	 */
	List<SkillTypeBucketLookup> findSkillTypeBucketLookupsBySkillTypeBucketIdSkillType(SkillType skillType);
	
	/**
	 * @author Josh Dughi | 1803-USF-MAR26 | Wezley Singleton
	 * @author Brandon Semba | 1803-USF-MAR26 | Wezley Singleton
	 * 
	 * Finds skill type bucket lookups by skill type bucket id given a specific bucket DTO
	 * 
	 * @param bucket - a Bucket DTO
	 * @return list of skill type bucket lookups
	 */
	List<SkillTypeBucketLookup> findSkillTypeBucketLookupsBySkillTypeBucketIdBucket(BucketDTO bucket);

}
