package com.revature.gambit.skill.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TestTransaction;

import com.revature.gambit.skill.services.SkillService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = TestConfig.class)
public class TestSkill extends AbstractTransactionalJUnit4SpringContextTests {
	
	@Test
	public void deleteSkillViaId() {
		assertNumSkills(2);
		SkillService skillser = new SkillService();
		skillser.deleteSkillViaId(2);
		
		
		TestTransaction.flagForCommit();
        TestTransaction.end();
        assertFalse(TestTransaction.isActive());
        assertNumSkills(1);
        
        TestTransaction.start();
	}
	
	
	@Test
	public void deleteSkillViaName() {
		assertNumSkills(2);
		SkillService skillser = new SkillService();
		skillser.deleteSkillViaName("java");		
		
		TestTransaction.flagForCommit();
        TestTransaction.end();
        assertFalse(TestTransaction.isActive());
        assertNumSkills(1);
        
        TestTransaction.start();
	}
	
	
	
	protected void assertNumSkills(int expected) {
        assertEquals("Number of rows in the [skill] table.", expected, countRowsInTable("user"));
    }

}
