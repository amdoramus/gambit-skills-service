package com.revature.gambit.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revature.gambit.entities.*;

@Repository
public interface SkillTypeBucketLookupRepository extends JpaRepository<SkillTypeBucketLookup, Integer>{

	/**
	 * Finds a list of SimpleSkillTypeBucketLookups with given skilltype
	 * 
	 * @param skillType The SkillType to be searched for
	 * @return List of SimpleSkillTypeBucketLookups
	 */
	List<SkillTypeBucketLookup> findSkillTypeBucketLookupsBySkillTypeBucketIdSkillType(SkillType skillType);
	
	List<SkillTypeBucketLookup> findSkillTypeBucketLookupsBySkillTypeBucketIdBucket(BucketDTO bucket);
}
