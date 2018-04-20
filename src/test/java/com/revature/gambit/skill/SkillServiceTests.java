package com.revature.gambit.skill;

import static org.junit.Assert.assertEquals;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import com.revature.gambit.skill.beans.Skill;
import com.revature.gambit.skill.services.SkillService;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class SkillServiceTests {

    @Autowired
    private SkillService skillService;
    
    @Test
    public void getAllSkills() {
        Iterable<Skill> skill = skillService.findAll();
        assertEquals(41,((List<Skill>) skill).size());
    }
    
}

