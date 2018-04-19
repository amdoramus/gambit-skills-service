package com.revature.gambit.skill;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.Before;
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
	
	Skill skill1;
	Skill skill2;

	List<Skill> skills;
	
	@Before
	public void setUp() throws Exception {
		skill1 = new Skill(1, "Java", true);

		skill2 = new Skill(2, "JSP", false);

		skills = Arrays.asList(skill1, skill2);

		skillService.saveSkill(skill1);
		skillService.saveSkill(skill2);


		when(skillService.findAll()).thenReturn(skills);

		when(skillService.findByName("Java")).thenReturn(skill1);
		when(skillService.findByName("JSP")).thenReturn(skill2);
		
//		when(skillService.findByTrainerId(10)).thenReturn(batches.subList(0, 1));
//		when(skillService.findByTrainerId(20)).thenReturn(batches.subList(1, 2));
		
	}

//	@Test
//	public void testFindByName() {
//		Skill skill = new Skill(2000, "test", true);
//		this.skillService.saveSkill(skill);
//		Skill retrieveSkill = this.skillService.findByName("test");
//		assertEquals(skill.getSkillName(), retrieveSkill.getSkillName());
//	}
	
	@Test
	public void getSkill1() {
		Skill skill = this.skillService.findByName("Java");
		assertEquals(skill.getSkillName(), "Java");
	}
	
	@Test
	public void getSkill2() {
		Skill skill = this.skillService.findByName("JSP");
		assertEquals(skill.getSkillName(), "JSP");
	}
}
