package com.revature.gambit.skill.services;

import org.springframework.stereotype.Service;

import com.revature.gambit.skill.repo.SkillRepository;

@Service
public class SkillService implements ISkillService {
	
	@Override
	public void deleteSkillViaId(int id) {
		SkillRepository.delete(getSkillById(id));
	}

	@Override
	public void deleteSkillViaName(String name) {
		// TODO Auto-generated method stub
		SkillRepository.delete(getSkillByName(name));
	}

}
