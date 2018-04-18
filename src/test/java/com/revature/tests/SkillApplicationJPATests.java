package com.revature.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import com.revature.data.SkillTypeRepository;
import com.revature.domain.Skill;

@RunWith(SpringRunner.class)
@DataJpaTest
public class SkillApplicationJPATests {
	
	@Autowired
	private TestEntityManager entityManager;
	
	@Autowired
	private SkillTypeRepository skillRepository;
	
	@Test
	public void getSkillByName() {
		Skill sk = new Skill("Coding", true);
		assertEquals(sk.getName(), "Coding");
	}
}
