package com.revature.gambit.skill.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.domain.EntityScan;

import javax.persistence.*;

@Entity
@EntityScan("SkillType")
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

	public SkillType() { }

	public SkillType(String skillTypeName, String skillTypeDesc, boolean isActive, boolean isCore) {
		this.skillTypeName = skillTypeName;
		this.skillTypeDesc = skillTypeDesc;
		this.isActive = isActive;
		this.isCore = isCore;
	}
	public Integer getSkillTypeId() {
		return skillTypeID;
	}
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
}
