package com.revature.gambit.skill.controllers;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.revature.gambit.skill.beans.SkillType;
import com.revature.gambit.skill.services.SkillTypeService;

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
		return new ResponseEntity<>(this.skillTypeService.create(skillType), HttpStatus.CREATED);
	}

	@DeleteMapping("/skilltype/name/{name}")
	public ResponseEntity<Void> deleteSkillTypeByName(@PathVariable String name) {
		SkillType skillType = skillTypeService.findBySkillTypeName(name);

		if (skillType != null) {
			skillType.setIsActive(false);
			this.skillTypeService.update(skillType);
		}

		return new ResponseEntity<Void>(HttpStatus.ACCEPTED);
	}


	@DeleteMapping("/skilltype/{id}")
	public ResponseEntity<Void> deleteSkillTypeById(@PathVariable int id) {
		SkillType skillType = this.skillTypeService.findBySkillTypeId(id);

		if (skillType != null) {
			skillType.setIsActive(false);
			this.skillTypeService.update(skillType);
		}

		return new ResponseEntity<Void>(HttpStatus.ACCEPTED);
	}

	/**
	 * Handles incoming GET request that grabs all the skill types.
	 *
	 * @return Iterable object containing all the skill types retrieved along with
	 *         HTTP status code 200 (OK)
	 */
	@GetMapping("/skillType")
	public ResponseEntity<Iterable<SkillType>> findAll() {
		List<SkillType> skillTypes = (List<SkillType>) this.skillTypeService.findAll();
		
		if (skillTypes.isEmpty()) {
			return new ResponseEntity<Iterable<SkillType>>(skillTypes, HttpStatus.NO_CONTENT);
		} else {
			return new ResponseEntity<Iterable<SkillType>>(skillTypes, HttpStatus.OK);
		}
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

	/**
	 * Handles incoming GET request that grabs a specific skill type.
	 *
	 * @param name
	 *            Name of the skill type that needs to be retrieved.
	 * @return Skill type along with HTTP status code 200 (OK) if found, HTTP status
	 *         code 404 (NOT FOUND) otherwise.
	 */
	@GetMapping("/skillType/name/{name}")
	public ResponseEntity<SkillType> findSkill(@PathVariable String name) {
		try {
			SkillType skillType = this.skillTypeService.findBySkillTypeName(java.net.URLDecoder.decode(name, "UTF-8"));
			if (skillType == null) {
				return new ResponseEntity<SkillType>(HttpStatus.NOT_FOUND);
			} else {
				return new ResponseEntity<SkillType>(
						this.skillTypeService.findBySkillTypeName(java.net.URLDecoder.decode(name, "UTF-8")),
						HttpStatus.OK);
			}
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return new ResponseEntity<SkillType>(HttpStatus.NOT_FOUND);
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
		String skillTypeName = "";
		
		try {
			skillTypeName = URLDecoder.decode(name, "UTF-8");
		} catch (UnsupportedEncodingException e1) {
			return new ResponseEntity<SkillType>(HttpStatus.BAD_REQUEST);
		}

		if (skillTypeName.equals(skillType.getSkillTypeName())) {
			SkillType returned = this.skillTypeService.update(skillType);
			return new ResponseEntity<>(returned, HttpStatus.ACCEPTED);
		} else {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
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

		if (id == skillType.getSkillTypeId()) {
			return new ResponseEntity<>(this.skillTypeService.update(skillType), HttpStatus.ACCEPTED);
		} else {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}

	}

}
