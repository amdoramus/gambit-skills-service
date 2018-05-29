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
import org.springframework.web.bind.annotation.*;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

import com.revature.gambit.entities.*;
import com.revature.gambit.services.*;

import io.swagger.annotations.ApiOperation;

/**
 * Controller that will handle requests for the skill type service
 */
@RestController
@RequestMapping("/skillType")
public class SkillTypeController {
	
	@Autowired
	private SkillTypeService skillTypeService;
	
	@Autowired
	private SkillTypeBucketLookupService skillTypeBucketLookupService;

	/**
	 * Handles incoming POST request that adds a new skill type to the DB
	 *
	 * @param skillType - SkillType to add
	 * @return created skill type along with HTTP status code 201 (CREATED)
	 */
	@ApiOperation(value = "Adds a new skll type", response = SkillType.class)
	@PostMapping
	public ResponseEntity<SkillType> create(@Valid @RequestBody SkillType skillType) {
		return new ResponseEntity<>(this.skillTypeService.create(skillType), HttpStatus.CREATED);
	}

	/**
	 * Handles DELETE request that soft deletes a skill type
	 * 
	 * @param id - id of skill type
	 * @return skill type whose state was set to inactive (if already inactive, it will remain inactive)<br>
	 * along with HTTP status code 202 (ACCEPTED)
	 */
	@ApiOperation(value = "Finds a skill type by id and sets its state to inactive", response = SkillType.class)
	@DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<SkillType> deleteSkillTypeById(@PathVariable int id) {
		SkillType skillType = this.skillTypeService.findBySkillTypeId(id);

		if (skillType != null) {
			skillType.setIsActive(false);
			skillType = this.skillTypeService.update(skillType);
		}

		return new ResponseEntity<>(skillType, HttpStatus.ACCEPTED);
	}
	
	/**
	 * Handles DELETE request that soft deletes a skill type
	 * 
	 * @param name - name of skill type
	 * @return skill type whose state was set to inactive (if already inactive, it will remain inactive)<br>
	 * along with HTTP status code 202 (ACCEPTED)
	 */
	@ApiOperation(value = "Finds a skill type by its name and sets its state to inactive", response = SkillType.class)
	@DeleteMapping(value = "/name/{name}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<SkillType> deactivateSkillTypeByName(@PathVariable String name) {
		SkillType skillType = skillTypeService.findBySkillTypeName(name);

		if (skillType != null) {
			skillType.setIsActive(false);
			skillType = this.skillTypeService.update(skillType);
		}

		return new ResponseEntity<>(skillType, HttpStatus.ACCEPTED);
	}
	
	/**
	 * Handles incoming GET request that grabs all the skill types
	 *
	 * @return list containing all the skill types retrieved along with
	 *         HTTP status code 200 (OK)
	 */
	@ApiOperation(value = "List of all of the skill types", response = SkillType.class, responseContainer = "List")
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<SkillType>> findAll() {
		List<SkillType> skillTypes = this.skillTypeService.findAll();
		
		if (skillTypes.isEmpty()) {
			return new ResponseEntity<>(skillTypes, HttpStatus.NO_CONTENT);
		} else {
			return new ResponseEntity<>(skillTypes, HttpStatus.OK);
		}
	}

