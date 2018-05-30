package com.revature.gambit.services;

import java.util.List;

import com.revature.gambit.entities.Skill;

/**
 * API defining all the methods the Skill service will implement
 */
public interface SkillService {

	/**
	 * Adds a new Skill to the database
	 * 
	 * @param skill - Skill to be added
	 * @return a Skill that has been added
	 */
	Skill create(Skill skill);

	/**
	 * Retrieves all the Skills, active and non-active
	 * 
	 * @return an Iterable list containing all the Skills found
	 */
	Iterable<Skill> findAll();

	/**
	 * Retrieves all the active Skills
	 * 
	 * @return list containing all the Skills found
	 */
	List<Skill> findAllActive();

	/**
	 * Retrieves a Skill based on its Skill name
	 * 
	 * @param name - name of the Skill to retrieve
	 * @return Skill that was found
	 */
	Skill findBySkillName(String name);

	/**
	 * Retrieves a Skill by id
	 * 
	 * @param id - id of Skill being retrieved
	 * @return a Skill
	 */
	Skill findBySkillID(int id);

	/**
	 * Adds a new Skill to the DB, but unlike create(), this method will<br>
	 * commit/flush changes to DB immediately
	 * 
	 * @param skill - Skill to be added
	 * @return a Skill that was added
	 */
	Skill saveSkill(Skill skill);

	/**
	 * Deletes a Skill based on its name
	 * 
	 * @param name - name of the Skill to delete
	 */
	void deleteBySkillName(String name);

	/**
	 * Deletes a Skill by id
	 * 
	 * @param id - id of the Skill to delete
	 */
	void deleteBySkillID(int id);

}
