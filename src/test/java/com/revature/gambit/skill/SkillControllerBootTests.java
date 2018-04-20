package com.revature.gambit.skill;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import com.revature.gambit.skill.controllers.SkillController;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class SkillControllerBootTests {

	@Autowired
	private SkillController controller;
	
	@Test
	public void getSkills() {
		
	}
}
