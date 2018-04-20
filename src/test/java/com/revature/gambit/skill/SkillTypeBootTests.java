package com.revature.gambit.skill;

import com.revature.gambit.skill.beans.SkillType;
import com.revature.gambit.skill.services.SkillTypeService;
import org.junit.*;
import org.junit.runner.RunWith;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class SkillTypeBootTests {

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

    @Test
    public void getSkillTypeNotFound() {
        SkillType stk = skillTypeService.findBySkillTypeName("PEGAN");
        assertNull(stk);
    }

    @Test
    public void updateSkillType() {
        SkillType skillType = skillTypeService.findBySkillTypeName("PEGA");
        skillType.setIsCore(false);
        assertTrue(skillTypeService.update(skillType,"PEGA"));
    }

    @Test
    public void failUpdateSkillType() {
        SkillType skillType = skillTypeService.findBySkillTypeName("PEGAN");
        assertFalse(skillTypeService.update(skillType,"PEGAN"));
    }

}
