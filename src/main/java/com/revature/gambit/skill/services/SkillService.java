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

	public Skill findById(int id) {
		return this.skillRepository.findBySkillID(id);
	}

	@Override
	public void deleteSkillViaId(int id) {

		skillRepository.delete(findById(id));

	}

  @Autowired
  private SkillRepository skillRepository;

  public Skill create(Skill skill) { return this.skillRepository.save(skill); }

  public Skill findByName(string name) { return this.skillRepository.findBySkillName(name); }
    
	@Transactional
	public Skill saveSkill(Skill skill) {
		return skillRepository.saveAndFlush(skill);
	}
	
	public Skill findByName(String name) {
		return skillRepository.findBySkillName(name);
	}
	
	public List<Skill> findAllSkill(){
		return skillRepository.findAll();
	}
	
	public List<Skill> findAllActive(){
		return skillRepository.findAllByIsActive(true);
	}
	@Override
	public void deleteSkillViaName(String name) {
		skillRepository.delete(findByName(name)); //change to take a name instead of an int

	}

}
