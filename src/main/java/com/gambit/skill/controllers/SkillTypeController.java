package com.gambit.skill.controllers;

import com.gambit.skill.beans.SkillTypes;
import com.gambit.skill.repo.SkillTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class SkillTypeController {

    @Autowired
    private SkillTypeRepository skillTypeRepository;

    @PostMapping("/skilltype")
    public SkillTypes create(@Valid @RequestBody SkillTypes skillType) {
        return skillTypeRepository.save(skillType);
    }

    @GetMapping("/skilltype")
    public Iterable<SkillTypes> findAll(){
        return skillTypeRepository.findAll();
    }

}
