package com.revature.gambit.skill.services;

import com.revature.gambit.skill.beans.SkillType;
import com.revature.gambit.skill.repo.SkillTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SkillTypeService {

    @Autowired
    private SkillTypeRepository skillTypeRepository;

    public SkillType create(SkillType skillType) { return this.skillTypeRepository.save(skillType); }

    public SkillType findByID(int id) { return this.skillTypeRepository.findBySkillTypeID(id); }

    public List<SkillType> findByAll() { return this.skillTypeRepository.findAll(); }

    public SkillType update(SkillType updatedSkillType , String name){
        SkillType skillType =  this.skillTypeRepository.findBySkillTypeName(name);
        skillType.setSkillTypeDesc(updatedSkillType.getSkillTypeDesc());
        skillType.setIsCore(updatedSkillType.isIs_core());
        skillType.setIsActive(updatedSkillType.isIsActive());
        return this.skillTypeRepository.saveAndFlush(skillType);
    }

    public int updateAll(){ return 405; }

}