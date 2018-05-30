package com.revature.gambit.services;

import java.util.List;

import com.revature.gambit.entities.SkillType;

/**
 * API defining all the methods the SkillType service will implement
 */
public interface SkillTypeService {

	/**
	 * Adds a new SkillType to the database
	 * 
	 * @param skillType - SkillType to be added
	 * @return a SkillType that has been added
	 */
	public SkillType create(SkillType skillType);

	/**
	 * Retrieves a SkillType based on its SkillType name
	 * 
	 * @param name - name of the SkillType to retrieve
	 * @return SkillType that was found
	 */
	public SkillType findBySkillTypeName(String name);

	/**
	 * Retrieves a SkillType based on its SkillType name
	 *
	 * @param id - id of the SkillType to retrieve
	 * @return a SkillType that was found
	 */
	public SkillType findBySkillTypeId(int id);

	/**
	 * Retrieves all the SkillType
	 * 
	 * @return list containing all the SkillType
	 */
	public List<SkillType> findAll();

	/**
	 * Updates the value of a SkillType
	 * 
	 * @param updatedSkillType - updated value that will replace the old one
	 * @return SkillType that was updated
	 */
	public SkillType update(SkillType updatedSkillType);

	/**
	 * Adds a Skill to a SkillType
	 * 
	 * @param skillTypeId - id of the SkillType to add to
	 * @param skillId - id of the Skill to add
	 * @return updated SkillType, or null if neither the Skill type or Skill exist
	 */
	SkillType addSkill(Integer skillTypeId, Integer skillId);
	
	/**
	 * Adds a Skill to a SkillType
	 * 
	 * @param skillTypeName - name of the SkillType to add to
	 * @param skillName - name of the Skill to add
	 * @return updated SkillType, or null if neither the Skill type or Skill exist
	 */
	SkillType addSkill(String skillTypeName, String skillName);

	/**
	 * Returns a list of all active SkillTypes
	 * 
	 * @return list of all SkillTypes where isActive is true
	 */
	List<SkillType> findAllActive();
	
}
