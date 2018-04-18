package com.revature.gambit.skill.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revature.gambit.skill.beans.Skill;

@Repository
public interface SkillRepository extends JpaRepository<Skill, Integer> {


}
