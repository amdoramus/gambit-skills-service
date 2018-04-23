package com.revature.gambit.skill.controllers;

import com.revature.gambit.skill.services.SkillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SkillController {

    @Autowired
    private SkillService skillService;


}
