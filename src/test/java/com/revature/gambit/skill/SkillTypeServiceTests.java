package com.revature.gambit.skill;

import com.revature.gambit.skill.beans.SkillType;
import com.revature.gambit.skill.repo.SkillTypeRepository;
import com.revature.gambit.skill.services.SkillTypeServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertNotEquals;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class SkillTypeServiceTests {

	@Autowired
	private SkillTypeServiceImpl skillTypeService;
	
	@Autowired
	private SkillTypeRepository skillTypeRepository;


	@Test
	public void testCreate() {
		int sizeOfList = ((List)skillTypeRepository.findAll()).size();
		SkillType tstSkillType = new SkillType("Testing", "Testing Desc", true, true);
		SkillType returnedSkillType = skillTypeService.create(tstSkillType);
		assertTrue(((List)skillTypeRepository.findAll()).size() > sizeOfList);
		assertEquals(returnedSkillType.getSkillTypeName(), tstSkillType.getSkillTypeName());
		skillTypeRepository.delete(tstSkillType);
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
	
}
