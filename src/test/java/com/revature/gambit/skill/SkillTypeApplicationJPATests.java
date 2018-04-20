package com.revature.gambit.skill;

import static org.junit.Assert.assertNotEquals;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.revature.gambit.skill.beans.SkillType;
import com.revature.gambit.skill.services.SkillTypeService;


@RunWith(SpringRunner.class)
@SpringBootTest
public class SkillTypeApplicationJPATests {
	
	@Autowired
	private SkillTypeService skillTypeService;
	
	
	@Test
	public void testDeleteSkillTypeFunction() {
		List<SkillType> skillTypes = this.skillTypeService.findByAll();
		this.skillTypeService.deleteBySkillTypeName("PEGA");
		List<SkillType> skillTypess = this.skillTypeService.findByAll();
		assertNotEquals(skillTypes, skillTypess);
	}

}
