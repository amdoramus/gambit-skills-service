package com.revature.gambit.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.revature.gambit.entities.BucketDTO;
import com.revature.gambit.entities.SkillType;
import com.revature.gambit.entities.SkillTypeBucketLookup;
import com.revature.gambit.repositories.SkillTypeBucketLookupRepository;

/**
 * Service implementation for SkillTypeBucketLookup
 * 
 * @author Josh Dughi | 1803-USF-MAR26 | Wezley Singleton
 * @author Brandon Semba | 1803-USF-MAR26 | Wezley Singleton
 */
@Service
public class SkillTypeBucketLookupServiceImpl implements SkillTypeBucketLookupService {

	@Autowired
	SkillTypeBucketLookupRepository skillTypeBucketLookupRepo;

	@Override
	public List<SkillTypeBucketLookup> getAllSkillTypeBucketLookups() {
		return skillTypeBucketLookupRepo.findAll();
	}

	@Override
	public List<SkillTypeBucketLookup> getSkillTypeBucketLookupsBySkillType(SkillType skillType) {
		return skillTypeBucketLookupRepo.findSkillTypeBucketLookupsBySkillTypeBucketIdSkillType(skillType);
	}

	@Override
	public List<SkillTypeBucketLookup> getSkillTypeBucketLookupsByBucket(BucketDTO bucket) {
		return skillTypeBucketLookupRepo.findSkillTypeBucketLookupsBySkillTypeBucketIdBucket(bucket);
	}
	
	@Transactional
	@Override
	public SkillTypeBucketLookup addSkillTypeBucketLookup(SkillTypeBucketLookup skillTypeBucketLookup) {
		List<SkillTypeBucketLookup> skillTypeBucketLookups = getAllSkillTypeBucketLookups();
		for (SkillTypeBucketLookup skillTypeBucket : skillTypeBucketLookups) {
			if (skillTypeBucket.getSkillTypeBucketId().equals(skillTypeBucketLookup.getSkillTypeBucketId())) {
				return null;
			}
		}
		return skillTypeBucketLookupRepo.save(skillTypeBucketLookup);
	}
	
	@Transactional
	@Override
	public List<SkillTypeBucketLookup> addSkillTypeBucketLookups(SkillType skillType, int[] bucketIds, double[] weights) {
		List<SkillTypeBucketLookup> skillTypeBucketLookups = new ArrayList<>();
		for (int i = 0; i < bucketIds.length; i++) {
			BucketDTO bucket = new BucketDTO(bucketIds[i]);
			Double weight = weights[i];
			SkillTypeBucketLookup skillTypeBucketLookup = new SkillTypeBucketLookup(skillType, bucket, weight);
			skillTypeBucketLookups.add(skillTypeBucketLookup);
		}
		return skillTypeBucketLookups;
	}
	
	@Transactional
	@Override
	public List<SkillTypeBucketLookup> updateSkillTypeBucketLookups(SkillType skillType, int[] bucketIds, double[] weights) {
		List<SkillTypeBucketLookup> current = getSkillTypeBucketLookupsBySkillType(skillType);
		
		List<SkillTypeBucketLookup> skillTypeBucketLookups = new ArrayList<>();
		for (int i = 0; i < bucketIds.length; i++) {
			BucketDTO bucket = new BucketDTO(bucketIds[i]);
			Double weight = weights[i];
			SkillTypeBucketLookup skillTypeBucketLookup = new SkillTypeBucketLookup(skillType, bucket, weight);
			skillTypeBucketLookups.add(skillTypeBucketLookup);
		}
		return skillTypeBucketLookups;
	}

	@Transactional
	@Override
	public SkillTypeBucketLookup updateSkillTypeBucketLookup(SkillTypeBucketLookup skillTypeBucketLookup) {
		return skillTypeBucketLookupRepo.save(skillTypeBucketLookup);
	}

	@Transactional
	@Override
	public void deleteSkillTypeBucketLookup(SkillTypeBucketLookup skillTypeBucketLookup) {
		skillTypeBucketLookupRepo.delete(skillTypeBucketLookup);
	}

}
