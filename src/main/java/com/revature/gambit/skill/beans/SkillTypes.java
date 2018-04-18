package com.revature.gambit.skill.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.domain.EntityScan;

import javax.persistence.*;

@Entity
@EntityScan("SkillTypes")
@Table(name="SKILLTYPE")
public class SkillTypes {

	@Id
	@Column(name="SKILLTYPE_ID")
	@SequenceGenerator(name="SKILLTYPE_ID_SEQ",sequenceName="SKILLTYPE_ID_SEQ")
	@GeneratedValue(generator = "SKILLTYPE_ID_SEQ")
	private Integer skillId;

	@Column(name = "SKILLTYPE_NAME")
	private String skillTypeName;

	@Column(name = "SKILLTYPE_DESC")
	private String skillTypeDesc;

	@Column(name = "IS_ACTIVE")
	private boolean is_active;

	@Column(name = "IS_CORE")
	private boolean is_core;



	public SkillTypes(){

	}

	public SkillTypes(String skillTypeName, String skillTypeDesc, boolean is_active, boolean is_core) {
		this.skillTypeName = skillTypeName;
		this.skillTypeDesc = skillTypeDesc;
		this.is_active = is_active;
		this.is_core = is_core;
	}

	public Integer getSkillId() {
		return skillId;
	}

	public void setSkillId(Integer skillId) {
		this.skillId = skillId;
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

	public boolean isIs_active() {
		return is_active;
	}

	public void setIs_active(boolean is_active) {
		this.is_active = is_active;
	}

	public boolean isIs_core() {
		return is_core;
	}

	public void setIs_core(boolean is_core) {
		this.is_core = is_core;
	}
}
