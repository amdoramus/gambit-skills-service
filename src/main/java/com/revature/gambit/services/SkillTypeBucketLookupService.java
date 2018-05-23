package com.revature.gambit.services;

import java.util.List;

import com.revature.gambit.entities.*;

public interface SkillTypeBucketLookupService {

	
	public SkillTypeBucketLookup addSkillTypeBucketLookup(SkillTypeBucketLookup stbl);
	
	public List<SkillTypeBucketLookup> addSkillTypeBucketLookups(SkillType st, int[] bucketIds, double[] weights);
	
	public List<SkillTypeBucketLookup> getAllSkillTypeBucketLookups();
	
	public List<SkillTypeBucketLookup> getSkillTypeBucketLookupsBySkillType(SkillType st);
	
	public List<SkillTypeBucketLookup> getSkillTypeBucketLookupsByBucket(BucketDTO b);
	
	public SkillTypeBucketLookup updateSkillTypeBucketLookup(SkillTypeBucketLookup stbl);
	
	public void deleteSkillTypeBucketLookup(SkillTypeBucketLookup stbl);
}
