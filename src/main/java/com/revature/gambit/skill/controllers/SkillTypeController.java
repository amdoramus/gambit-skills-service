package com.revature.gambit.skill.controllers;

import com.revature.gambit.skill.beans.SkillType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.revature.gambit.skill.services.SkillTypeService;

import javax.validation.Valid;

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

	@DeleteMapping("/skilltype/name/{name}")
	public ResponseEntity<Void> deleteSkillTypeByName(@PathVariable String name) {
		skillTypeService.deleteBySkillTypeName(name);
		return new ResponseEntity<>(HttpStatus.ACCEPTED);
	}


	@DeleteMapping("/skilltype/{id}")
	public ResponseEntity<Boolean> deleteSkillTypeByName(@PathVariable int id) {
		SkillType skillType = this.skillTypeService.findBySkillTypeId();
		
		skillType.setIsActive(false);
		this.skillTypeService.update(skillType);
		return new ResponseEntity<Boolean>(true, HttpStatus.ACCEPTED);
	}

}
