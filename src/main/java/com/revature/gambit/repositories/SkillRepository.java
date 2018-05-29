package com.revature.gambit.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revature.gambit.entities.Skill;

/**
 * Spring Data repository interface for Skill service. Defines the boilerplate<br>
 * methods that will be used
 */
@Repository
public interface SkillRepository extends JpaRepository<Skill, Integer> {

	/**
	 * Retrieves all skills, including the inactive ones
	 *
	 * @return list of skills found
	 */
	List<Skill> findAll();

	/**
	 * Retrieves a skill by id
	 * 
	 * @param id - id of skill being retrieved
	 * 
	 * @return a skill
	 */
	Skill findBySkillID(int id);

	/**
	 * Retrieves a skill by name
	 * 
	 * @param name - name of the skill being retrieved
	 * 
	 * @return a skill
	 */
	Skill findBySkillName(String name);

	/**
	 * Retrieves a list of skill's that are active
	 * 
	 * @param isActive - boolean as to whether skills is active or not
	 * @return list of active skills
	 */
	List<Skill> findAllByIsActive(boolean isActive);
	
	/**
	 * Deletes a skill by id
	 * 
	 * @param id - id of the skill being deleted
	 */
	void deleteBySkillID(int id);

	/**
	 * Deletes a skill by name
	 * 
	 * @param name - name of the skill being deleted
	 */
	void deleteBySkillName(String name);

}
