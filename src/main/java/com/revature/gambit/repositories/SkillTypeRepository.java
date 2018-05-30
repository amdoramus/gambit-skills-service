package com.revature.gambit.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revature.gambit.entities.SkillType;

/**
 * Spring Data repository interface for SkillType service. Defines the<br>
 * boilerplate methods that will be used
 */
@Repository
public interface SkillTypeRepository extends JpaRepository<SkillType, Integer> {
	
    /**
     * Looks up a SkillType based on the SkillType name
     *
     * @param name - name of the SkillTypeBucketLookup
     * @return Skill that was found
     */
    SkillType findBySkillTypeName(String name);
    
    /**
     * Finds SkillTypes based on their isActive flag
     * 
     * @param isActive - boolean representing the isActive flag
     * @return a list of SkillTypes
     */
    List<SkillType> findAllByIsActive(boolean isActive);

}
