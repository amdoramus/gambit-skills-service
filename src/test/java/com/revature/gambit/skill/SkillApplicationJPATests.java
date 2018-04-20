package com.revature.gambit.skill;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.revature.gambit.skill.beans.Skill;
import com.revature.gambit.skill.beans.SkillType;
import com.revature.gambit.skill.services.SkillService;
import com.revature.gambit.skill.services.SkillTypeService;


@RunWith(SpringRunner.class)
@SpringBootTest
public class SkillApplicationJPATests {

	
	@Autowired
	private SkillService skillService;
	
	@Autowired
	private SkillTypeService skillTypeService;
	
	@Test
	public void getSkillByName() {
		Skill sk = new Skill(1, "Coding", true);

		assertEquals(sk.getSkillName(), "Coding");
	}
	
	@Test
	public void testDeleteSkillFunction() {
		Iterable<Skill> skills = this.skillService.findAll();
		System.out.println(((List<Skill>) skills).size());
		this.skillService.deleteSkillViaId(151);
		Iterable<Skill> skillss = this.skillService.findAll();
		System.out.println(((List<Skill>) skillss).size());
	}
	
	@Test
	public void testDeleteSkillTypeFunction() {
		List<SkillType> skillTypes = this.skillTypeService.findByAll();
		System.out.println(((List<SkillType>) skillTypes).size());
		//System.out.println(this.skillTypeService.findBySkillTypeName("JTA").getSkillTypeName());
		for(SkillType s : skillTypes) {
			System.out.println(s.getSkillTypeName());
		}
		this.skillTypeService.deleteBySkillTypeName("PEGA");
		List<SkillType> skillTypess = this.skillTypeService.findByAll();
		System.out.println(((List<SkillType>) skillTypess).size());
		for(SkillType s : skillTypess) {
			System.out.println("." + s.getSkillTypeName());
		}
	}
}
