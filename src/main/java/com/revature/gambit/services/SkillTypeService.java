package com.revature.gambit.services;

import java.util.List;

import com.revature.gambit.entities.SkillType;

/**
 * API defining all the methods the skill type service will implement.
 */
public interface SkillTypeService {

	/**
	 * Adds a new skill type to the database.
	 * 
	 * @param skillType
	 *            Skill Type to be added.
	 * @return Skill Type that has been added.
	 */
	public SkillType create(SkillType skillType);

	/**
	 * Retrieves a skill type based on its skill type name.
	 * 
	 * @param name
	 *            Name of the skill type to retrieve.
	 * @return Skill Type that was found.
	 */
	public SkillType findBySkillTypeName(String name);

	/**
	 * Retrieves a skill type based on its skill type name.
	 *
	 * @param id
	 *            Name of the skill type to retrieve.
	 * @return Skill Type that was found.
	 */
	public SkillType findBySkillTypeId(int id);

	/**
	 * Retrieves all the skill types.
	 * 
	 * @return Iterable object containing all the skill types.
	 */
	public Iterable<SkillType> findAll();

	/**
	 * Updates the value of a skill type.
	 * 
	 * @param updatedSkillType
	 *            Updated value that will replace the old one.
	 * @return SkillType that was updated.
	 */
	public SkillType update(SkillType updatedSkillType);

	/**
	 * Adds a Skill to a SkillType
	 * @param skillTypeId The id of the SkillType to add to.
	 * @param skillId The id of the Skill to add.
	 * @return The Updated SkillType, or null if neither the SkillType or Skill exist.
	 */
	SkillType addSkill(Integer skillTypeId, Integer skillId);
	
	/**
	 * Adds a Skill to a SkillType
	 * @param skillTypeName The name of the SkillType to add to.
	 * @param skillName The name of the Skill to add.
	 * @return The Updated SkillType, or null if neither the SkillType or Skill exist.
	 */
	SkillType addSkill(String skillTypeName, String skillName);
	
//	/**
//	 * Deletes a skill type based on its name.
//	 * 
//	 * @param name
//	 *            Name of the skill type to delete.
//	 */
//	public void deleteBySkillTypeName(String name);
//	
//	/**
//	 * Deletes a skill type based on its id.
//	 * 
//	 * @param name
//	 *            Name of the skill type to delete.
//	 */
//	public void deleteBySkillTypeID(int id);

	/**
	 * Returns a list of all active SkillTypes.
	 * @return A list of all SkillTypes where isActive is true.
	 */
	List<SkillType> findAllActive();
}
