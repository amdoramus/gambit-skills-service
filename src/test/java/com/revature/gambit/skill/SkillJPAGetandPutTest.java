package com.revature.gambit.skill;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.mockito.Mockito.when;

import java.util.List;

import java.util.Arrays;
import java.util.List;

import org.junit.Before;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;

import com.revature.gambit.skill.beans.Skill;
import com.revature.gambit.skill.beans.SkillType;
import com.revature.gambit.skill.repo.SkillRepository;
import com.revature.gambit.skill.services.SkillService;
import com.revature.gambit.skill.services.SkillTypeService;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class SkillJPAGetandPutTest {

    @Autowired
    private SkillService skillService;
    
    @Test
    public void testFindAllSkills() {
        Iterable<Skill> skill = skillService.findAllSkill();
        assertEquals(41, ((List<Skill>) skill).size());
    }
    
    @Test
    public void testFindBySkillName() {
    	Skill skill = skillService.findByName("Java");
    	assertEquals(skill.getSkillName(), "Java");
    }
 
    
    @Test
    public void testFindAllByIsActive() {
    	List<Skill> skills = skillService.findAllActive();
    	assertEquals(skills.size(), 40);
    }
    
    @Test
    public void testSaveSkill() {
    	Skill skill1 = skillService.findById(1);
    	Skill skill2 = skillService.saveSkill(new Skill(1, "Javas", true));
    	assertNotEquals(skill2.getSkillName(), skill1.getSkillName());
    	Skill skill3 = skillService.saveSkill(new Skill(1, skill1.getSkillName(), true));
    	assertEquals(skill1.getSkillName(), skill3.getSkillName());
    }
}
