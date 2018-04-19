package com.revature.gambit.skill.controllers;

import com.revature.gambit.skill.beans.SkillType;
import com.revature.gambit.skill.repo.SkillTypeRepository;

import com.revature.gambit.skill.services.SkillTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public class SkillTypeController {

    @Autowired
    private SkillTypeService skillTypeService;

//    @PostMapping("/skilltype")
//    public SkillType create(@Valid @RequestBody SkillType skillType) { return this.skillTypeService.create(skillType); }

//    @GetMapping("/skilltype")
//    public Iterable<SkillType> findAll(){
//        return this.skillTypeService.findByAll();
//    }

    @GetMapping("/skilltype")
    public String findAll(){
        return "hello";
    }

}
