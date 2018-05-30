package com.revature.gambit.entities;

import java.util.List;

import javax.persistence.*;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Represents a specific skill such as Java, C#, Bash, Office, etc
 */
@ApiModel(value = "Skill", description = "Represents a specific skill")
@Entity
@Table(name = "SKILL")
public class Skill {

	/**
	 * ID that uniquely identifies a Skill
	 */
	@ApiModelProperty(value = "Skill's unique id")
	@Id
	@Column(name = "SKILL_ID")
	@SequenceGenerator(name = "SKILL_ID_SEQ", sequenceName = "SKILL_ID_SEQ")
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "SKILL_ID_SEQ")
	private int skillID;

	/**
	 * Name of the Skill
	 */
	@ApiModelProperty(value = "name of the the Skill")
	@Column(name = "SKILL_NAME")
	private String skillName;

	/**
	 * Flag that will be used for soft deletes
	 */
	@ApiModelProperty(value = "flag for the state of the Skill (active/inactive)")
	@Column(name = "IS_ACTIVE")
	private boolean isActive;

	/**
	 * List of SkillTypes that will be referenced by this Skill. Useful to establish<br>
	 * a many-to-many relationship
	 */
	@ApiModelProperty(value = "list of SkillTypes")
	@ManyToMany(mappedBy = "skills", cascade = CascadeType.REMOVE, fetch = FetchType.EAGER)
	private List<SkillType> skillTypes;

	/**
	 * No-args constructor
	 */
	public Skill() {
	}
	
	/**
	 * Constructor that initializes class fields
	 * 
	 * @param skillId - id that uniquely identifies a Skill
	 * @param skillName - name of the Skill
	 * @param active - flag that will be used for soft deletes
	 */
	public Skill(int skillId, String skillName, boolean active) {
		this.skillID = skillId;
		this.skillName = skillName;
		this.isActive = active;
	}
	
	/**
	 * Constructs a Skill
	 * 
	 * @param skillName - name of Skill
	 * @param isActive - whether the Skill is active or not
	 */
	public Skill(String skillName, boolean isActive) {
		this.skillID = 0;
		this.skillName = skillName;
		this.isActive = isActive;
	}

	/**
	 * Gets the Skill's id
	 * 
	 * @return the Skill's id
	 */
	public int getSkillID() {
		return skillID;
	}

	/**
	 * Sets a Skill's id
	 * 
	 * @param skillID - Skill id to set
	 */
	public void setSkillID(int skillID) {
		this.skillID = skillID;
	}

	/**
	 * Gets a Skill's name
	 * 
	 * @return the Skill's name
	 */
	public String getSkillName() {
		return skillName;
	}

	/**
	 * Sets the Skill's name
	 * 
	 * @param skillName - the Skill's name to set
	 */
	public void setSkillName(String skillName) {
		this.skillName = skillName;
	}

	/**
	 * Gets a Skill's active state
	 * 
	 * @return true if active; false if inactive
	 */
	public boolean getIsActive() {
		return isActive;
	}

	/**
	 * Sets a Skill's active state
	 * 
	 * @param isActive - whether Skills is active or not
	 */
	public void setIsActive(boolean isActive) {
		this.isActive = isActive;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (isActive ? 1231 : 1237);
		result = prime * result + skillID;
		result = prime * result + ((skillName == null) ? 0 : skillName.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Skill other = (Skill) obj;
		if (isActive != other.isActive)
			return false;
		if (skillID != other.skillID)
			return false;
		if (skillName == null) {
			if (other.skillName != null)
				return false;
		} else if (!skillName.equals(other.skillName))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Skill [skillID=" + skillID + ", skillName=" + skillName + ", isActive=" + isActive + ", skillTypes="
				+ skillTypes + "]";
	}

}
