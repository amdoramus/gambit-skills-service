package com.revature.gambit.skill;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Arrays;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultActions;

import com.revature.gambit.skill.beans.SkillType;
import com.revature.gambit.skill.controllers.SkillTypeController;
import com.revature.gambit.skill.repo.SkillTypeRepository;

@RunWith(SpringRunner.class)
@WebMvcTest(SkillTypeController.class)
public class SkillTypeControllerTests {

	
	@Autowired
	private MockMvc mvc;
	
	@MockBean
	private SkillTypeController repository;

	@Test
	public void getSkillType() throws Exception{
		
		SkillType skillT = new SkillType(100, "Java", "I can code in Java", true, true);
		Iterable<SkillType> skills = Arrays.asList(skillT);
	 
		mvc.perform((RequestBuilder) ((ResultActions) get("/skilltype")
			.contentType(MediaType.APPLICATION_JSON))
			.andDo(print())
			.andExpect(content().string("[]")));
		
	//	mvc.perform(get("/api/employees")
	//		      .contentType(MediaType.APPLICATION_JSON))
	//		      .andExpect(status().isOk())
	//		      .andExpect(jsonPath("$[0].name", is(alex.getName())));
	}

	
}
