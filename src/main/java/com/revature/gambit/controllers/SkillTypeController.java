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
 * Controller that will handle requests for the SkillType service
 */
@RestController
@RequestMapping("/skillType")
public class SkillTypeController {
	
	@Autowired
	private SkillTypeService skillTypeService;
	
	@Autowired
	private SkillTypeBucketLookupService skillTypeBucketLookupService;

	/**
	 * Handles incoming POST request that adds a new SkillType to the DB
	 *
	 * @param skillType - a SkillType to add
	 * @return created SkillType along with HTTP status code 201 (CREATED)
	 */
	@ApiOperation(value = "Adds a new SkillType", response = SkillType.class)
	@PostMapping
	public ResponseEntity<SkillType> create(@Valid @RequestBody SkillType skillType) {
		return new ResponseEntity<>(this.skillTypeService.create(skillType), HttpStatus.CREATED);
	}

	/**
	 * Handles DELETE request that soft deletes a SkillType
	 * 
	 * @param id - id of SkillType
	 * @return a SkillType whose state was set to inactive (if already inactive, it will remain inactive)<br>
	 * along with HTTP status code 202 (ACCEPTED)
	 */
	@ApiOperation(value = "Finds a SkillType by id and sets its state to inactive", response = SkillType.class)
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
	 * Handles DELETE request that soft deletes a SkillType
	 * 
	 * @param name - name of SkillType
	 * @return a SkillType whose state was set to inactive (if already inactive, it will remain inactive)<br>
	 * along with HTTP status code 202 (ACCEPTED)
	 */
	@ApiOperation(value = "Finds a SkillType by its name and sets its state to inactive", response = SkillType.class)
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
	 * Handles incoming GET request that grabs all the SkillTypes
	 *
	 * @return list containing all the SkillTypes retrieved along with<br>
	 *         HTTP status code 200 (OK)
	 */
	@ApiOperation(value = "List of all of the SkillTypes", response = SkillType.class, responseContainer = "List")
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
	 * Handles incoming GET request that grabs a specific SkillType
	 *
	 * @param id - id of the SkillType that needs to be retrieved
	 * @return a SkillType along with HTTP status code 200 (OK) if found, HTTP status<br>
	 *         code 404 (NOT FOUND) otherwise
	 */
	@ApiOperation(value = "Gets a SkillType by id", response = SkillType.class)
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
	 * Handles incoming GET request that grabs a specific SkillType
	 *
	 * @param name - name of the SkillType that needs to be retrieved
	 * @return a SkillType along with HTTP status code 200 (OK) if found, HTTP status<br>
	 *         code 404 (NOT FOUND) otherwise
	 */
	@ApiOperation(value = "Gets a SkillType by its name", response = SkillType.class)
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
	 * Handles incoming PUT request that will update an existing SkillType with a
	 * new one
	 *
	 * @param skillType - existing SkillType will be updated with this one
	 * @param name - name of the SkillType to update
	 * @return HTTP status code 202 (ACCEPTED) if success, HTTP status code 400<br>
	 * (BAD_REQUEST) otherwise
	 */
	@ApiOperation(value = "Updates a SkillType whose name matches the path variable", response = SkillType.class)
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
	 * Handles incoming PUT request that will update an existing SkillType with a
	 * new one
	 *
	 * @param skillTy - existing SkillType will be updated with this one
	 * @param id - id of the SkillType to update
	 * @return HTTP status code 202 (ACCEPTED) if success, HTTP status code 400<br>
	 * (BAD_REQUEST) otherwise
	 */
	@ApiOperation(value = "Updates a SkillType whose id matches the path variable", response = SkillType.class)
	@PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<SkillType> update(@Valid @RequestBody SkillType skillType, @PathVariable int id) {

		if (id == skillType.getSkillTypeId()) {
			return new ResponseEntity<>(this.skillTypeService.update(skillType), HttpStatus.ACCEPTED);
		} else {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}

	/**
	 * Gets a list contained all active SkillTypes
	 * 
	 * @return a list containing all active SkillTypes along with HTTP status code 202 (OK); otherwise,<br>
	 * 204 (NO_CONTENT)
	 */
	@ApiOperation(value = "Gets a list containing all active SkillTypes", response = SkillType.class, responseContainer = "List")
	@GetMapping(value = "/active", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<SkillType>> findAllActive() {
		List<SkillType> skillTypes = this.skillTypeService.findAllActive();

		if (skillTypes.isEmpty())
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);

		return new ResponseEntity<>(skillTypes, HttpStatus.OK);
	}

	/**
	 * Handles incoming PUT request that will add a skill to the list of skills in a SkillType<br>
	 * The Skill must already exist for this method to not return a 404 response
	 * 
	 * @param skillTypeId - id of the Skill type to add to
	 * @param skillId - id of the Skill to add
	 * @return HTTP status code 202 if success, HTTP status code 404 if either the SkillType, or<br>
	 * skill does not exist
	 */
	@ApiOperation(value = "Updates SkillType Skill's list by adding a Skill", response = SkillType.class)
	@PutMapping(value = "/{skillTypeId}/skill/{skillId}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<SkillType> updateSkills(@PathVariable int skillTypeId, @PathVariable int skillId) {
		SkillType skillType = this.skillTypeService.addSkill(skillTypeId, skillId);

		if (skillType == null)
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);

		return new ResponseEntity<>(skillType, HttpStatus.ACCEPTED);
	}

