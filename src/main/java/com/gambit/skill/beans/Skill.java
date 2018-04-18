package com.gambit.skill.beans;



public class Skill {
	private int skill_id;
	private String skill_name;
	private boolean active;
	public Skill(int skill_id, String skill_name, boolean active) {
		super();
		this.skill_id = skill_id;
		this.skill_name = skill_name;
		this.active = active;
	}
	public int getSkill_id() {
		return skill_id;
	}
	public void setSkill_id(int skill_id) {
		this.skill_id = skill_id;
	}
	public String getSkill_name() {
		return skill_name;
	}
	public void setSkill_name(String skill_name) {
		this.skill_name = skill_name;
	}
	public boolean isActive() {
		return active;
	}
	public void setActive(boolean active) {
		this.active = active;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (active ? 1231 : 1237);
		result = prime * result + skill_id;
		result = prime * result + ((skill_name == null) ? 0 : skill_name.hashCode());
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
		if (active != other.active)
			return false;
		if (skill_id != other.skill_id)
			return false;
		if (skill_name == null) {
			if (other.skill_name != null)
				return false;
		} else if (!skill_name.equals(other.skill_name))
			return false;
		return true;
	}
	
	

}
