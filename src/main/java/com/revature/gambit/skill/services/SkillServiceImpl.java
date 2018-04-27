package com.revature.gambit.skill.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.revature.gambit.skill.beans.Skill;
import com.revature.gambit.skill.repo.SkillRepository;

/**
 * Implementation of the Skill service API methods.
 */
@Service
@Configuration
public class SkillServiceImpl implements SkillService {

	/**
	 * Spring Data JPA Repository for skill methods.
	 */
	@Autowired
	private SkillRepository skillRepository;

	/**
	 * Adds a new skill to the database.
	 *
	 * @param skill
	 *            Skill to be added.
	 * @return Skill that has been added.
	 */
	@Transactional
	@Override
	public Skill create(Skill skill) {
		return skillRepository.save(skill);
	}

	/**
	 * Retrieves all the skills, active and non-active.
	 *
	 * @return Iterable object containing all the skills found.
	 */
	@Override
	public Iterable<Skill> findAll() {
		return skillRepository.findAll();
	}

	/**
	 * Retrieves all the active skills.
	 *
	 * @return Iterable object containing all the skills fouund.
	 */
	@Override
	public Iterable<Skill> findAllActive() {
		return null;
	}

	/**
	 * Retrieves a skill based on its skill name.
	 *
	 * @param name
	 *            Name of the skill to retrieve.
	 * @return Skill that was found.
	 */
	@Override
	public Skill findBySkillName(String name) {
		return this.skillRepository.findBySkillName(name);
	}
	
	@Override
	public Skill findBySkillID(int id) {
		return this.skillRepository.findBySkillID(id);
	}

	/**
	 * Adds a new skill to the DB, but unlike create(), this method will
	 * commit/flush changes to DB immediately.
	 *
	 * @param skill
	 *            Skill to be added.
	 * @return Skill that was added.
	 */
	@Transactional
	@Override
	public Skill saveSkill(Skill skill) {
		return null;
	}

	/**
	 * Deletes a skill based on its name.
	 *
	 * @param name
	 *            Name of the skill to delete.
	 */
	@Override
	public void deleteBySkillName(String name) {
		this.skillRepository.deleteBySkillName(name);
	}

	/**
	 * Deletes a skill based on its id.
	 * 
	 * @param id
	 *            id of the skill to delete.
	 */
	@Transactional
	@Override
	public void deleteBySkillID(int id) {
		this.skillRepository.deleteBySkillID(id);
	}

}