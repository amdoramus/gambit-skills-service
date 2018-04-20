package com.revature.gambit.skill;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.revature.gambit.skill.beans.Skill;
import com.revature.gambit.skill.services.SkillService;


@RunWith(SpringRunner.class)
@SpringBootTest
public class SkillApplicationJPATests {

	
	@Autowired
	private SkillService skillService;
	
	@Test
	public void getSkillByName() {
		Skill sk = new Skill(1, "Coding", true);

		assertEquals(sk.getSkillName(), "Coding");
	}
	
	@Test
	public void testDeleteSkillFunction() {
		Iterable<Skill> skills = this.skillService.findAll();
		this.skillService.deleteSkillViaId(151);
		Iterable<Skill> skillss = this.skillService.findAll();
		assertNotEquals(skills, skillss);
	}
	

}
