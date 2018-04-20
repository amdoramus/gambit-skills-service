package com.revature.gambit.skill.controllers;

import com.revature.gambit.skill.services.SkillTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class SkillTypeController {

    @Autowired
    private SkillTypeService skillTypeService;


}
