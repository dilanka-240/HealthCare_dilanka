package app.thivanka.healthcare.dto;

import java.time.LocalDate;

public class PatientInformationDTO {
	
	private String name;
	private LocalDate birthday;
	private String sex;
	private String allergies;
	private String occupation;
	private int bp;
	private int hp;
	private float wi;
	private float temp;
	private String treatment; 
	
	
	//setters
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setBirthday(LocalDate birthday) {
		this.birthday = birthday;
	}
	
	public void setSex(String sex) {
		this.sex = sex;
	}
	
	public void setAllergies(String allergies) {
		this.allergies = allergies;
	}
	
	public void setOccupation(String occupation) {
		this.occupation = occupation;
	}
	
	public void setBp(int bp) {
		this.bp = bp;
	}
	
	public void setHp(int hp) {
		this.hp = hp;
	}
	
	public void setWi(float wi) {
		this.wi = wi;
	}
	
	public void setTemp(float temp) {
		this.temp = temp;
	}
	
	public void setTreatment(String treatment) {
		this.treatment = treatment;
	}

	//getters
	
	public String getName() {
		return name;
	}
	
	public LocalDate getBirthday() {
		return birthday;
	}
	
	public String getSex() {
		return sex;
	}
	
	public String getOccupation() {
		return occupation;
	}
	
	public String getAllergies() {
		return allergies;
	}
	
	public int getBp() {
		return bp;
	}
	
	public int getHp() {
		return hp;
	}
	
	public float getWi() {
		return wi;
	}
	
	public float getTemp() {
		return temp;
	}
	
	public String getTreatment() {
		return treatment;
	}
}
