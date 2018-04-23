package com.revature.gambit.skill;

import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.revature.gambit.skill.controllers.SkillController;
import com.revature.gambit.skill.services.SkillService;

@RunWith(SpringJUnit4ClassRunner.class)
public class SkillControllerTests {

	private MockMvc mvc;

	@InjectMocks
	private SkillController skillController;

	@Mock
	private SkillService skillService;

}
