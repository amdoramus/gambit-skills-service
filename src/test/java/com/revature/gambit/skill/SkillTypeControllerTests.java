package com.revature.gambit.skill;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;
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
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.revature.gambit.skill.beans.Skill;
import com.revature.gambit.skill.controllers.SkillTypeController;

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
		SkillType skillType = new SkillType("Java", "I can code in Java", true, true, Arrays.asList());
		SkillType expectedSkillType = new SkillType(1, "Java", "I can code in Java", true, true, Arrays.asList());
		
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
		SkillType skillType = new SkillType(1, "Test", "Test delete by id", true, true, Arrays.asList());
		SkillType expectedSkillType = new SkillType(1, "Test", "Test delete by id", false, true, Arrays.asList());
		
		when(this.skillTypeService.findBySkillTypeId(1)).thenReturn(skillType);
		when(this.skillTypeService.update(skillType)).thenReturn(expectedSkillType);

		// Delete the newly added skill.
		mvc.perform(MockMvcRequestBuilders.delete("/skilltype/{id}", skillType.getSkillTypeId()))
		.andExpect(status().isAccepted());
		
		when(this.skillTypeService.findBySkillTypeId(2)).thenReturn(null);
		mvc.perform(MockMvcRequestBuilders.delete("/skilltype/{id}", 2))
		.andExpect(status().isAccepted());
	}

	@Test
	public void testDeleteSkillTypeName() throws Exception {
		// Create the skillType to delete
		SkillType skillType = new SkillType(1, "Test", "Test delete by id", true, true, Arrays.asList());
		SkillType expectedSkillType = new SkillType(1, "Test", "Test delete by id", false, true, Arrays.asList());
		
		when(this.skillTypeService.findBySkillTypeName("Test")).thenReturn(skillType);
		when(this.skillTypeService.update(skillType)).thenReturn(expectedSkillType);

		mvc.perform(MockMvcRequestBuilders.delete("/skilltype/name/{name}", "Test"))
		.andExpect(status().isAccepted());
		
		when(this.skillTypeService.findBySkillTypeName("Tests")).thenReturn(null);
		mvc.perform(MockMvcRequestBuilders.delete("/skilltype/name/{name}", "Tests"))
		.andExpect(status().isAccepted());
	}

	@Test
	public void testFindAll() throws Exception {
		SkillType skillType1 = new SkillType(100, "Java", "I can code in Java", true, true, Arrays.asList());
		SkillType skillType2 = new SkillType(101, "Fortran", "What is Fortran", true, true, Arrays.asList());

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
		SkillType skillType = new SkillType(1, "Java", "I can code in Java", true, true, Arrays.asList());
		when(this.skillTypeService.findBySkillTypeId(1)).thenReturn(skillType);

		mvc.perform(MockMvcRequestBuilders.get("/skillType/{id}", 1))
		.andExpect(status().isOk())
		.andExpect(content().json(mapper.writeValueAsString(skillType)));

		when(this.skillTypeService.findBySkillTypeId(2)).thenReturn(null);
		
		mvc.perform(MockMvcRequestBuilders.get("/skillType/{id}", 2))
		.andExpect(status().isNotFound());
	}

	@Test
	public void testFindSkillTypeByName() throws Exception {
		SkillType skillType = new SkillType(100, "Java", "I can code in Java", true, true, Arrays.asList());

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
		SkillType expectedSkillType = new SkillType(100, "Java", "I can code in Java", true, true, Arrays.asList());

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

	@Test
	public void testUpdateSkillTypeById() throws Exception {
		SkillType expectedSkillType = new SkillType(100, "Java", "I can code in Java", true, true, Arrays.asList());

		when(this.skillTypeService.update(expectedSkillType)).thenReturn(expectedSkillType);

		mvc.perform(MockMvcRequestBuilders.put("/skillType/{id}", 100)
				.contentType(MediaType.APPLICATION_JSON)
				.content(mapper.writeValueAsString(expectedSkillType))
				.accept(MediaType.APPLICATION_JSON))
		.andExpect(status().isAccepted())
		.andExpect(content().json(mapper.writeValueAsString(expectedSkillType)));

		mvc.perform(MockMvcRequestBuilders.put("/skillType/{id}", 101)
				.contentType(MediaType.APPLICATION_JSON)
				.content(mapper.writeValueAsBytes(expectedSkillType))
				.accept(MediaType.APPLICATION_JSON))
		.andExpect(status().isBadRequest());
	}
	
	@Test
	public void testFindAllActive() throws Exception {
		SkillType activeSkillType = new SkillType(1, "Active", "Active SkillType", true, true, Arrays.asList());
		List<SkillType> expectedSkillTypes = Arrays.asList(activeSkillType);
		when(skillTypeService.findAllActive()).thenReturn(expectedSkillTypes);
		
		mvc.perform(MockMvcRequestBuilders.get("/skillType/active"))
		.andExpect(status().isOk())
		.andExpect(content().json(mapper.writeValueAsString(expectedSkillTypes)));
	}
	
	@Test
	public void testFindAllActiveNoContent() throws Exception {
		List<SkillType> expectedSkillTypes = new ArrayList<>();
		when(skillTypeService.findAllActive()).thenReturn(expectedSkillTypes);
		
		mvc.perform(MockMvcRequestBuilders.get("/skillType/active"))
		.andExpect(status().isNoContent());
	}
	
	public void testAddSkillById() throws Exception {
		Skill skill = new Skill(1, "Test", true);
		
		SkillType skillType = new SkillType(1, "Test", "Test add skill to skillType", true, true, new ArrayList<Skill>());
		SkillType expectedSkillType = new SkillType(1, "Test", "Test add skill to SkillType", true, true, new ArrayList<Skill>());
		expectedSkillType.addSkill(skill);
		
		when(skillTypeService.addSkill(skillType.getSkillTypeId(), skill.getSkillID())).thenReturn(expectedSkillType);
		mvc.perform(MockMvcRequestBuilders.put("/skillType/{skillTypeId}/skill/{skillId}", skillType.getSkillTypeId(), skill.getSkillID())
				.accept(MediaType.APPLICATION_JSON))
		.andExpect(status().isAccepted())
		.andExpect(content().json(mapper.writeValueAsString(expectedSkillType)));
	}
	
	@Test
	public void testAddSkillByName() throws Exception {
		Skill skill = new Skill(1, "Test", true);
		
		SkillType skillType = new SkillType(1, "Test", "Test add skill to skillType", true, true, new ArrayList<Skill>());
		SkillType expectedSkillType = new SkillType(1, "Test", "Test add skill to SkillType", true, true, new ArrayList<Skill>());
		expectedSkillType.addSkill(skill);
		
		when(skillTypeService.addSkill(skillType.getSkillTypeName(), skill.getSkillName())).thenReturn(expectedSkillType);
		mvc.perform(MockMvcRequestBuilders.put("/skillType/name/{skillTypeName}/skill/name/{skillName}", "Test", "Test")
				.accept(MediaType.APPLICATION_JSON))
		.andExpect(status().isAccepted())
		.andExpect(content().json(mapper.writeValueAsString(expectedSkillType)));
	}
}
