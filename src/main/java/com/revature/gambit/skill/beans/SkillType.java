package com.revature.gambit.skill.beans;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="SKILLTYPE")
public class SkillType {

	@Id
	@Column(name="SKILLTYPE_ID")
	@SequenceGenerator(name="SKILLTYPE_ID_SEQ",sequenceName="SKILLTYPE_ID_SEQ")
	@GeneratedValue(generator = "SKILLTYPE_ID_SEQ")
	private Integer skillTypeID;

	@Column(name = "SKILLTYPE_NAME")
	private String skillTypeName;

	@Column(name = "SKILLTYPE_DESC")
	private String skillTypeDesc;

	@Column(name = "IS_ACTIVE")
	private boolean isActive;

	@Column(name = "IS_CORE")
	private boolean isCore;

	@ManyToMany(cascade = CascadeType.ALL, fetch=FetchType.EAGER)
	@JoinTable(name = "SKILL_SKILLTYPE",
			joinColumns = {@JoinColumn(name = "SKILLTYPE_ID")},
			inverseJoinColumns = {@JoinColumn(name = "SKILL_ID")})
	private List<Skill> skills;

	public SkillType() { }

	public SkillType(Integer skillTypeID, String skillTypeName, String skillTypeDesc, boolean isActive, boolean isCore) {
		this.skillTypeID = skillTypeID;
		this.skillTypeName = skillTypeName;
		this.skillTypeDesc = skillTypeDesc;
		this.isActive = isActive;
		this.isCore = isCore;
	}

	public Integer getSkillTypeId() { return skillTypeID; }
	public void setSkillTypeId(Integer skillId) {
		this.skillTypeID = skillId;
	}
	public String getSkillTypeName() {
		return skillTypeName;
	}
	public void setSkillTypeName(String skillTypeName) {
		this.skillTypeName = skillTypeName;
	}
	public String getSkillTypeDesc() {
		return skillTypeDesc;
	}
	public void setSkillTypeDesc(String skillTypeDesc) {
		this.skillTypeDesc = skillTypeDesc;
	}
	public boolean isIsActive() {
		return isActive;
	}
	public void setIsActive(boolean isActive) {
		this.isActive = isActive;
	}
	public boolean isIs_core() {
		return isCore;
	}
	public void setIsCore(boolean isCore) {
		this.isCore = isCore;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		SkillType skillType = (SkillType) o;

		if (isActive != skillType.isActive) return false;
		if (isCore != skillType.isCore) return false;
		if (skillTypeID != null ? !skillTypeID.equals(skillType.skillTypeID) : skillType.skillTypeID != null)
			return false;
		if (skillTypeName != null ? !skillTypeName.equals(skillType.skillTypeName) : skillType.skillTypeName != null)
			return false;
		return skillTypeDesc != null ? skillTypeDesc.equals(skillType.skillTypeDesc) : skillType.skillTypeDesc == null;
	}

	@Override
	public int hashCode() {
		int result = skillTypeID != null ? skillTypeID.hashCode() : 0;
		result = 31 * result + (skillTypeName != null ? skillTypeName.hashCode() : 0);
		result = 31 * result + (skillTypeDesc != null ? skillTypeDesc.hashCode() : 0);
		result = 31 * result + (isActive ? 1 : 0);
		result = 31 * result + (isCore ? 1 : 0);
		return result;
	}
}
