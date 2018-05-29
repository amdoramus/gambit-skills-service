package com.revature.gambit.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.revature.gambit.entities.*;
import com.revature.gambit.repositories.*;

/**
 * Implementation of the Skill Type service API methods
 */
@Service
public class SkillTypeServiceImpl implements SkillTypeService {

	@Autowired
	private SkillTypeRepository skillTypeRepository;
	
	@Autowired
	private SkillRepository skillRepository;

	@Override
	public SkillType findBySkillTypeName(String name) {
		return this.skillTypeRepository.findBySkillTypeName(name);
	}

	@Override
	public SkillType findBySkillTypeId(int id) {
		return this.skillTypeRepository.getOne(id);
	}

	@Override
	public List<SkillType> findAll() {
		return this.skillTypeRepository.findAll();
	}
	
	@Override
	public List<SkillType> findAllActive() {
		return this.skillTypeRepository.findAllByIsActive(true);
	}
	
	@Transactional
	@Override
	public SkillType create(SkillType skillType) {
		return this.skillTypeRepository.save(skillType);
	}

	@Transactional
	@Override
	public SkillType update(SkillType updatedSkillType) {
		return skillTypeRepository.saveAndFlush(updatedSkillType);
	}
	
	@Transactional
	@Override
	public SkillType addSkill(Integer skillTypeId, Integer skillId) {
		SkillType skillType = this.skillTypeRepository.getOne(skillTypeId);
		if (skillType == null)
			return null;
		
		Skill skill = this.skillRepository.findBySkillID(skillId);
		if (skill == null)
			return null;
		
		skillType.addSkill(skill);
		
		return skillTypeRepository.saveAndFlush(skillType);
	}

	@Transactional
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
