package com.revature.gambit.skill;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.revature.gambit.skill.beans.SkillType;
import com.revature.gambit.skill.services.SkillTypeService;
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

import com.revature.gambit.skill.controllers.SkillTypeController;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class SkillTypeControllerTests {

	@Autowired
	private ObjectMapper mapper;

	private MockMvc mvc;

	@InjectMocks
	private SkillTypeController skillTypeController;

	@Mock
	private SkillTypeService skillTypeService;

	@Before
	public void setUp() {
		mvc = MockMvcBuilders.standaloneSetup(skillTypeController).build();
	}

	@Test
	public void testCreate() throws Exception {
		SkillType skillType = new SkillType(1, "Java", "I can code in Java", true, true);
		SkillType expectedSkillType = new SkillType(1, "Java", "I can code in Java", true, true);

		when(this.skillTypeService.create(skillType)).thenReturn(expectedSkillType);
		mvc.perform(MockMvcRequestBuilders.post("/skillType/")
				.contentType(MediaType.APPLICATION_JSON)
				.content(mapper.writeValueAsString(skillType))
				.accept(MediaType.APPLICATION_JSON))
		.andExpect(status().isCreated())
		.andExpect(content().json(mapper.writeValueAsString(expectedSkillType)));
	}

	@Test
	public void testDeleteSkillTypeID() throws Exception {
		// Create the skillType to delete
		SkillType skillType = new SkillType(1, "Test", "Test delete by id", true, true);
		SkillType expectedSkillType = new SkillType(1, "Test", "Test delete by id", false, true);
		
		when(this.skillTypeService.findBySkillTypeId(1)).thenReturn(skillType);
		when(this.skillTypeService.update(skillType)).thenReturn(expectedSkillType);

		// Delete the newly added skill.
		mvc.perform(MockMvcRequestBuilders.delete("/skilltype/{id}", skillType.getSkillTypeId()))
		.andExpect(status().isAccepted());
		
		when(this.skillTypeService.findBySkillTypeId(2)).thenReturn(null);
		mvc.perform(MockMvcRequestBuilders.delete("/skilltype/{id}", 1))
		.andExpect(status().isAccepted());
	}

	@Test
	public void testDeleteSkillTypeName() throws Exception {
		// Create the skillType to delete
		SkillType skillType = new SkillType(1, "Test", "Test delete by id", true, true);
		SkillType expectedSkillType = new SkillType(1, "Test", "Test delete by id", false, true);
		
		when(skillTypeService.findBySkillTypeName("Test")).thenReturn(skillType);
		when(skillTypeService.update(skillType)).thenReturn(expectedSkillType);

		mvc.perform(MockMvcRequestBuilders.delete("/skilltype/name/{name}", "Test"))
		.andExpect(status().isAccepted());
		
		when(this.skillTypeService.findBySkillTypeName("Tests")).thenReturn(null);
		mvc.perform(MockMvcRequestBuilders.delete("/skilltype/name/{name}", "Tests"))
		.andExpect(status().isAccepted());
	}

	@Test
	public void testFindAll() throws Exception {
		SkillType skillType1 = new SkillType(100, "Java", "I can code in Java", true, true);
		SkillType skillType2 = new SkillType(101, "Fortran", "What is Fortran", true, true);

		List<SkillType> skillTypes = Arrays.asList(skillType1, skillType2);

		when(this.skillTypeService.findAll()).thenReturn(skillTypes);
		mvc.perform(MockMvcRequestBuilders.get("/skillType"))
		.andExpect(status().isOk())
		.andExpect(content().json(mapper.writeValueAsString(skillTypes)));

		when(this.skillTypeService.findAll()).thenReturn(new ArrayList<SkillType>());
		mvc.perform(MockMvcRequestBuilders.get("/skillType"))
		.andExpect(status().isNoContent());
	}
	
	@Test
	public void testFindSkillTypeById() throws Exception {
		SkillType skillType = new SkillType(1, "Java", "I can code in Java", true, true);

		when(skillTypeService.findBySkillTypeId(1)).thenReturn(skillType);

		mvc.perform(MockMvcRequestBuilders.get("/skillType/{id}", 1))
		.andExpect(status().isOk())
		.andExpect(content().json(mapper.writeValueAsString(skillType)));

		when(skillTypeService.findBySkillTypeId(2)).thenReturn(null);
		
		mvc.perform(MockMvcRequestBuilders.get("/skillType/{id}", 2))
		.andExpect(status().isNotFound());

	}

	@Test
	public void testFindSkillTypeByName() throws Exception {
		SkillType skillType = new SkillType(100, "Java", "I can code in Java", true, true);

		when(this.skillTypeService.findBySkillTypeName("Java")).thenReturn(skillType);
		mvc.perform(MockMvcRequestBuilders.get("/skillType/name/{name}", "Java")
				.accept(MediaType.APPLICATION_JSON))
		.andExpect(status().isOk())
		.andExpect(content().json(mapper.writeValueAsString(skillType)));

		when(this.skillTypeService.findBySkillTypeName("Fortran")).thenReturn(null);
		mvc.perform(MockMvcRequestBuilders.get("/skillType/name/{name}", "Fortran")
				.accept(MediaType.APPLICATION_JSON))
		.andExpect(status().isNotFound());
	}

	@Test
	public void testUpdateSkillTypeByName() throws Exception {
		SkillType expectedSkillType = new SkillType(100, "Java", "I can code in Java", true, true);

		when(this.skillTypeService.update(expectedSkillType)).thenReturn(expectedSkillType);
		mvc.perform(MockMvcRequestBuilders.put("/skillType/name/{name}", "Java")
				.contentType(MediaType.APPLICATION_JSON)
				.content(mapper.writeValueAsString(expectedSkillType))
				.accept(MediaType.APPLICATION_JSON))
		.andExpect(status().isAccepted())
		.andExpect(content().json(mapper.writeValueAsString(expectedSkillType)));

		mvc.perform(MockMvcRequestBuilders.put("/skillType/name/{name}", "C")
				.contentType(MediaType.APPLICATION_JSON)
				.content(mapper.writeValueAsString(expectedSkillType))
				.accept(MediaType.APPLICATION_JSON))
		.andExpect(status().isBadRequest());
	}

//	@Test
//	public void putSkillTypeNameFailed() throws Exception {
//
//		SkillType skill1 = new SkillType(100, "Java", "I can code in Java", true, true);
//		Gson gson = new Gson();
//		String json = gson.toJson(skill1);
//
//		when(skillTypeService.update(skill1)).thenReturn(skill1);
//
//		mvc.perform(MockMvcRequestBuilders.put("/skillType/name/{name}", "jv")
//				.contentType(MediaType.APPLICATION_JSON).content(json)
//				.accept(MediaType.APPLICATION_JSON))
//		.andExpect(status().isBadRequest());
//	}

	@Test
	public void putSkillTypeById() throws Exception {
		SkillType expectedSkillType = new SkillType(100, "Java", "I can code in Java", true, true);

		when(skillTypeService.update(expectedSkillType)).thenReturn(expectedSkillType);

		mvc.perform(MockMvcRequestBuilders.put("/skillType/{id}", 100)
				.contentType(MediaType.APPLICATION_JSON)
				.content(mapper.writeValueAsString(expectedSkillType))
				.accept(MediaType.APPLICATION_JSON))
		.andExpect(status().isAccepted())
		.andExpect(content().json(mapper.writeValueAsString(expectedSkillType)));
	}

	@Test
	public void putSkillTypeByIdFailed() throws Exception {

		SkillType skill1 = new SkillType(100, "Java", "I can code in Java", true, true);
		Gson gson = new Gson();
		String json = gson.toJson(skill1);

		when(skillTypeService.update(skill1)).thenReturn(skill1);

		mvc.perform(MockMvcRequestBuilders.put("/skillType/{id}", 101)
				.contentType(MediaType.APPLICATION_JSON).content(json)
				.accept(MediaType.APPLICATION_JSON))
		.andExpect(status().isBadRequest());

	}

}
