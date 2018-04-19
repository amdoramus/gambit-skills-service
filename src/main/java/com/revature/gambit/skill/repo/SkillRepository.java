package com.revature.gambit.skill.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.revature.gambit.skill.beans.Skill;

@Repository

public interface SkillRepository extends CrudRepository<Skill, Integer> { //Might be JPA repository
	
	
	Skill findBySkillID(int id);
	
	void deleteSkillWithId(int id);
	void deleteSkillWithName(String name);


}
