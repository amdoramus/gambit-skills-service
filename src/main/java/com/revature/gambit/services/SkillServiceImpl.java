package com.revature.gambit.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.revature.gambit.entities.Skill;
import com.revature.gambit.repositories.SkillRepository;

/**
 * Implementation of the Skill service API methods
 */
@Service
@Configuration
public class SkillServiceImpl implements SkillService {

	@Autowired
	private SkillRepository skillRepository;

	@Override
	public Iterable<Skill> findAll() {
		return skillRepository.findAll();
	}

	@Override
	public List<Skill> findAllActive() {
		return this.skillRepository.findAllByIsActive(true);
	}

	@Override
	public Skill findBySkillName(String name) {
		return this.skillRepository.findBySkillName(name);
	}
	
	@Override
	public Skill findBySkillID(int id) {
		return this.skillRepository.findBySkillID(id);
	}
	
	@Transactional
	@Override
	public Skill create(Skill skill) {
		return skillRepository.save(skill);
	}

	@Transactional
	@Override
	public Skill saveSkill(Skill skill) {
		return skillRepository.saveAndFlush(skill);
	}

	@Transactional
	@Override
	public void deleteBySkillName(String name) {
		this.skillRepository.deleteBySkillName(name);
	}

	@Transactional
	@Override
	public void deleteBySkillID(int id) {
		this.skillRepository.deleteBySkillID(id);
	}

}