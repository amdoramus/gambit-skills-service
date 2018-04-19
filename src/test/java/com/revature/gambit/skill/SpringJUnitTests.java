package com.revature.gambit.skill;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.revature.gambit.skill.beans.Skill;
import com.revature.gambit.skill.repo.SkillRepository;

@RunWith(SpringJUnit4ClassRunner.class)
public class SpringJUnitTests {
	
	private MockMvc mockMvc;
	
	@InjectMocks
	private SkillRepository repository;
	
	@Mock
	private Skill skill;
	
	@Before
	public void setUp() throws Exception {
		mockMvc = MockMvcBuilders.standaloneSetup(repository).build();
	}
	
	@Test
	public void testGetAllSKills() throws Exception {
		List<Skill> skills = new ArrayList<>();
		skills.add(new Skill(1, "Java", true));
		skills.add(new Skill(1, "SQL", true));
		
		when(skill.findAll()).thenReturn((List) batches);
		
		
	}
	
}










