package com.revature.gambit.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revature.gambit.entities.SkillType;

/**
 * Spring Data repository interface for skill type service. Defines the<br>
 * boilerplate methods that will be used
 */
@Repository
public interface SkillTypeRepository extends JpaRepository<SkillType, Integer> {
	
    /**
     * Looks up a skill type based on the skill type name
     *
     * @param name - name of the skill type to lookup
     * @return skill that was found
     */
    SkillType findBySkillTypeName(String name);
    
    /**
     * Finds skill types based on their isActive flag
     * 
     * @param isActive - boolean representing the isActive flag
     * @return a list of skill types
     */
    List<SkillType> findAllByIsActive(boolean isActive);

}
