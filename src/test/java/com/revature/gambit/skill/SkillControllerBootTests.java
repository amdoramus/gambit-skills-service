package com.revature.gambit.skill;

import javax.ws.rs.core.Application;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.revature.gambit.skill.controllers.SkillController;

//@RunWith(SpringRunner.class)
//@SpringBootTest(
//		webEnvironment = WebEnvironment.RANDOM_PORT,
//		classes = Application.class)
//@AutoConfigureMockMvc
//@TestPropertySource(
//		locations = "classpath:application-integrationtest.properties")
public class SkillControllerBootTests {

	@Autowired
	private MockMvc mvc;
	
	@Autowired
	private SkillController controller;
	
	
	@Test
	public void getSkills() {
		
	}
}