	/**
	 * Handles incoming GET request that grabs a specific skill type
	 *
	 * @param id - id of the skill type that needs to be retrieved
	 * @return skill type along with HTTP status code 200 (OK) if found, HTTP status<br>
	 *         code 404 (NOT FOUND) otherwise
	 */
	@ApiOperation(value = "Gets a skill type by id", response = SkillType.class)
	@GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
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
	 * Handles incoming GET request that grabs a specific skill type
	 *
	 * @param name - name of the skill type that needs to be retrieved
	 * @return skill type along with HTTP status code 200 (OK) if found, HTTP status<br>
	 *         code 404 (NOT FOUND) otherwise
	 */
	@ApiOperation(value = "Gets a skill type by its name", response = SkillType.class)
	@GetMapping(value = "/name/{name}", produces = MediaType.APPLICATION_JSON_VALUE)
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
	 * new one
	 *
	 * @param skillType - existing skill type will be updated with this one
	 * @param name - name of the skill type to update
	 * @return HTTP status code 202 (ACCEPTED) if success, HTTP status code 400<br>
	 * (BAD_REQUEST) otherwise
	 */
	@ApiOperation(value = "Updates a skill type whose name matches the path variable", response = SkillType.class)
	@PutMapping(value = "/name/{name}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
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
	 * new one
	 *
	 * @param skillTy - existing skill type will be updated with this one
	 * @param id - id of the skill type to update
	 * @return HTTP status code 202 (ACCEPTED) if success, HTTP status code 400<br>
	 * (BAD_REQUEST) otherwise
	 */
	@ApiOperation(value = "Updates a skill type whose id matches the path variable", response = SkillType.class)
	@PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<SkillType> update(@Valid @RequestBody SkillType skillType, @PathVariable int id) {

		if (id == skillType.getSkillTypeId()) {
			return new ResponseEntity<>(this.skillTypeService.update(skillType), HttpStatus.ACCEPTED);
		} else {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}

	/**
	 * Gets a list contained all active skill types
	 * 
	 * @return a list containing all active skill types along with HTTP status code 202 (OK); otherwise,<br>
	 * 204 (NO_CONTENT)
	 */
	@ApiOperation(value = "Gets a list containing all active skill types", response = SkillType.class, responseContainer = "List")
	@GetMapping(value = "/active", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<SkillType>> findAllActive() {
		List<SkillType> skillTypes = this.skillTypeService.findAllActive();

		if (skillTypes.isEmpty())
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);

		return new ResponseEntity<>(skillTypes, HttpStatus.OK);
	}

	/**
	 * Handles incoming PUT request that will add a skill to the list of skills in a skill type.<br>
	 * The skill must already exist for this method to not return a 404 response
	 * 
	 * @param skillTypeId - id of the skill type to add to
	 * @param skillId - id of the skill to add
	 * @return HTTP status code 202 if success, HTTP status code 404 if either the skill type, or<br>
	 * skill does not exist
	 */
	@ApiOperation(value = "Updates skill type skill's list by adding a skill", response = SkillType.class)
	@PutMapping(value = "/{skillTypeId}/skill/{skillId}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<SkillType> updateSkills(@PathVariable int skillTypeId, @PathVariable int skillId) {
		SkillType skillType = this.skillTypeService.addSkill(skillTypeId, skillId);

		if (skillType == null)
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);

		return new ResponseEntity<>(skillType, HttpStatus.ACCEPTED);
	}

	/**
	 * Handles incoming PUT request that will add a skill to the list of skills in a skill type
	 * The skill must already exist for this method to not return a 404 response
	 * 
	 * @param skillTypeName - name of the skill type to add to
	 * @param skillName - name of the skill to add
	 * @return HTTP status code 202 if success, HTTP status code 404 if either the skill type,<br>
	 * or skill does not exist
	 */
	@ApiOperation(value = "Updates skill type skill's list by adding a skill", response = SkillType.class)
	@PutMapping(value = "/name/{skillTypeName}/skill/name/{skillName}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<SkillType> updateSkills(@PathVariable String skillTypeName, @PathVariable String skillName) {
		SkillType skillType = this.skillTypeService.addSkill(skillTypeName, skillName);

		if (skillType == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(skillType, HttpStatus.ACCEPTED);
	}
	
	/**
	 * @author Josh Dughi | 1803-USF-MAR26 | Wezley Singleton
	 * @author Brandon Semba | 1803-USF-MAR26 | Wezley Singleton
	 * 
	 * Creates a skill type bucket lookup list
	 * 
	 * @param on - the JSON to object mapping
	 * @return a list containing skill type bucket lookups along with an HTTP status code 201 (CREATED);<br>
	 * otherwise, 400 (BAD_REQUEST)
	 */
	@ApiOperation(value = "Creates a skill type bucket lookup list", response = SkillTypeBucketLookup.class, responseContainer = "List")
	@PostMapping(value = "/setSkillTypeBucket", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<SkillTypeBucketLookup>> setSkillTypeBucket(@RequestBody ObjectNode on) {
		ObjectMapper mapper = new ObjectMapper();
		try {
			String skillTypeStr = mapper.writeValueAsString(on.get("skillType"));
			SkillType skillType = mapper.readValue(skillTypeStr, SkillType.class);
			String bucketsStr = mapper.writeValueAsString(on.get("skillType"));
			int[] bucketIds = mapper.readValue(bucketsStr, int[].class);
			String weightsStr = mapper.writeValueAsString(on.get("weights"));
			double[] weights = mapper.readValue(weightsStr, double[].class);
			if (bucketIds.length != weights.length) {
				return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
			}
			List<SkillTypeBucketLookup> skillTypeBucketLookup = skillTypeBucketLookupService.addSkillTypeBucketLookups(skillType, bucketIds, weights);
			return new ResponseEntity<>(skillTypeBucketLookup, HttpStatus.CREATED);
		}
		catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}
	
	/**
	 * @author Josh Dughi | 1803-USF-MAR26 | Wezley Singleton
	 * @author Brandon Semba | 1803-USF-MAR26 | Wezley Singleton
	 * 
	 * Updates skill type bucket lookups by first deleting pre-existing ones that match the provided skill type,<br>
	 * Then creating a new skill type bucket lookup list that contains the updated skill type bucket lookups
	 * 
	 * @param on - the JSON to object mapping
	 * @return a list containing updated skill type bucket lookups along with an HTTP status code 201 (CREATED);<br>
	 * otherwise, 400 (BAD_REQUEST)
	 */
	@ApiOperation(value = "Creates a skill type bucket lookup list", response = SkillTypeBucketLookup.class, responseContainer = "List")
	@PutMapping(value = "/updateSkillTypeBucket", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<SkillTypeBucketLookup>> updateSkillTypeBucket(@RequestBody ObjectNode on) {
		ObjectMapper mapper = new ObjectMapper();
		try {
			String skillTypeStr = mapper.writeValueAsString(on.get("skillType"));
			SkillType skillType = mapper.readValue(skillTypeStr, SkillType.class);
			String bucketsStr = mapper.writeValueAsString(on.get("skillType"));
			int[] bucketIds = mapper.readValue(bucketsStr, int[].class);
			String weightsStr = mapper.writeValueAsString(on.get("weights"));
			double[] weights = mapper.readValue(weightsStr, double[].class);
			if (bucketIds.length != weights.length) {
				return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
			}
			List<SkillTypeBucketLookup> skillTypeBucketLookup = skillTypeBucketLookupService.updateSkillTypeBucketLookups(skillType, bucketIds, weights);		
			return new ResponseEntity<>(skillTypeBucketLookup, HttpStatus.CREATED);
		}
		catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}
	
	/**
	 * @author Josh Dughi | 1803-USF-MAR26 | Wezley Singleton
	 * @author Brandon Semba | 1803-USF-MAR26 | Wezley Singleton
	 * 
	 * Gets a list of bucket DTO's (skill type buckets)
	 * 
	 * @param skillTypeId - skill type's id
	 * @return a list of bucket DTOs along with an HTTP status code 202 (OK)
	 */
	@ApiOperation(value = "Gets a list containing bucket DTOs (skill type buckets)", response = BucketDTO.class, responseContainer = "List")
	@GetMapping(value = "/getSkillTypeBuckets/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<BucketDTO>> getSkillTypeBuckets(@PathVariable("id") Integer skillTypeId) {
		SkillType skillType = skillTypeService.findBySkillTypeId(skillTypeId);
		List<SkillTypeBucketLookup> skillTypeBucketLookups = skillTypeBucketLookupService.getSkillTypeBucketLookupsBySkillType(skillType);
		List<BucketDTO> buckets = new ArrayList<>();
		for (SkillTypeBucketLookup s : skillTypeBucketLookups) {
			buckets.add(s.getSkillTypeBucketId().getBucket());
		}
		return new ResponseEntity<>(buckets, HttpStatus.OK);
	}
	
	/**
	 * @author Josh Dughi | 1803-USF-MAR26 | Wezley Singleton
	 * @author Brandon Semba | 1803-USF-MAR26 | Wezley Singleton
	 * 
	 * Gets a list containing skill type bucket lookups that pertain to a specific skill type.
	 * 
	 * @param skillTypeId = skill type id
	 * @return a skill type bucket lookup list along with an HTTP status code 202 (OK)
	 */
	@ApiOperation(value = "Gets a list of skill type bucket lookups pertaining to a specific SkillType", response = SkillTypeBucketLookup.class, responseContainer = "List")
	@GetMapping(value = "/getSkillType/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<SkillTypeBucketLookup>> getSkillTypeBucketWithWeights(@PathVariable("id") Integer skillTypeId) {
		SkillType skillType = skillTypeService.findBySkillTypeId(skillTypeId);
		List<SkillTypeBucketLookup> skillTypeBucketLookups = skillTypeBucketLookupService.getSkillTypeBucketLookupsBySkillType(skillType);
		return new ResponseEntity<>(skillTypeBucketLookups, HttpStatus.OK);
	}
	
}
