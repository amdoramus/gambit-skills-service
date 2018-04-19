package com.revature.gambit.skill;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import com.revature.gambit.skill.controllers.SkillTypeController;
import com.revature.gambit.skill.services.SkillTypeService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.revature.gambit.skill.beans.Skill;
import com.revature.gambit.skill.beans.SkillType;
import com.revature.gambit.skill.repo.SkillRepository;
import com.revature.gambit.skill.repo.SkillTypeRepository;


@RunWith(SpringRunner.class)
@DataJpaTest
public class SkillAndTypeJPATests {

	@Autowired
	private TestEntityManager entityManager;
	
	@Autowired
	private SkillRepository skillRepository;
	
	@MockBean
	private SkillTypeService skillTypeService;
	
	@Test
	public void getSkillByName() {
		Skill sk = new Skill(1, "Java", true);
		assertEquals(sk.getSkillName(), "Java");
	}
	
	@Test
	public void getSkillTypeByName() {
		SkillType stk = new SkillType(100, "Coding", "Can code in a language", true, true);
		skillTypeService.findByAll();
		assertEquals(skillTypeService.findByAll(),skillTypeService.findByAll());
	}
}
