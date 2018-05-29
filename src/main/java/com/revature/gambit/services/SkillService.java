package com.revature.gambit.services;

import java.util.List;

import com.revature.gambit.entities.Skill;

/**
 * API defining all the methods the skill service will implement
 */
public interface SkillService {

	/**
	 * Adds a new skill to the database
	 * 
	 * @param skill - skill to be added
	 * @return Skill that has been added
	 */
	Skill create(Skill skill);

	/**
	 * Retrieves all the skills, active and non-active
	 * 
	 * @return iterable list containing all the skills found
	 */
	Iterable<Skill> findAll();

	/**
	 * Retrieves all the active skills
	 * 
	 * @return list containing all the skills found
	 */
	List<Skill> findAllActive();

	/**
	 * Retrieves a skill based on its skill name
	 * 
	 * @param name - name of the skill to retrieve
	 * @return skill that was found
	 */
	Skill findBySkillName(String name);

	/**
	 * Retrieves a skill by id
	 * 
	 * @param id - id of skill being retrieved
	 * @return a skill
	 */
	Skill findBySkillID(int id);

	/**
	 * Adds a new skill to the DB, but unlike create(), this method will<br>
	 * commit/flush changes to DB immediately
	 * 
	 * @param skill - skill to be added
	 * @return skill that was added
	 */
	Skill saveSkill(Skill skill);

	/**
	 * Deletes a skill based on its name
	 * 
	 * @param name - name of the skill to delete
	 */
	void deleteBySkillName(String name);

	/**
	 * Deletes a skill by id
	 * 
	 * @param id - id of the skill to delete
	 */
	void deleteBySkillID(int id);

}
