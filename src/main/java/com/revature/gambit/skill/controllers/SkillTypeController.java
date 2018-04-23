package com.revature.gambit.skill.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.revature.gambit.skill.services.ISkillTypeService;
import com.revature.gambit.skill.services.SkillTypeService;

/**
 * Controller that will handle requests for the skill type service.
 */
@RestController
public class SkillTypeController {

	/**
	 * Service that contains all the business logic (methods) to be executed for
	 * this controller based on the request type.
	 */
	@Autowired
	private SkillTypeService skillTypeService;

	/**
	 * Interface that contains all CRUD methods for skill type.
	 */
	@Autowired
	private ISkillTypeService iskillTypeService;

}
