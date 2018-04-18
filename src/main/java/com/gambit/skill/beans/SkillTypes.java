package com.gambit.skill.beans;

import org.springframework.beans.factory.annotation.Autowired;

import com.gambit.skill.beans.Skill;



public class SkillTypes {
	private int skillType;
	private String skillTypeName;
	private String skillTypeDesc;
	private boolean isActive;
	private boolean isCore;
	@Autowired
	private Skill skill;
	public SkillTypes(int skillType, String skillTypeName, String skillTypeDesc, boolean isActive, boolean isCore,
			com.gambit.skill.beans.Skill skill) {
		super();
		this.skillType = skillType;
		this.skillTypeName = skillTypeName;
		this.skillTypeDesc = skillTypeDesc;
		this.isActive = isActive;
		this.isCore = isCore;
		this.skill = skill;
	}
	public int getSkillType() {
		return skillType;
	}
	public void setSkillType(int skillType) {
		this.skillType = skillType;
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
	public boolean isActive() {
		return isActive;
	}
	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}
	public boolean isCore() {
		return isCore;
	}
	public void setCore(boolean isCore) {
		this.isCore = isCore;
	}
	public Skill getSkill() {
		return skill;
	}
	public void setSkill(Skill skill) {
		this.skill = skill;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (isActive ? 1231 : 1237);
		result = prime * result + (isCore ? 1231 : 1237);
		result = prime * result + ((skill == null) ? 0 : skill.hashCode());
		result = prime * result + skillType;
		result = prime * result + ((skillTypeDesc == null) ? 0 : skillTypeDesc.hashCode());
		result = prime * result + ((skillTypeName == null) ? 0 : skillTypeName.hashCode());
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
		SkillTypes other = (SkillTypes) obj;
		if (isActive != other.isActive)
			return false;
		if (isCore != other.isCore)
			return false;
		if (skill == null) {
			if (other.skill != null)
				return false;
		} else if (!skill.equals(other.skill))
			return false;
		if (skillType != other.skillType)
			return false;
		if (skillTypeDesc == null) {
			if (other.skillTypeDesc != null)
				return false;
		} else if (!skillTypeDesc.equals(other.skillTypeDesc))
			return false;
		if (skillTypeName == null) {
			if (other.skillTypeName != null)
				return false;
		} else if (!skillTypeName.equals(other.skillTypeName))
			return false;
		return true;
	}

}
