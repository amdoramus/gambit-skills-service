package com.revature.gambit.skill.controllers;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.revature.gambit.skill.beans.Skill;
import com.revature.gambit.skill.services.SkillService;

/**
 * Controller that will handle requests for the skill service.
 */
@RestController
public class SkillController {

	/**
	 * Service that contains all the business logic (methods) to be executed for
	 * this controller based on the request type.
	 */
	@Autowired
	private SkillService skillService;


	/**
	 * Handles incoming POST request that adds a new skill to the DB.
	 *
	 * @param skill
	 *            Incoming data fields will be mapped into this object.
	 * @return HTTP status code 201 (CREATED)
	 */
	@PostMapping("/skill")
	public ResponseEntity<Void> create(@Valid @RequestBody Skill skill) {
		this.skillService.create(skill);
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}

	/**
	 * Handles incoming GET request that grabs all the skills.
	 *
	 * @return Iterable object containing all the skills retrieved along with HTTP
	 *         status code 200 (OK)
	 */
	@GetMapping("/skill")
	public ResponseEntity<Iterable<Skill>> findAll() {
		return new ResponseEntity<Iterable<Skill>>(this.skillService.findAll(), HttpStatus.OK);
	}


}
