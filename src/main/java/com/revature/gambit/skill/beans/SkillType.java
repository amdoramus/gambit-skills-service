package com.revature.gambit.skill.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.domain.EntityScan;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="SKILLTYPE")
public class SkillType {

	@Id
	@Column(name="SKILLTYPE_ID")
	@SequenceGenerator(name="SKILLTYPE_ID_SEQ",sequenceName="SKILLTYPE_ID_SEQ")
	@GeneratedValue(generator = "SKILLTYPE_ID_SEQ")
	private Integer skillTypeId;

	@Column(name = "SKILLTYPE_NAME")
	private String skillTypeName;

	@Column(name = "SKILLTYPE_DESC")
	private String skillTypeDesc;

	@Column(name = "IS_ACTIVE")
	private boolean isActive;

	@Column(name = "IS_CORE")
	private boolean isCore;

	@ManyToMany(cascade = CascadeType.PERSIST, fetch=FetchType.LAZY)
	@JoinTable(name = "SKILL_SKILLTYPE",
			joinColumns = {@JoinColumn(name = "SKILLTYPE_ID")},
			inverseJoinColumns = {@JoinColumn(name = "SKILL_ID")})
	private List<Skill> skills;

	public SkillType() { }

	public SkillType(String skillTypeName, String skillTypeDesc, boolean isActive, boolean isCore) {
		this.skillTypeName = skillTypeName;
		this.skillTypeDesc = skillTypeDesc;
		this.isActive = isActive;
		this.isCore = isCore;
	}

	public SkillType(Integer skillTypeID, String skillTypeName, String skillTypeDesc, boolean isActive, boolean isCore) {
		this.skillTypeId = skillTypeID;
		this.skillTypeName = skillTypeName;
		this.skillTypeDesc = skillTypeDesc;
		this.isActive = isActive;
		this.isCore = isCore;
	}

	public Integer getSkillTypeId() { return skillTypeId; }
	public void setSkillTypeId(Integer skillId) {
		this.skillTypeId = skillId;
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
	public void setIsCore(boolean isCore) { this.isCore = isCore; }
	public List<Skill> getSkills() { return skills; }
	public void setSkills(List<Skill> skills) { this.skills = skills; }

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		SkillType skillType = (SkillType) o;

		if (isActive != skillType.isActive) return false;
		if (isCore != skillType.isCore) return false;
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
