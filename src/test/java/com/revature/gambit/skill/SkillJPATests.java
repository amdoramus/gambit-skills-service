package com.revature.gambit.skill;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.revature.gambit.skill.beans.Skill;
import com.revature.gambit.skill.repo.SkillRepository;
import com.revature.gambit.skill.services.SkillService;
import com.revature.gambit.skill.services.SkillTypeService;

@RunWith(SpringRunner.class)
@DataJpaTest
public class SkillJPATests {

	@Autowired
	private TestEntityManager entityManager;
	
	@Autowired
	private SkillRepository skillRepository;
	
	@MockBean
	private SkillService skillService;

	@Test
	public void testSkillCreate() {
		Skill skill = new Skill(2000, "test", true);
		this.skillService.create(skill);
		Skill retrieveSkill = this.skillService.findById(2000);
		assertEquals(skill.getSkillID(), retrieveSkill.getSkillID());
	}
	@Test
	public void getSkillByName() {
		Skill sk = new Skill(1, "Java", true);
		assertEquals(sk.getSkillName(), "Java");
	}
}
