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

@Service
@Transactional
public class SkillTypeBucketLookupServiceImpl implements SkillTypeBucketLookupService {


	@Autowired
	SkillTypeBucketLookupRepository skillTypeBucketLookupRepo;

	@Override
	public SkillTypeBucketLookup addSkillTypeBucketLookup(SkillTypeBucketLookup stbl) {
		List<SkillTypeBucketLookup> stbls = getAllSkillTypeBucketLookups();
		for (SkillTypeBucketLookup stb : stbls) {
			if (stb.getSkillTypeBucketId().equals(stbl.getSkillTypeBucketId())) {
				return null;
			}
		}
		return skillTypeBucketLookupRepo.save(stbl);
	}
	
	@Override
	public List<SkillTypeBucketLookup> addSkillTypeBucketLookups(SkillType st, int[] bucketIds, double[] weights) {
		List<SkillTypeBucketLookup> stbls = new ArrayList<>();
		for (int i = 0; i < bucketIds.length; i++) {
			BucketDTO b = new BucketDTO(bucketIds[i]);
			Double w = weights[i];
			SkillTypeBucketLookup stbl = new SkillTypeBucketLookup(st, b, w);
			stbls.add(stbl);
		}
		return stbls;
	}
	
	@Override
	public List<SkillTypeBucketLookup> updateSkillTypeBucketLookups(SkillType st, int[] bucketIds, double[] weights) {
		List<SkillTypeBucketLookup> current = getSkillTypeBucketLookupsBySkillType(st);
		for (SkillTypeBucketLookup s : current) {
			deleteSkillTypeBucketLookup(s);
		}
		
		List<SkillTypeBucketLookup> stbls = new ArrayList<>();
		for (int i = 0; i < bucketIds.length; i++) {
			BucketDTO b = new BucketDTO(bucketIds[i]);
			Double w = weights[i];
			SkillTypeBucketLookup stbl = new SkillTypeBucketLookup(st, b, w);
			stbls.add(stbl);
		}
		return stbls;
	}

	@Override
	public List<SkillTypeBucketLookup> getAllSkillTypeBucketLookups() {
		return skillTypeBucketLookupRepo.findAll();
	}

	@Override
	public List<SkillTypeBucketLookup> getSkillTypeBucketLookupsBySkillType(SkillType st) {
		return skillTypeBucketLookupRepo.findSkillTypeBucketLookupsBySkillTypeBucketIdSkillType(st);
	}

	@Override
	public List<SkillTypeBucketLookup> getSkillTypeBucketLookupsByBucket(BucketDTO b) {
		return skillTypeBucketLookupRepo.findSkillTypeBucketLookupsBySkillTypeBucketIdBucket(b);
	}

	@Override
	public SkillTypeBucketLookup updateSkillTypeBucketLookup(SkillTypeBucketLookup stbl) {
		return skillTypeBucketLookupRepo.save(stbl);
	}

	@Override
	public void deleteSkillTypeBucketLookup(SkillTypeBucketLookup stbl) {
		skillTypeBucketLookupRepo.delete(stbl);
	}

}
