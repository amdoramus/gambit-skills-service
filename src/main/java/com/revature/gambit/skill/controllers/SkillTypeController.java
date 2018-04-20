package com.revature.gambit.skill.controllers;

import java.io.UnsupportedEncodingException;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.revature.gambit.skill.beans.SkillType;
import com.revature.gambit.skill.services.ISkillTypeService;
import com.revature.gambit.skill.services.SkillTypeService;

@RestController
public class SkillTypeController {

    @Autowired
    private SkillTypeService skillTypeService;
    
    @Autowired
    private ISkillTypeService iskillTypeService;

    @PostMapping("/skilltype")
    public SkillType create(@Valid @RequestBody SkillType skillType) { return this.skillTypeService.create(skillType); }

    @GetMapping("/skilltype")
    public Iterable<SkillType> findAll(){
        return this.skillTypeService.findByAll();
    }

    @GetMapping("/skilltype/{name}")
    public SkillType findSkill(@PathVariable String name){
        try {
            return this.skillTypeService.findBySkillTypeName(java.net.URLDecoder.decode(name,"UTF-8"));

        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        return null;
    }

   @PutMapping(value = "/skilltype/{name}",consumes = MediaType.APPLICATION_JSON_VALUE)
   public boolean update(@Valid @RequestBody SkillType skillType, @PathVariable String name){
       try {
           return this.skillTypeService.update(skillType,java.net.URLDecoder.decode(name,"UTF-8"));

       } catch (UnsupportedEncodingException e) {
           e.printStackTrace();
       }
       return false;

   }

   @DeleteMapping("/skilltype/{name}")
   public ResponseEntity<Void> deleteSkillofName(@PathVariable String name) {
   		iskillTypeService.deleteBySkillTypeName(name);
   		return new ResponseEntity<Void>( HttpStatus.ACCEPTED);
//   		java.net.URLDecoder.decode("/", "UTF-8"),
   }



}
