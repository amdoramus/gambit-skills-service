package com.revature.gambit.skill.controllers;

import com.revature.gambit.skill.beans.SkillType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.revature.gambit.skill.services.SkillTypeService;

import javax.validation.Valid;
import java.io.UnsupportedEncodingException;

/**
 * Controller that will handle requests for the skill type service.
 */
@RestController
public class SkillTypeController {

	/**
	 * Interface that contains all CRUD methods for skill type.
	 */
	@Autowired
	private SkillTypeService skillTypeService;

    /**
     * Handles incoming POST request that adds a new skill type to the DB.
     *
     * @param skillType
     *            Incoming data fields will be mapped into this SkillType object.
     * @return HTTP status code 201 (CREATED)
     */
    @PostMapping("/skillType")
    public ResponseEntity<SkillType> create(@Valid @RequestBody SkillType skillType) {
        return new ResponseEntity<>(this.skillTypeService.create(skillType),HttpStatus.CREATED);
    }

    /**
     * Handles incoming GET request that grabs all the skill types.
     *
     * @return Iterable object containing all the skill types retrieved along with
     *         HTTP status code 200 (OK)
     */
    @GetMapping("/skillType")
    public ResponseEntity<Iterable<SkillType>> findAll() {
        return new ResponseEntity<Iterable<SkillType>>(this.skillTypeService.findByAll(), HttpStatus.OK);
    }

    /**
     * Handles incoming GET request that grabs a specific skill type.
     *
     * @param id
     *            Id of the skill type that needs to be retrieved.
     * @return Skill type along with HTTP status code 200 (OK) if found, HTTP status
     *         code 404 (NOT FOUND) otherwise.
     */
    @GetMapping("/skillType/{id}")
    public ResponseEntity<SkillType> findSkill(@PathVariable int id) {

        SkillType skillType = this.skillTypeService.findBySkillTypeId(id);
        if (skillType == null) {
            return new ResponseEntity<SkillType>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<SkillType>(
                    this.skillTypeService.findBySkillTypeId(id),
                    HttpStatus.OK);
        }
    }

}
