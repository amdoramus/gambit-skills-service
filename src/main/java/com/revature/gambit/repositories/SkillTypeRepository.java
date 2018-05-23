package com.revature.gambit.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revature.gambit.entities.SkillType;

/**
 * Spring Data repository interface for Skill type service. Defines the
 * boilerplate methods that will be used.
 */
@Repository
public interface SkillTypeRepository extends JpaRepository<SkillType, Integer> {
	
    /**
     * Looks up a skill type based on the skill type name.
     *
     * @param name
     *            Name of the skill type to lookup.
     * @return Skill that was found.
     */
    SkillType findBySkillTypeName(String name);
    
    /**
     * Finds SkillTypes based on their isActive flag.
     * @param isActive Boolean representing the isActive flag.
     * @return A list of SkillTypes
     */
    List<SkillType> findAllByIsActive(boolean isActive);
}
