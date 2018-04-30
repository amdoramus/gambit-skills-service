package com.revature.gambit.skill;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.gambit.skill.beans.Skill;
import com.revature.gambit.skill.controllers.SkillController;
import com.revature.gambit.skill.services.SkillService;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class SkillControllerTests {

	@Autowired
	private ObjectMapper mapper;

	private MockMvc mvc;

	@InjectMocks
	private SkillController skillController;

	@Mock
	private SkillService skillService;

	@Before
	public void setUp() {
		mvc = MockMvcBuilders.standaloneSetup(skillController).build();
	}

	@Test
	public void testCreate() throws Exception {
		Skill skill = new Skill("Fortran", true);
		Skill expectedSkill = new Skill(1, "Fortran", true);

		when(this.skillService.create(skill)).thenReturn(expectedSkill);

		mvc.perform(MockMvcRequestBuilders.post("/skill/")
				.contentType(MediaType.APPLICATION_JSON)
				.content(mapper.writeValueAsString(skill))
				.accept(MediaType.APPLICATION_JSON))
		.andExpect(status().isCreated())
		.andExpect(content().json(mapper.writeValueAsString(expectedSkill)));
	}

	@Test
	public void testDeleteSkillByID() throws Exception {
		Skill deletedSkill = new Skill(100, "Java", false);

		when(skillService.saveSkill(deletedSkill)).thenReturn(deletedSkill);
		mvc.perform(MockMvcRequestBuilders.delete("/skill/{id}", 100))
		.andExpect(status().isAccepted());

		when(this.skillService.findBySkillID(2)).thenReturn(null);
		mvc.perform(MockMvcRequestBuilders.delete("/skill/{id}", 2))
		.andExpect(status().isAccepted());
	}

	@Test
	public void testDeleteSkillByName() throws Exception {
		Skill deletedSkill = new Skill(100, "Java", false);

		when(skillService.saveSkill(deletedSkill)).thenReturn(deletedSkill);
		mvc.perform(MockMvcRequestBuilders.delete("/skill/name/{name}", "Java"))
		.andExpect(status().isAccepted());

		when(this.skillService.findBySkillName("C")).thenReturn(null);
		mvc.perform(MockMvcRequestBuilders.delete("/skill/name/{name}", "Java"))
		.andExpect(status().isAccepted());
	}

	@Test
	public void testFindByName() throws Exception {
		Skill skill1 = new Skill(99, "Javas", true);

		when(this.skillService.findBySkillName("Javas")).thenReturn(skill1);
		mvc.perform(MockMvcRequestBuilders.get("/skill/name/{name}", "Javas")
				.accept(MediaType.APPLICATION_JSON))
		.andExpect(status().isOk())
		.andExpect(content().json(mapper.writeValueAsString(skill1)));

		when(this.skillService.findBySkillName("Java")).thenReturn(null);
		mvc.perform(MockMvcRequestBuilders.get("/skill/name/{name}", "Java")
				.accept(MediaType.APPLICATION_JSON))
		.andExpect(status().isNotFound());
	}

	@Test
	public void testFindSkillByID() throws Exception {
		Skill skill1 = new Skill(99, "Javas", true);

		when(skillService.findBySkillID(99)).thenReturn(skill1);
		mvc.perform(MockMvcRequestBuilders.get("/skill/{id}", 99)
				.accept(MediaType.APPLICATION_JSON))
		.andExpect(status().isOk())
		.andExpect(content().json(mapper.writeValueAsString(skill1)));

		when(this.skillService.findBySkillID(1)).thenReturn(null);
		mvc.perform(MockMvcRequestBuilders.get("/skill/{id}", 1)
				.accept(MediaType.APPLICATION_JSON))
		.andExpect(status().isNotFound());
	}

	@Test
	public void testFindAll() throws Exception {
		List<Skill> skills = Arrays.asList(new Skill(1, "Java", true), new Skill(2, ".NET", true));

		when(this.skillService.findAll()).thenReturn(skills);
		mvc.perform(MockMvcRequestBuilders.get("/skill"))
		.andExpect(status().isOk())
		.andExpect(content().json(mapper.writeValueAsString(skills)));
	}

	@Test
	public void testFindAllNoContent() throws Exception {
		when(this.skillService.findAll()).thenReturn(new ArrayList<Skill>());
		mvc.perform(MockMvcRequestBuilders.get("/skill"))
		.andExpect(status().isNoContent());
	}

	@Test
	public void testUpdateByID() throws Exception {
		Skill skill = new Skill(99, "Javas", true);

		when(skillService.saveSkill(skill)).thenReturn(skill);
		mvc.perform(MockMvcRequestBuilders.put("/skill/{id}", 99)
				.contentType(MediaType.APPLICATION_JSON).content(mapper.writeValueAsString(skill))
				.accept(MediaType.APPLICATION_JSON))
		.andExpect(status().isAccepted())
		.andExpect(content().json(mapper.writeValueAsString(skill)));

		mvc.perform(MockMvcRequestBuilders.put("/skill/{id}", 101)
				.contentType(MediaType.APPLICATION_JSON).content(mapper.writeValueAsString(skill))
				.accept(MediaType.APPLICATION_JSON))
		.andExpect(status().isBadRequest());
	}

	@Test
	public void testFindAllActive() throws Exception {
		List<Skill> expectedSkills = Arrays.asList(new Skill(1, "Active", true), new Skill(2, "Active too", true));

		when(this.skillService.findAllActive()).thenReturn(expectedSkills);
		mvc.perform(MockMvcRequestBuilders.get("/skill/active"))
		.andExpect(status().isOk())
		.andExpect(content().json(mapper.writeValueAsString(expectedSkills)));

		when(this.skillService.findAllActive()).thenReturn(new ArrayList<Skill>());
		mvc.perform(MockMvcRequestBuilders.get("/skill/active"))
		.andExpect(status().isNoContent());
	}
}
