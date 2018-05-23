package com.revature.gambit.controllers;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;
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

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.revature.gambit.entities.BucketDTO;
import com.revature.gambit.entities.SkillType;
import com.revature.gambit.entities.SkillTypeBucketLookup;
import com.revature.gambit.services.SkillTypeBucketLookupService;
import com.revature.gambit.services.SkillTypeService;

/**
 * Controller that will handle requests for the skill type service.
 */
@RestController
@RequestMapping("/skillType")
public class SkillTypeController {

	/**
	 * Interface that contains all CRUD methods for skill type.
	 */
	@Autowired
	private SkillTypeService skillTypeService;
	
	@Autowired
	private SkillTypeBucketLookupService stbls;

	/**
	 * Handles incoming POST request that adds a new skill type to the DB.
	 *
	 * @param skillType
	 *            Incoming data fields will be mapped into this SkillType object.
	 * @return HTTP status code 201 (CREATED)
	 */
	@PostMapping
	public ResponseEntity<SkillType> create(@Valid @RequestBody SkillType skillType) {
		return new ResponseEntity<>(this.skillTypeService.create(skillType), HttpStatus.CREATED);
	}

	/**
	 * Handles DELETE request that soft deletes a SkillType.
	 * @param id The id to soft delete
	 * @return
	 */
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteSkillTypeById(@PathVariable int id) {
		SkillType skillType = this.skillTypeService.findBySkillTypeId(id);

		if (skillType != null) {
			skillType.setIsActive(false);
			this.skillTypeService.update(skillType);
		}

		return new ResponseEntity<>(HttpStatus.ACCEPTED);
	}
	
	/**
	 * Handles DELETE request that soft deletes a SkillType.
	 * @param Name The name to soft delete
	 * @return
	 */
	@DeleteMapping("/name/{name}")
	public ResponseEntity<Void> deleteSkillTypeByName(@PathVariable String name) {
		SkillType skillType = skillTypeService.findBySkillTypeName(name);

		if (skillType != null) {
			skillType.setIsActive(false);
			this.skillTypeService.update(skillType);
		}

		return new ResponseEntity<>(HttpStatus.ACCEPTED);
	}
	
