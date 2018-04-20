package com.revature.gambit.skill.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

import com.revature.gambit.skill.beans.Skill;
import com.revature.gambit.skill.repo.SkillRepository;

@Service
@Configuration
public class SkillService implements ISkillService {

	@Autowired
	private SkillRepository skillRepository;

	public Skill create(Skill skill) {
		return this.skillRepository.save(skill);
	}

	public Iterable<Skill> findAll() {
		return this.skillRepository.findAll();
	}
	
	public Iterable<Skill> findAllActive(){
		return skillRepository.findAllByIsActive(true);
	}
	
	public Skill findByName(String name) {
		return skillRepository.findBySkillName(name);
	}

	@Transactional
	public Skill saveSkill(Skill skill) {
		return skillRepository.saveAndFlush(skill);
	}

	@Override
	public void deleteSkillViaName(String name) {
		skillRepository.delete(findByName(name)); //change to take a name instead of an int
	}

}
