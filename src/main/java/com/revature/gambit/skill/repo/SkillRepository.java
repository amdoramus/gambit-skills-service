package com.revature.gambit.skill.repo;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.revature.gambit.skill.beans.Skill;

@Repository
public interface SkillRepository extends CrudRepository<Skill, Integer> { 
	
    Skill findBySkillName(String name);
    
    Skill findBySkillID(int id);
    
	void deleteBySkillName(String name);

    List<Skill> findAll();
    
    List<Skill> findAllByIsActive(boolean bool);
    
}
