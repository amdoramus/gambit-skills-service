package com.revature.gambit.skill;

import com.revature.gambit.skill.repo.SkillTypeRepository;
import com.revature.gambit.skill.services.SkillTypeServiceImpl;
import org.junit.runner.RunWith;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class SkillTypeServiceTests {

	@Autowired
	private SkillTypeServiceImpl skillTypeService;
	
	@Autowired
	private SkillTypeRepository skillTypeRepository;
	
}
