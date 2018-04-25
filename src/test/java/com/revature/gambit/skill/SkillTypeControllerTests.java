package com.revature.gambit.skill;

import com.google.gson.Gson;
import com.revature.gambit.skill.beans.SkillType;
import com.revature.gambit.skill.services.SkillTypeServiceImpl;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.revature.gambit.skill.controllers.SkillTypeController;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;


import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class SkillTypeControllerTests {

	private MockMvc mvc;

	@InjectMocks
	private SkillTypeController skillTypeController;

	@Mock
	private SkillTypeServiceImpl skillTypeService;

	@Before
	public void setUp() {
		mvc = MockMvcBuilders.standaloneSetup(skillTypeController).build();
	}

	@Test
	public void postCreate() throws Exception {

		SkillType skill1 = new SkillType(100, "Java", "I can code in Java", true, true);
		Gson gson = new Gson();
		String json = gson.toJson(skill1);

		when(skillTypeService.create(skill1)).thenReturn(skill1);

		mvc.perform(MockMvcRequestBuilders.post("/skillType/")
				.contentType(MediaType.APPLICATION_JSON).content(json)
				.accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isCreated());
	}

}