	/**
	 * Handles incoming GET request that grabs all the skill types.
	 *
	 * @return Iterable object containing all the skill types retrieved along with
	 *         HTTP status code 200 (OK)
	 */
	@GetMapping
	public ResponseEntity<Iterable<SkillType>> findAll() {
		List<SkillType> skillTypes = (List<SkillType>) this.skillTypeService.findAll();
		
		if (skillTypes.isEmpty()) {
			return new ResponseEntity<>(skillTypes, HttpStatus.NO_CONTENT);
		} else {
			return new ResponseEntity<>(skillTypes, HttpStatus.OK);
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
	@GetMapping("/{id}")
	public ResponseEntity<SkillType> findSkill(@PathVariable int id) {

		SkillType skillType = this.skillTypeService.findBySkillTypeId(id);
		if (skillType == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<>(
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
	@GetMapping("/name/{name}")
	public ResponseEntity<SkillType> findSkill(@PathVariable String name) {
		String skillTypeName = "";
		
		try {
			skillTypeName = URLDecoder.decode(name, "UTF-8");
		} catch (UnsupportedEncodingException e){
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	
		SkillType skillType = this.skillTypeService.findBySkillTypeName(skillTypeName);
		
		if (skillType == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<>(skillType, HttpStatus.OK);
		}
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
	@PutMapping(value = "/name/{name}")
	public ResponseEntity<SkillType> update(@Valid @RequestBody SkillType skillType, @PathVariable String name) {
		String skillTypeName = "";
		
		try {
			skillTypeName = URLDecoder.decode(name, "UTF-8");
		} catch (UnsupportedEncodingException e1) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
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
	@PutMapping(value = "/{id}")
	public ResponseEntity<SkillType> update(@Valid @RequestBody SkillType skillType, @PathVariable int id) {

		if (id == skillType.getSkillTypeId()) {
			return new ResponseEntity<>(this.skillTypeService.update(skillType), HttpStatus.ACCEPTED);
		} else {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}

	}

	@GetMapping(value = "/active")
	public ResponseEntity<List<SkillType>> findAllActive() {
		List<SkillType> skillTypes = this.skillTypeService.findAllActive();

		if (skillTypes.isEmpty())
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);

		return new ResponseEntity<>(skillTypes, HttpStatus.OK);
	}

	/**
	 * Handles incoming PUT request that will add a Skill to the list of skills in a SkillType.
	 * The Skill must already exist for this method to not return a 404 response.
	 * @param skillTypeId The Id of the SkillType to add to.
	 * @param skillId The Id of the Skill to add.
	 * @return HTTP status code 202 if success, HTTP status code 404 if either the SkillType, or Skill does not exist.
	 */
	@PutMapping(value = "/{skillTypeId}/skill/{skillId}")
	public ResponseEntity<SkillType> updateSkills(@PathVariable int skillTypeId, @PathVariable int skillId) {
		SkillType skillType = this.skillTypeService.addSkill(skillTypeId, skillId);

		if (skillType == null)
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);

		return new ResponseEntity<>(skillType, HttpStatus.ACCEPTED);
	}

	/**
	 * Handles incoming PUT request that will add a Skill to the list of skills in a SkillType.
	 * The Skill must already exist for this method to not return a 404 response.
	 * @param skillTypeName The name of the SkillType to add to.
	 * @param skillName The name of the Skill to add.
	 * @return HTTP status code 202 if success, HTTP status code 404 if either the SkillType, or Skill does not exist.
	 */
	@PutMapping(value = "/name/{skillTypeName}/skill/name/{skillName}")
	public ResponseEntity<SkillType> updateSkills(@PathVariable String skillTypeName, @PathVariable String skillName) {
		SkillType skillType = this.skillTypeService.addSkill(skillTypeName, skillName);

		if (skillType == null)
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);

		return new ResponseEntity<>(skillType, HttpStatus.ACCEPTED);
	}
	
	@PostMapping(value="/setSkillTypeBucket", consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<SkillTypeBucketLookup>> setSkillTypeBucket(ObjectNode on) {
		ObjectMapper mapper = new ObjectMapper();
		try {
			String aStr = mapper.writeValueAsString(on.get("skillType"));
			SkillType st = mapper.readValue(aStr, SkillType.class);
			String bStr = mapper.writeValueAsString(on.get("skillType"));
			int[] bucketIds = mapper.readValue(bStr, int[].class);
			String cStr = mapper.writeValueAsString(on.get("weights"));
			double[] weights = mapper.readValue(cStr, double[].class);
			if (bucketIds.length != weights.length) {
				return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
			}
			List<SkillTypeBucketLookup> stbl = stbls.addSkillTypeBucketLookups(st, bucketIds, weights);
			return new ResponseEntity<>(stbl, HttpStatus.CREATED);
		}
		catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@PutMapping(value="/updateSkillTypeBucket", consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Void> updateSkillTypeBucket() {
		return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	}
	
	@GetMapping(value="/getSkillTypeBuckets/{id}", produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<BucketDTO>> getSkillTypeBuckets(@PathVariable("id") Integer skillTypeId) {
		SkillType st = skillTypeService.findBySkillTypeId(skillTypeId);
		List<SkillTypeBucketLookup> stbl = stbls.getSkillTypeBucketLookupsBySkillType(st);
		List<BucketDTO> buckets = new ArrayList<>();
		for (SkillTypeBucketLookup s : stbl) {
			buckets.add(s.getSkillTypeBucketId().getBucket());
		}
		return new ResponseEntity<>(buckets, HttpStatus.OK);
	}
	
	@GetMapping(value="/getSkillType/{id}", produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<SkillTypeBucketLookup>> getSkillTypeBucketWithWeights(@PathVariable("id") Integer skillTypeId) {
		SkillType st = skillTypeService.findBySkillTypeId(skillTypeId);
		List<SkillTypeBucketLookup> stbl = stbls.getSkillTypeBucketLookupsBySkillType(st);
		return new ResponseEntity<>(stbl, HttpStatus.OK);
	}
}
