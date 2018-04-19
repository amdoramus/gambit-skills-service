package com.revature.gambit.skill.services;

import com.revature.gambit.skill.repositories.SkillTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class SkillTypeService {

    @Autowired
    private SkillTypeRepository skillTypeRepository;

}