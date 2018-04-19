package com.revature.gambit.skill.controllers;

import com.revature.gambit.skill.beans.SkillType;

import com.revature.gambit.skill.services.SkillTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.io.UnsupportedEncodingException;

@RestController
public class SkillTypeController {

    @Autowired
    private SkillTypeService skillTypeService;

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
   public int update(@Valid @RequestBody SkillType skillType, @PathVariable String name){
       try {
           return this.skillTypeService.update(skillType,java.net.URLDecoder.decode(name,"UTF-8"));

       } catch (UnsupportedEncodingException e) {
           e.printStackTrace();
       }

       return 400;
   }





}
