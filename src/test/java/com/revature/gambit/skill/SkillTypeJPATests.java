package com.revature.gambit.skill;

import com.revature.gambit.skill.beans.SkillType;
import com.revature.gambit.skill.services.SkillTypeService;
import org.junit.*;
import org.junit.runner.RunWith;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class SkillTypeJPATests {

    @Autowired
    private SkillTypeService skillTypeService;

    @Test
    public void getAllSkillTypes() {
        Iterable<SkillType> skillTypes = skillTypeService.findByAll();
        assertEquals(9,((List<SkillType>) skillTypes).size());
    }

    @Test
    public void getSkillTypeByName() {
        SkillType stk = skillTypeService.findBySkillTypeName("PEGA");
        assertEquals(stk.getSkillTypeDesc(),"PEGA Description");
    }
    
}
