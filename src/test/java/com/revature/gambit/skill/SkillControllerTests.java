package com.revature.gambit.skill;

import com.google.gson.Gson;
import com.revature.gambit.skill.beans.Skill;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.revature.gambit.skill.controllers.SkillController;
import com.revature.gambit.skill.services.SkillServiceImpl;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringJUnit4ClassRunner.class)
public class SkillControllerTests {

	private MockMvc mvc;

	@InjectMocks
	private SkillController skillController;

	@Mock
	private SkillServiceImpl skillService;

	@Before
	public void setUp() {
		mvc = MockMvcBuilders.standaloneSetup(skillController).build();
	}

	@Test
	public void postSkill() throws Exception {
		Skill skill = new Skill(101, "Fortran", true);
		Gson gson = new Gson();
		String json = gson.toJson(skill);
		when(skillService.create(skill)).thenReturn(skill);

		mvc.perform(MockMvcRequestBuilders.post("/skill/")
				.contentType(MediaType.APPLICATION_JSON).content(json)
				.accept(MediaType.APPLICATION_JSON))
		.andExpect(status().isCreated());
	}

	@Test
	public void testDeleteSkillByID() throws Exception {
		Skill skill1 = new Skill(100, "Java", true);
		when(skillService.findBySkillID(100)).thenReturn(skill1);
		mvc.perform(MockMvcRequestBuilders.delete("/skill/{id}", 100)
				.accept(MediaType.APPLICATION_JSON))
		.andExpect(status().isAccepted());
		when(skillService.findBySkillID(100)).thenReturn(null);
	}
	
	@Test
	public void testDeleteSkillByName() throws Exception {
		Skill skill1 = new Skill(100, "Java", true);
		when(skillService.findBySkillName("Java")).thenReturn(skill1);
		mvc.perform(MockMvcRequestBuilders.delete("/skill/name/{name}", "Java")
				.accept(MediaType.APPLICATION_JSON))
		.andExpect(status().isAccepted());
		when(skillService.findBySkillName("Java")).thenReturn(null);
	}

}
