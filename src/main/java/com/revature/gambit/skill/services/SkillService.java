package com.revature.gambit.skill.services;

import com.revature.gambit.skill.beans.Skill;
import com.revature.gambit.skill.repo.SkillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SkillService {

    @Autowired
    private SkillRepository skillRepository;

    public Skill create(Skill skill) { return this.skillRepository.save(skill); }

    public Iterable<Skill> findAll() { return this.skillRepository.findAll(); }

    public Skill findById(int id) { return this.skillRepository.findBySkillID(id); }
    
    

}
