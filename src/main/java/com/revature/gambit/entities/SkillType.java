package com.revature.gambit.entities;

import javax.persistence.*;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

/**
 * Represents an entire skill type (a.k.a. curriculum) such as Pega, .NET, DBA,<br>
 * SysAdmin, etc
 */
@ApiModel(value = "Skill Type", description = "A specific curriculum")
@Entity
@Table(name = "SKILLTYPE",
		uniqueConstraints = @UniqueConstraint(columnNames= {"SKILLTYPE_NAME"}))
public class SkillType {

	/**
	 * ID that uniquely identifies the skill type
	 */
	@ApiModelProperty(value = "skill type id")
	@Id
	@Column(name = "SKILLTYPE_ID")
	@SequenceGenerator(name = "SKILLTYPE_ID_SEQ", sequenceName = "SKILLTYPE_ID_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator = "SKILLTYPE_ID_SEQ")
	private Integer skillTypeId;

	/**
	 * Name of the skill type
	 */
	@ApiModelProperty(value = "skill type name")
	@Column(name = "SKILLTYPE_NAME")
	private String skillTypeName;

	/**
	 * A description of the skill type
	 */
	@ApiModelProperty(value = "skill type description")
	@Column(name = "SKILLTYPE_DESC")
	private String skillTypeDesc;

	/**
	 * Flag that will be used for soft deletes
	 */
	@ApiModelProperty(value = "skill type active state")
	@Column(name = "IS_ACTIVE")
	private boolean isActive;

	/**
	 * Tells us whether this skill type is a core part of the program or not
	 */
	@ApiModelProperty(value = "whether skill type is part of core")
	@Column(name = "IS_CORE")
	private boolean isCore;

	/**
	 * List of Skills that will be referenced by this skill type. Useful to establish<br>
	 * a many-to-many relationship
	 */
	@ApiModelProperty(value = "list of skills")
	@ManyToMany(cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
	@JoinTable(name = "SKILL_SKILLTYPE", joinColumns = { @JoinColumn(name = "SKILLTYPE_ID") }, inverseJoinColumns = {
			@JoinColumn(name = "SKILL_ID") })
	private List<Skill> skills;

	/**
	 * No-args constructor
	 */
	public SkillType() {
	}

	/**
	 * Constructor that initializes class fields excluding ID, which will be<br>
	 * auto-generated in the DB before insertion
	 * 
	 * @param skillTypeName - name of the skill type
	 * @param skillTypeDesc - description of the skill type
	 * @param isActive - flag that will be used for soft deletes
	 * @param isCore - used to check whether this is identified as a core skill or not
	 */
	public SkillType(String skillTypeName, String skillTypeDesc, boolean isActive, boolean isCore, List<Skill> skills) {
		this.skillTypeName = skillTypeName;
		this.skillTypeDesc = skillTypeDesc;
		this.isActive = isActive;
		this.isCore = isCore;
		this.skills = skills;
	}

	/**
	 * Constructor that initializes class fields, including ID
	 * 
	 * @param skillTypeID - id that uniquely identifies the skill type
	 * @param skillTypeName - name of the skill type
	 * @param skillTypeDesc - description of the skill type
	 * @param isActive - flag that will be used for soft deletes
	 * @param isCore - used to check whether this is identified as a core skill or not
	 */
	public SkillType(Integer skillTypeID, String skillTypeName, String skillTypeDesc, boolean isActive,
			boolean isCore, List<Skill> skills) {
		this.skillTypeId = skillTypeID;
		this.skillTypeName = skillTypeName;
		this.skillTypeDesc = skillTypeDesc;
		this.isActive = isActive;
		this.isCore = isCore;
		this.skills = skills;
	}
	
	/**
	 * Constructs a skill type
	 * 
	 * @param skillType - skill type
	 */
	public SkillType(SkillType skillType) {
		super();
		this.skillTypeId = skillType.getSkillTypeId();
		this.skillTypeName = skillType.getSkillTypeName();
		this.skillTypeDesc = skillType.getSkillTypeDesc();
		this.isActive = skillType.getIsActive();
	}

	/**
	 * Gets a skill type by id
	 * 
	 * @return skill type id
	 */
	public Integer getSkillTypeId() {
		return skillTypeId;
	}

	/**
	 * Sets a skill type id
	 * 
	 * @param skillTypeId - skill type id
	 */
	public void setSkillTypeId(Integer skillTypeId) {
		this.skillTypeId = skillTypeId;
	}

	/**
	 * Gets a skill type name
	 *  
	 * @return skill type name
	 */
	public String getSkillTypeName() {
		return skillTypeName;
	}

	/**
	 * Sets a skill type name
	 * 
	 * @param skillTypeName - a skill type name to set
	 */
	public void setSkillTypeName(String skillTypeName) {
		this.skillTypeName = skillTypeName;
	}

	/**
	 * Gets a skill type description
	 * 
	 * @return skill type description
	 */
	public String getSkillTypeDesc() {
		return skillTypeDesc;
	}

	/**
	 * Sets a skill type description
	 * 
	 * @param skillTypeDesc - skill type description to set
	 */
	public void setSkillTypeDesc(String skillTypeDesc) {
		this.skillTypeDesc = skillTypeDesc;
	}

	/**
	 * Gets a skill type's active state
	 * 
	 * @return skill type's active state
	 */
	public boolean getIsActive() {
		return isActive;
	}

	/**
	 * Sets a skill type's active state
	 * 
	 * @param isActive - whether the skill type is active or not
	 */
	public void setIsActive(boolean isActive) {
		this.isActive = isActive;
	}

	/**
	 * Gets a boolean as to whether skill type belongs to core
	 * 
	 * @return true if skill type is part of core; false otherwise
	 */
	public boolean getIsCore() {
		return isCore;
	}

	/**
	 * Sets whether skill type belongs to core
	 * 
	 * @param isCore - whether skill type is part of core or not
	 */
	public void setIsCore(boolean isCore) {
		this.isCore = isCore;
	}

	/**
	 * Gets a list of skills
	 * 
	 * @return list of skills
	 */
	public List<Skill> getSkills() {
		return skills;
	}

	/**
	 * Sets a list of skills
	 * 
	 * @param skills - list of skills to set
	 */
	public void setSkills(List<Skill> skills) {
		this.skills = skills;
	}
	
	/**
	 * Adds a skill to the skill's list
	 * 
	 * @param skill - skill to add to skill's list
	 */
	public void addSkill(Skill skill) {
		this.skills.add(skill);
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;

		SkillType skillType = (SkillType) o;

		if (isActive != skillType.isActive)
			return false;
		if (isCore != skillType.isCore)
			return false;
		if (skillTypeId != null ? !skillTypeId.equals(skillType.skillTypeId) : skillType.skillTypeId != null)
			return false;
		if (skillTypeName != null ? !skillTypeName.equals(skillType.skillTypeName) : skillType.skillTypeName != null)
			return false;
		return skillTypeDesc != null ? skillTypeDesc.equals(skillType.skillTypeDesc) : skillType.skillTypeDesc == null;
	}

	@Override
	public int hashCode() {
		int result = skillTypeId != null ? skillTypeId.hashCode() : 0;
		result = 31 * result + (skillTypeName != null ? skillTypeName.hashCode() : 0);
		result = 31 * result + (skillTypeDesc != null ? skillTypeDesc.hashCode() : 0);
		result = 31 * result + (isActive ? 1 : 0);
		result = 31 * result + (isCore ? 1 : 0);
		return result;
	}
	
}
