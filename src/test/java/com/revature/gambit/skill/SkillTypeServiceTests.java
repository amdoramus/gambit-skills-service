package com.revature.gambit.skill;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.revature.gambit.entities.Skill;
import com.revature.gambit.entities.SkillType;
import com.revature.gambit.repositories.SkillRepository;
import com.revature.gambit.repositories.SkillTypeRepository;
import com.revature.gambit.services.SkillTypeService;

import javax.transaction.Transactional;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class SkillTypeServiceTests {

	@Autowired
	private SkillTypeService skillTypeService;

	@Autowired
	private SkillTypeRepository skillTypeRepository;
	
	@Autowired
	private SkillRepository skillRepository;


	@Test
	public void testCreate() {
		int sizeOfList = ((List<SkillType>) skillTypeRepository.findAll()).size();
		SkillType tstSkillType = new SkillType("Testing", "Testing Desc", true, true, new ArrayList<Skill>());
		SkillType returnedSkillType = skillTypeService.create(tstSkillType);
		
		assertTrue(((List<SkillType>)skillTypeRepository.findAll()).size() > sizeOfList);
		assertEquals(returnedSkillType.getSkillTypeName(), tstSkillType.getSkillTypeName());
		skillTypeRepository.delete(skillTypeRepository.findOne(returnedSkillType.getSkillTypeId()));
	}

	@Test
	public void testFindAll() {
		Iterable<SkillType> skillTypes = skillTypeService.findAll();
		assertEquals(9, ((List<SkillType>) skillTypes).size());
	}

	@Test
	public void testFindSkillTypeById() {
		SkillType stk = skillTypeService.findBySkillTypeId(3);
		assertEquals(stk.getSkillTypeDesc(), "PEGA Description");
	}

	@Test
	public void getSkillTypeNotFound() {
		SkillType stk = skillTypeService.findBySkillTypeId(1000);
		assertNull(stk);
	}

	@Test
	public void getSkillTypeByName() {
		SkillType stk = skillTypeService.findBySkillTypeName("PEGA");
		assertEquals(stk.getSkillTypeDesc(), "PEGA Description");
	}

	@Test
	public void getSkillTypeByNameNotFound() {
		SkillType stk = skillTypeService.findBySkillTypeName("PEGAN");
		assertNull(stk);
	}

	@Test
	public void testDeleteBySkillTypeName() {
		Iterable<SkillType> before = this.skillTypeService.findAll();
		this.skillTypeService.deleteBySkillTypeName("JTA");
		Iterable<SkillType> after = this.skillTypeService.findAll();
		assertNotEquals(before, after);
	}

	@Test
	public void testDeleteBySkillTypeID() {
		Iterable<SkillType> before = this.skillTypeService.findAll();
		this.skillTypeService.deleteBySkillTypeID(1);
		Iterable<SkillType> after = this.skillTypeService.findAll();
		assertNotEquals(before, after);
	}

	@Test
	public void testUpdate() {
		SkillType tstSkillType = new SkillType("Testing", "Testing Desc", true, true, new ArrayList<Skill>());
		SkillType returnedSkillType = skillTypeService.create(tstSkillType);
		
		returnedSkillType.setIsCore(false);
		skillTypeService.update(returnedSkillType);
		
		tstSkillType = skillTypeRepository.findOne(returnedSkillType.getSkillTypeId());
		assertFalse(tstSkillType.getIsCore());
		skillTypeRepository.delete(skillTypeRepository.findOne(returnedSkillType.getSkillTypeId()));
	}
	
	@Test
	public void testFindAllActive() {
		List<SkillType> skillTypes = this.skillTypeService.findAllActive();
		
		assertEquals(6, skillTypes.size());
	}

	@Test
	@Transactional
	public void testAddSkillById() {
		SkillType skillType = new SkillType("Test", "Test add skill", true, true, new ArrayList<Skill>());
		Skill skill = new Skill("Test", true);
		
		skill = this.skillRepository.saveAndFlush(skill);
		skillType = this.skillTypeRepository.saveAndFlush(skillType);
		
		skillType = this.skillTypeService.addSkill(skillType.getSkillTypeId(), skill.getSkillID());
		List<Skill> expectedSkillList = skillType.getSkills();
		
		assertEquals(1, expectedSkillList.size());
		assertEquals(skill, expectedSkillList.get(0));
		
		this.skillRepository.delete(skill);
		this.skillTypeRepository.delete(skillType);
	}
	
	@Test
	@Transactional
	public void testAddSkillByIdSkillTypeDoesNotExist() {
		Skill skill = new Skill("Test", true);
		
		skill = this.skillRepository.saveAndFlush(skill);
		
		SkillType expectedSkillType = this.skillTypeService.addSkill(100000000, skill.getSkillID());
		assertNull(expectedSkillType);
		
		this.skillRepository.delete(skill);
	}
	
	@Test
	@Transactional
	public void testAddSkillByIdSkillDoesNotExist() {
		SkillType skillType = new SkillType("Test", "Test add skill", true, true, new ArrayList<Skill>());
		
		skillType = this.skillTypeRepository.saveAndFlush(skillType);
		
		SkillType expectedSkillType = this.skillTypeService.addSkill(skillType.getSkillTypeId(), 10000000);
		assertNull(expectedSkillType);
		
		this.skillTypeRepository.delete(skillType);
	}
	
	@Test
	@Transactional
	public void testAddSkillByName() {
		SkillType skillType = new SkillType("Test", "Test add skill", true, true, new ArrayList<Skill>());
		Skill skill = new Skill("Test", true);
		
		skill = this.skillRepository.saveAndFlush(skill);
		skillType = this.skillTypeRepository.saveAndFlush(skillType);
		
		skillType = this.skillTypeService.addSkill(skillType.getSkillTypeName(), skill.getSkillName());
		List<Skill> expectedSkillList = skillType.getSkills();
		assertEquals(1, expectedSkillList.size());
		assertEquals(skill, expectedSkillList.get(0));
		
		this.skillRepository.delete(skill);
		this.skillTypeRepository.delete(skillType);
	}
	
	@Test
	@Transactional
	public void testAddSkillByNameSkillTypeDoesNotExist() {
		Skill skill = new Skill("Test", true);
		
		skill = this.skillRepository.saveAndFlush(skill);
		
		SkillType expectedSkillType = this.skillTypeService.addSkill("Test", skill.getSkillName());
		assertNull(expectedSkillType);
		
		this.skillRepository.delete(skill);
	}
	
	@Test
	@Transactional
	public void testAddSkillByNameSkillDoesNotExist() {
		SkillType skillType = new SkillType("Test", "Test add skill", true, true, new ArrayList<Skill>());
		
		skillType = this.skillTypeRepository.saveAndFlush(skillType);
		
		SkillType expectedSkillType = this.skillTypeService.addSkill(skillType.getSkillTypeName(), "Test");
		assertNull(expectedSkillType);
		
		this.skillTypeRepository.delete(skillType);
	}
}
