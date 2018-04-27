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
     * Handles incoming PUT request that will update an existing skill type with a
     * new one.
     *
     * @param skillType
     *            Existing skill type will be updated with this one.
     * @param name
     *            Name of the skill type to update.
     * @return HTTP status code 202 (ACCEPTED) if success, HTTP status code 404 (NOT
     *         FOUND) otherwise.
     */
    @PutMapping(value = "/skillType/name/{name}")
    public ResponseEntity<SkillType> update(@Valid @RequestBody SkillType skillType, @PathVariable String name) {
        try {
            if (java.net.URLDecoder.decode(name, "UTF-8").equals(skillType.getSkillTypeName())) {
                return new ResponseEntity<>(this.skillTypeService.update(skillType),HttpStatus.ACCEPTED);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    /**
     * Handles incoming PUT request that will update an existing skill type with a
     * new one.
     *
     * @param skillType
     *            Existing skill type will be updated with this one.
     * @param id
     *            Id of the skill type to update.
     * @return HTTP status code 202 (ACCEPTED) if success, HTTP status code 404 (NOT
     *         FOUND) otherwise.
     */
    @PutMapping(value = "/skillType/{id}")
    public ResponseEntity<SkillType> update(@Valid @RequestBody SkillType skillType, @PathVariable int id) {

        if ( id == skillType.getSkillTypeId()) {
            return new ResponseEntity<>(this.skillTypeService.update(skillType),HttpStatus.ACCEPTED);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }

}
