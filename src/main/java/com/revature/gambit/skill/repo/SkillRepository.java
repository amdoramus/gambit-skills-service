package com.revature.gambit.skill.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.revature.gambit.skill.beans.Skill;

@Repository
<<<<<<< HEAD
public interface SkillRepository extends CrudRepository<Skill, Integer> { 
=======

public interface SkillRepository extends CrudRepository<Skill, Integer> { //Might be JPA repository
	
	
	Skill findBySkillID(int id);
>>>>>>> origin/feature-deleteSkill
	
	
	Skill findBySkillID(int id);
	
	void deleteBySkillID(int id);
	void deleteBySkillName(String name);


}
