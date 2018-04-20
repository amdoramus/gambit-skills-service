package com.revature.gambit.skill.controllers;

import javax.validation.Valid;

import com.revature.gambit.skill.services.SkillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.revature.gambit.skill.beans.Skill;
import com.revature.gambit.skill.repo.SkillRepository;
import com.revature.gambit.skill.services.ISkillService;

@RestController
public class SkillController {

    @Autowired
    private SkillService skillService;

    @Autowired
    private SkillRepository skillRepository;
    
    @Autowired
    private ISkillService iskillService;


    @PostMapping("/skill")
    public Skill create(@Valid @RequestBody Skill skill) { return this.skillService.create(skill); }

    @GetMapping("/skill")
    public Iterable<Skill> findAll(){
        return this.skillService.findAll();
    }
    
    @DeleteMapping("/skill/{id}")
    public ResponseEntity<Void> deleteSkillOfId(@PathVariable("id") Integer id) {
    		iskillService.deleteSkillViaId(id);
    		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    		
    }
    
//    @DeleteMapping("/skill/{name}")
//    public ResponseEntity<Void> deleteSkillofName(@PathVariable("name") String name) {
//    		iskillService.deleteSkillViaName(name);
//    		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
//    		
//    }



}

