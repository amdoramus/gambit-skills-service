package com.revature.gambit.entities;

import javax.persistence.*;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

/**
 * Represents an entire SkillType (a.k.a. curriculum) such as Pega, .NET, DBA,<br>
 * SysAdmin, etc
 */
@ApiModel(value = "Skill Type", description = "A specific curriculum")
@Entity
@Table(name = "SKILLTYPE",
		uniqueConstraints = @UniqueConstraint(columnNames= {"SKILLTYPE_NAME"}))
public class SkillType {

	/**
	 * ID that uniquely identifies the SkillType
	 */
	@ApiModelProperty(value = "SkillType id")
	@Id
	@Column(name = "SKILLTYPE_ID")
	@SequenceGenerator(name = "SKILLTYPE_ID_SEQ", sequenceName = "SKILLTYPE_ID_SEQ")
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "SKILLTYPE_ID_SEQ")
	private Integer skillTypeId;

	/**
	 * Name of the SkillType
	 */
	@ApiModelProperty(value = "SkillType name")
	@Column(name = "SKILLTYPE_NAME")
	private String skillTypeName;

	/**
	 * A description of the SkillType
	 */
	@ApiModelProperty(value = "SkillType description")
	@Column(name = "SKILLTYPE_DESC")
	private String skillTypeDesc;

	/**
	 * Flag that will be used for soft deletes
	 */
	@ApiModelProperty(value = "SkillType active state")
	@Column(name = "IS_ACTIVE")
	private boolean isActive;

	/**
	 * Tells us whether this SkillType is a core part of the program or not
	 */
	@ApiModelProperty(value = "whether SkillType is part of core")
	@Column(name = "IS_CORE")
	private boolean isCore;

	/**
	 * List of Skills that will be referenced by this SkillType<br>
	 * Useful to establish a many-to-many relationship
	 */
	@ApiModelProperty(value = "list of Skills")
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
	 * @param skillTypeName - name of the SkillType
	 * @param skillTypeDesc - description of the SkillType
	 * @param isActive - flag that will be used for soft deletes
	 * @param isCore - used to check whether this is identified as a core Skill or not
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
	 * @param skillTypeID - id that uniquely identifies the SkillType
	 * @param skillTypeName - name of the SkillType
	 * @param skillTypeDesc - description of the SkillType
	 * @param isActive - flag that will be used for soft deletes
	 * @param isCore - used to check whether this is identified as a core Skill or not
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
	 * Constructs a SkillType
	 * 
	 * @param skillType - a SkillType
	 */
	public SkillType(SkillType skillType) {
		super();
		this.skillTypeId = skillType.getSkillTypeId();
		this.skillTypeName = skillType.getSkillTypeName();
		this.skillTypeDesc = skillType.getSkillTypeDesc();
		this.isActive = skillType.getIsActive();
	}

	/**
	 * Gets a SkillType by id
	 * 
	 * @return a SkillType id
	 */
	public Integer getSkillTypeId() {
		return skillTypeId;
	}

	/**
	 * Sets a SkillType id
	 * 
	 * @param skillTypeId - SkillType id
	 */
	public void setSkillTypeId(Integer skillTypeId) {
		this.skillTypeId = skillTypeId;
	}

	/**
	 * Gets a SkillType name
	 *  
	 * @return SkillType name
	 */
	public String getSkillTypeName() {
		return skillTypeName;
	}

	/**
	 * Sets a SkillType name
	 * 
	 * @param skillTypeName - a SkillType name to set
	 */
	public void setSkillTypeName(String skillTypeName) {
		this.skillTypeName = skillTypeName;
	}

	/**
	 * Gets a SkillType description
	 * 
	 * @return SkillType description
	 */
	public String getSkillTypeDesc() {
		return skillTypeDesc;
	}

	/**
	 * Sets a SkillType description
	 * 
	 * @param skillTypeDesc - SkillType description to set
	 */
	public void setSkillTypeDesc(String skillTypeDesc) {
		this.skillTypeDesc = skillTypeDesc;
	}

	/**
	 * Gets a SkillType's active state
	 * 
	 * @return SkillTypes's active state
	 */
	public boolean getIsActive() {
		return isActive;
	}

	/**
	 * Sets a SkillTypes's active state
	 * 
	 * @param isActive - whether the SkillType is active or not
	 */
	public void setIsActive(boolean isActive) {
		this.isActive = isActive;
	}

	/**
	 * Gets a boolean as to whether SkillType belongs to core
	 * 
	 * @return true if SkillType is part of core; false otherwise
	 */
	public boolean getIsCore() {
		return isCore;
	}

	/**
	 * Sets whether SkillType belongs to core
	 * 
	 * @param isCore - whether SkillType is part of core or not
	 */
	public void setIsCore(boolean isCore) {
		this.isCore = isCore;
	}

	/**
	 * Gets a list of Skills
	 * 
	 * @return list of Skills
	 */
	public List<Skill> getSkills() {
		return skills;
	}

	/**
	 * Sets a list of Skills
	 * 
	 * @param skills - list of Skills to set
	 */
	public void setSkills(List<Skill> skills) {
		this.skills = skills;
	}
	
	/**
	 * Adds a skill to the Skill's list
	 * 
	 * @param skill - skill to add to Skill's list
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