	/**
	 * Handles incoming PUT request that will add a Skill to the list of Skills in a SkillType
	 * The Skill must already exist for this method to not return a 404 response
	 * 
	 * @param skillTypeName - name of the SkillType to add to
	 * @param skillName - name of the Skill to add
	 * @return HTTP status code 202 if success, HTTP status code 404 if either the skill type,<br>
	 * or skill does not exist
	 */
	@ApiOperation(value = "Updates SkillType Skill's list by adding a Skill", response = SkillType.class)
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
	 * Creates a SkillTypeBucketLookup list
	 * 
	 * @param on - the JSON to object mapping
	 * @return a list containing SkillTypeBucketLookup lookups along with an HTTP status code 201 (CREATED);<br>
	 * otherwise, 400 (BAD_REQUEST)
	 */
	@ApiOperation(value = "Creates a SkillTypeBucketLookup list", response = SkillTypeBucketLookup.class, responseContainer = "List")
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
	 * Updates SkillTypeBucketLookups by first deleting pre-existing ones that match the provided SkillType,<br>
	 * Then creating a new SkillTypeBucketLookup list that contains the updated SkillTypeBucketLookups
	 * 
	 * @param on - the JSON to object mapping
	 * @return a list containing updated SkillTypeBucketLookups along with an HTTP status code 201 (CREATED);<br>
	 * otherwise, 400 (BAD_REQUEST)
	 */
	@ApiOperation(value = "Creates a SkillTypeBucketLookups list", response = SkillTypeBucketLookup.class, responseContainer = "List")
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
	 * Gets a list of BucketDTO's (skill type buckets)
	 * 
	 * @param skillTypeId - SkillType id
	 * @return a list of BucketDTOs along with an HTTP status code 202 (OK)
	 */
	@ApiOperation(value = "Gets a list containing BucketDTOs (skill type buckets)", response = BucketDTO.class, responseContainer = "List")
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
	 * Gets a list containing SkillTypeBucketLookups that pertain to a specific SkillType.
	 * 
	 * @param skillTypeId = SkillType id
	 * @return a SkillTypeBucketLookups list along with an HTTP status code 202 (OK)
	 */
	@ApiOperation(value = "Gets a list of SkillTypeBucketLookups pertaining to a specific SkillType", response = SkillTypeBucketLookup.class, responseContainer = "List")
	@GetMapping(value = "/getSkillType/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<SkillTypeBucketLookup>> getSkillTypeBucketWithWeights(@PathVariable("id") Integer skillTypeId) {
		SkillType skillType = skillTypeService.findBySkillTypeId(skillTypeId);
		List<SkillTypeBucketLookup> skillTypeBucketLookups = skillTypeBucketLookupService.getSkillTypeBucketLookupsBySkillType(skillType);
		return new ResponseEntity<>(skillTypeBucketLookups, HttpStatus.OK);
	}
	
}
