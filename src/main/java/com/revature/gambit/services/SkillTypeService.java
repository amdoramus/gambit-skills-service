package com.revature.gambit.services;

import java.util.List;

import com.revature.gambit.entities.SkillType;

/**
 * API defining all the methods the skill type service will implement
 */
public interface SkillTypeService {

	/**
	 * Adds a new skill type to the database
	 * 
	 * @param skillType - skill Type to be added
	 * @return skill type that has been added
	 */
	public SkillType create(SkillType skillType);

	/**
	 * Retrieves a skill type based on its skill type name
	 * 
	 * @param name - name of the skill type to retrieve
	 * @return skill type that was found
	 */
	public SkillType findBySkillTypeName(String name);

	/**
	 * Retrieves a skill type based on its skill type name
	 *
	 * @param id - id of the skill type to retrieve
	 * @return skill type that was found
	 */
	public SkillType findBySkillTypeId(int id);

	/**
	 * Retrieves all the skill types
	 * 
	 * @return list containing all the skill types
	 */
	public List<SkillType> findAll();

	/**
	 * Updates the value of a skill type
	 * 
	 * @param updatedSkillType - updated value that will replace the old one
	 * @return skill type that was updated
	 */
	public SkillType update(SkillType updatedSkillType);

	/**
	 * Adds a skill to a skill type
	 * 
	 * @param skillTypeId - id of the skill type to add to
	 * @param skillId - id of the skill to add
	 * @return updated skill type, or null if neither the skill type or skill exist
	 */
	SkillType addSkill(Integer skillTypeId, Integer skillId);
	
	/**
	 * Adds a skill to a skill type
	 * 
	 * @param skillTypeName - name of the skill type to add to
	 * @param skillName - name of the skill to add
	 * @return updated skill type, or null if neither the skill type or Skill exist
	 */
	SkillType addSkill(String skillTypeName, String skillName);

	/**
	 * Returns a list of all active skill types
	 * @return list of all skill types where isActive is true
	 */
	List<SkillType> findAllActive();
	
}
