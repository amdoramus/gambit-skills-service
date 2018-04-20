package com.revature.gambit.skill;

import static org.hamcrest.CoreMatchers.is;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.assertj.core.util.Arrays;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.revature.gambit.skill.beans.Skill;
import com.revature.gambit.skill.controllers.SkillController;
import com.revature.gambit.skill.services.SkillService;

@RunWith(SpringRunner.class)
@WebMvcTest(SkillController.class)
public class SkillControllerTests {

	@Autowired
	private MockMvc mvc;
	
	@MockBean
	private SkillController controller;

	@Test
	public void getSkillType() throws Exception{

		List<Skill> list = new ArrayList<Skill>() {{
			add(new Skill(1, "Coding", true));
			add(new Skill(2, "java", true));
		}};
		Iterable<Skill> skills = list;
		//when(controller.findAll()).thenReturn(skills);
		mvc.perform(get("/skill"))
			.andExpect(status().isOk());
	}
}
