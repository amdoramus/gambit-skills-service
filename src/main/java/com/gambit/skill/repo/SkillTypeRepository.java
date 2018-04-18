package com.gambit.skill.repo;

import com.gambit.skill.beans.SkillTypes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SkillTypeRepository extends JpaRepository<SkillTypes,Integer> {


}
