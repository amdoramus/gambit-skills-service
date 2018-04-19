package com.revature.gambit.skill;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.revature.gambit.skill.controllers.SkillController;
import com.revature.gambit.skill.repo.SkillRepository;
import com.revature.gambit.skill.repo.SkillTypeRepository;

@RunWith(SpringRunner.class)
@WebMvcTest(SkillController.class)
public class SkillControllerTests {

	@Autowired
	private MockMvc mvc;
	
	@MockBean
	private SkillRepository repository;

	@Test
	public void getSkillType() throws Exception{

		mvc.perform(get("/skill")).andExpect(content().string("[]"));
		
	}
}
