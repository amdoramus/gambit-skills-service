package com.revature.controllers;

import com.revature.data.SkillTypeRepository;
import com.revature.domain.SkillType;
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
    public SkillType create(@Valid @RequestBody SkillType skillType) {
        return skillTypeRepository.save(skillType);
    }

    @GetMapping("/skilltype")
    public Iterable<SkillType> findAll(){
        return skillTypeRepository.findAll();
    }

}
