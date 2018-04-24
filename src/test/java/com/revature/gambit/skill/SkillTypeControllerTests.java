package com.revature.gambit.skill;

import com.revature.gambit.skill.services.SkillTypeServiceImpl;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.revature.gambit.skill.controllers.SkillTypeController;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class SkillTypeControllerTests {

	private MockMvc mvc;

	@InjectMocks
	private SkillTypeController skillTypeController;

	@Mock
	private SkillTypeServiceImpl skillTypeService;

}
