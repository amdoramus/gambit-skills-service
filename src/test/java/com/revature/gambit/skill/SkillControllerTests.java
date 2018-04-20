package com.revature.gambit.skill;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.revature.gambit.skill.beans.Skill;
import com.revature.gambit.skill.controllers.SkillController;

@RunWith(SpringRunner.class)
@WebMvcTest(SkillController.class)
public class SkillControllerTests {

	@Autowired
	private MockMvc mvc;
	
	@MockBean
	private SkillController controller;

	@Before
	public void populate() {
		Skill sk1 = new Skill(1, "coding", true);
		Skill sk2 = new Skill(2, "java", true);
		controller.create(sk1);
		controller.create(sk2);
		System.out.println("oooooooooooooo" + controller.findAll());
	}
	
	@Test
	public void getSkillType() throws Exception{
		mvc.perform(get("/skill")).andExpect(content().string(""));
	}
}
