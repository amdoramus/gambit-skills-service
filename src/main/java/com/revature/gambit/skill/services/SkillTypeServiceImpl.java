package com.revature.gambit.skill.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.revature.gambit.skill.beans.Skill;
import com.revature.gambit.skill.beans.SkillType;
import com.revature.gambit.skill.repo.SkillRepository;
import com.revature.gambit.skill.repo.SkillTypeRepository;

/**
 * Implementation of the Skill Type service API methods.
 */
@Service
public class SkillTypeServiceImpl implements SkillTypeService {

	/**
	 * Spring Data JPA Repository for skill type methods.
	 */
	@Autowired
	private SkillTypeRepository skillTypeRepository;
	
	@Autowired
	private SkillRepository skillRepository;

	/**
	 * Adds a new skill type to the database.
	 *
	 * @param skillType
	 *            Skill Type to be added.
	 * @return Skill Type that has been added.
	 */
	@Transactional
	@Override
	public SkillType create(SkillType skillType) {
		return this.skillTypeRepository.save(skillType);
	}

	/**
	 * Retrieves a skill type based on its skill type name.
	 *
	 * @param name
	 *            Name of the skill type to retrieve.
	 * @return Skill Type that was found.
	 */
	@Override
	public SkillType findBySkillTypeName(String name) {
		return this.skillTypeRepository.findBySkillTypeName(name);
	}

	/**
	 * Retrieves a skill type based on its skill type name.
	 *
	 * @param id
	 *            Id of the skill type to retrieve.
	 * @return Skill Type that was found.
	 */
	@Override
	public SkillType findBySkillTypeId(int id) {
		return this.skillTypeRepository.findBySkillTypeId(id);
	}

	/**
	 * Retrieves all the skill types.
	 *
	 * @return Iterable object containing all the skill types.
	 */
	@Override
	public Iterable<SkillType> findAll() {
		return this.skillTypeRepository.findAll();
	}

	/**
	 * Updates the value of a skill type.
	 * 
	 * @param updatedSkillType
	 *            Updated value that will replace the old one.

	 * @return SkillType that was updated.
	 */
	@Transactional
	@Override
	public SkillType update(SkillType updatedSkillType) {
		return skillTypeRepository.saveAndFlush(updatedSkillType);
	}

	/**
	 * Deletes a skill type based on its name.
	 * 
	 * @param name
	 *            Name of the skill type to delete.
	 */
	@Transactional
	@Override
	public void deleteBySkillTypeName(String name) {
		this.skillTypeRepository.deleteBySkillTypeName(name);
	}

	@Transactional
	@Override
	public void deleteBySkillTypeID(int id) {
		this.skillTypeRepository.deleteBySkillTypeId(id);
	}

	/**
	 * Returns a list of all active SkillTypes.
	 * @return A list of all SkillTypes where isActive is true.
	 */
	@Override
	public List<SkillType> findAllActive() {
		return this.skillTypeRepository.findAllByIsActive(true);
	}
	
	/**
	 * Adds a Skill to a SkillType
	 * @param skillTypeId The id of the SkillType to add to.
	 * @param skillId The id of the Skill to add.
	 * @return The Updated SkillType, or null if neither the SkillType or Skill exist.
	 */
	@Override
	public SkillType addSkill(Integer skillTypeId, Integer skillId) {
		SkillType skillType = this.skillTypeRepository.findBySkillTypeId(skillTypeId);
		if (skillType == null)
			return null;
		
		Skill skill = this.skillRepository.findBySkillID(skillId);
		if (skill == null)
			return null;
		
		skillType.addSkill(skill);
		
		return skillTypeRepository.saveAndFlush(skillType);
	}

	/**
	 * Adds a Skill to a SkillType
	 * @param skillTypeName The name of the SkillType to add to.
	 * @param skillName The name of the Skill to add.
	 * @return The Updated SkillType, or null if neither the SkillType or Skill exist.
	 */
	@Override
	public SkillType addSkill(String skillTypeName, String skillName) {
		SkillType skillType = this.skillTypeRepository.findBySkillTypeName(skillTypeName);
		if (skillType == null)
			return null;
		
		Skill skill = this.skillRepository.findBySkillName(skillName);
		if (skill == null)
			return null;
		
		skillType.addSkill(skill);
		
		return skillTypeRepository.saveAndFlush(skillType);
	}

}