package com.revature.gambit.skill.controllers;

import com.revature.gambit.skill.beans.Skill;
import com.revature.gambit.skill.repo.SkillRepository;

import javax.validation.Valid;

import com.revature.gambit.skill.services.SkillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.UnsupportedEncodingException;
import java.util.List;
@RestController
public class SkillController {

    @Autowired
    private SkillService skillService;

    @PostMapping("/skill")
    public ResponseEntity<Void> create(@Valid @RequestBody Skill skill) {
        this.skillService.create(skill);
        return new ResponseEntity<Void>(HttpStatus.CREATED);
    }

    @GetMapping("/skill")
    public ResponseEntity<Iterable<Skill>> findAll(){
        return new ResponseEntity<Iterable<Skill>>(this.skillService.findAllSkill() , HttpStatus.OK);
    }
    
    @GetMapping("/skill/active")
    public Iterable<Skill> findActive(){
    	return this.skillService.findAllActive();
    }

    @PutMapping
    public ResponseEntity<Void> update(@RequestBody Skill updatedSkill) {

        this.skillService.saveSkill(updatedSkill);
        return  new ResponseEntity<Void>(HttpStatus.ACCEPTED);
    }

    @GetMapping("/skill/{name}")
    public ResponseEntity<Skill> findById(@PathVariable String name) {
        try {
            return new ResponseEntity<Skill>(this.skillService.findByName(java.net.URLDecoder.decode(name,"UTF-8")) , HttpStatus.OK);

        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        return new ResponseEntity<Skill>(HttpStatus.NOT_FOUND);
    }
    
}
