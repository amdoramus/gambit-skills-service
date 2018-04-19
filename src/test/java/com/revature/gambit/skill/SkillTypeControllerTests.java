package com.revature.gambit.skill;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

import java.util.Arrays;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.revature.gambit.skill.beans.SkillType;
import com.revature.gambit.skill.controllers.SkillTypeController;
import com.revature.gambit.skill.repo.SkillTypeRepository;

@RunWith(SpringRunner.class)
@WebMvcTest(SkillTypeController.class)
public class SkillTypeControllerTests {

	
	@Autowired
	private MockMvc mvc;
	
	@MockBean
	private SkillTypeRepository repository;
	
	@Test
	public void getSkillType() throws Exception{
		SkillType skill = new SkillType("Java", "I can code in Java", true, true);
		Iterable<SkillType> skills = Arrays.asList(skill);
		
		mvc.perform(get("/skilltype")).andExpect(content().string("[]"));
		
	}
}
