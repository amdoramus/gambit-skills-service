package com.revature.gambit.skill;

import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.hamcrest.CoreMatchers.is;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


import java.util.Arrays;
import java.util.List;

import com.revature.gambit.skill.services.SkillTypeService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.revature.gambit.skill.beans.SkillType;
import com.revature.gambit.skill.controllers.SkillTypeController;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@RunWith(SpringJUnit4ClassRunner.class)
public class SkillTypeControllerTests {

	private MockMvc mvc;

	@InjectMocks
	private SkillTypeController skillTypeController;

	@Mock
	private SkillTypeService skillTypeService;

	@Before
	public void setUp() throws Exception {
		mvc = MockMvcBuilders.standaloneSetup(skillTypeController).build();
	}

	@Test
	public void getSkillType() throws Exception{
		
		SkillType skill1 = new SkillType(100, "Java", "I can code in Java", true, true);
		SkillType skill2 = new SkillType(101, "Fortran", "What is Fortran", true, true);

		Iterable<SkillType> skills = Arrays.asList(skill1,skill2);

		when(skillTypeService.findByAll()).thenReturn((List<SkillType>) skills);
	 
		mvc.perform(MockMvcRequestBuilders.get("/skilltype")
				.accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk());

	}

	@Test
	public void getSkillTypeByName() throws Exception{

        SkillType skill1 = new SkillType(100, "Java", "I can code in Java", true, true);
        SkillType skill2 = new SkillType(101, "Fortran", "What is Fortran", true, true);

        Iterable<SkillType> skills = Arrays.asList(skill1,skill2);

        when(skillTypeService.findBySkillTypeName("Java")).thenReturn(((List<SkillType>) skills).get(0));
        when(skillTypeService.findBySkillTypeName("Fortran")).thenReturn(((List<SkillType>) skills).get(1));

		mvc.perform(MockMvcRequestBuilders.get("/skilltype/{name}", "Java")
				.accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk());

        mvc.perform(MockMvcRequestBuilders.get("/skilltype/{name}", "Fortran")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());

	}

    @Test
    public void getSkillTypeByNameDoesNotExist() throws Exception {

        mvc.perform(MockMvcRequestBuilders.get("/skilltype/{name}", "jv")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }



}
