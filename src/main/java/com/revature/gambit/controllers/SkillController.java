package com.revature.gambit.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.gambit.entities.Skill;
import com.revature.gambit.services.SkillService;

import io.swagger.annotations.ApiOperation;

/**
 * Controller that will handle requests for the skill service
 */
@RestController
@RequestMapping("/skill")
public class SkillController {

	/**
	 * Service that contains all the business logic (methods) to be executed for<br>
	 * this controller based on the request type
	 */
	@Autowired
	private SkillService skillService;

	/**
	 * Handles incoming POST request that adds a new skill to the DB
	 *
	 * @param skill - incoming data fields will be mapped into this object
	 * @return added skill and HTTP status code 201 (CREATED)
	 */
	@ApiOperation(value = "Adds a new skill", response = Skill.class)
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Skill> create(@Valid @RequestBody Skill skill) {
		return new ResponseEntity<>(this.skillService.create(skill), HttpStatus.CREATED);
	}

	/**
	 * Handles incoming GET request that grabs all the skills
	 *
	 * @return list object containing all the skills retrieved along with HTTP<br>
	 *         status code 200 (OK); otherwise, HTTP status code 204 (NO_CONTENT) if no skills exist
	 */
	@ApiOperation(value = "Gets a list of skills", response = Skill.class, responseContainer = "List")
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Skill>> findAll() {
		List<Skill> skills = (List<Skill>) this.skillService.findAll();

		if (skills.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} else {
			return new ResponseEntity<>(skills, HttpStatus.OK);
		}
	}

	/**
	 * Handles incoming GET request that gets a skill by its name
	 * 
	 * @param name - name of the skill
	 * @return skill retrieved along with HTTP status code 200 (OK); otherwise,<br>
	 * null is returned along with HTTP status code 404 (NOT_FOUND)
	 */
	@ApiOperation(value = "Get a skill by its name", response = Skill.class)
	@GetMapping(value = "/name/{name}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Skill> findByName(@PathVariable String name) {
		Skill skill = this.skillService.findBySkillName(name);

		if (skill == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<>(skill, HttpStatus.OK);
		}
	}

	/**
	 * Handles incoming GET request that gets a skill by its id
	 * 
	 * @param id - skill's id
	 * @return skill retrieved along with HTTP status code 200 (OK); otherwise,<br>
	 * null is returned along with HTTP status code 404 (NOT_FOUND)
	 */
	@ApiOperation(value = "Get a skill by its id", response = Skill.class)
	@GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Skill> findById(@PathVariable int id) {
		Skill skill = this.skillService.findBySkillID(id);

		if (skill == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<>(skill, HttpStatus.OK);
		}
	}

	/**
	 * Soft delete by name. Sets the skill to inactive
	 * 
	 * @param name - name of skill
	 * @return skill with an updated state along with HTTP status code 202 (ACCEPTED)
	 */
	@ApiOperation(value = "Finds a skills by name and sets it to active or inactive", response = Skill.class)
	@DeleteMapping(value = "/name/{name}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Skill> deactivateBySkillName(@PathVariable String name) {
		Skill skill = skillService.findBySkillName(name);

		if (skill != null) {
			skill.setIsActive(false);
			skill = skillService.saveSkill(skill);
		}

		return new ResponseEntity<>(skill, HttpStatus.ACCEPTED);
	}

	/**
	 * Soft delete by id. Sets the skill to inactive
	 * 
	 * @param id - skill's id
	 * @return Skill with an updated state along with HTTP status code 202 (ACCEPTED)
	 */
	@ApiOperation(value = "Finds a skill by id and sets it to active or inactive", response = Skill.class)
	@DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Skill> deactivateBySkillId(@PathVariable int id) {
		Skill skill = this.skillService.findBySkillID(id);

		if (skill != null) {
			skill.setIsActive(false);
			skill = skillService.saveSkill(skill);
		}

		return new ResponseEntity<>(skill, HttpStatus.ACCEPTED);
	}

	/**
	 * Handles incoming PUT requests to update skill
	 *
	 * @return Skill that was updated and status code 202 (ACCEPTED); otherwise,<br>
	 * HTTP status code 400 (BAD_REQUEST)
	 */
	@ApiOperation(value = "Updates a skill by id", response = Skill.class)
	@PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Skill> update(@PathVariable int id, @RequestBody Skill updatedSkill) {
    	if(id == updatedSkill.getSkillID()) {
    		return new ResponseEntity<>(skillService.saveSkill(updatedSkill), HttpStatus.ACCEPTED);
    	} else {
    		return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    	}
    }
	
	/**
	 * Handles incoming Get requests to find all active Skills
	 * 
	 * @return HTTP status code 200 (OK) if there are active skills,<br> 
	 * 204 (NO_CONTENT) if there are no active skills
	 */
	@ApiOperation(value = "Gets a list of all active skills", response = Skill.class, responseContainer = "List")
	@GetMapping(value = "/active", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Skill>> findAllActive() {
		List<Skill> skills = this.skillService.findAllActive();
		
		if (skills.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(skills, HttpStatus.OK);
	}

}
