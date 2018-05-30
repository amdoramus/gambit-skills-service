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
	 * Retrieves a Skill by id
	 * 
	 * @param id - id of Skill being retrieved
	 * 
	 * @return a Skill
	 */
	Skill findBySkillID(int id);

	/**
	 * Retrieves a Skill by name
	 * 
	 * @param name - name of the Skill being retrieved
	 * 
	 * @return a Skill
	 */
	Skill findBySkillName(String name);

	/**
	 * Retrieves a list of Skill's that are active
	 * 
	 * @param isActive - boolean as to whether Skills is active or not
	 * @return list of active Skills
	 */
	List<Skill> findAllByIsActive(boolean isActive);
	
	/**
	 * Deletes a Skill by id
	 * 
	 * @param id - id of the Skill being deleted
	 */
	void deleteBySkillID(int id);

	/**
	 * Deletes a Skill by name
	 * 
	 * @param name - name of the Skill being deleted
	 */
	void deleteBySkillName(String name);

}
