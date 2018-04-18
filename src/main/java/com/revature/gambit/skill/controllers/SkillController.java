package com.revature.gambit.skill.controllers;

import com.revature.gambit.skill.beans.Skill;
import com.revature.gambit.skill.repo.SkillRepository;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SkillController {

    @Autowired
    private SkillRepository skillRepository;

    @PostMapping("/skill")
    public Skill create(@Valid @RequestBody Skill skill) {
        return skillRepository.save(skill);
    }

    @GetMapping("/skill")
    public Iterable<Skill> findAll(){
        return skillRepository.findAll();
    }

}
