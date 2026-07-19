package app.thivanka.healthcare.dto;

import java.time.LocalDate;

public class PatientDTO{
	private Long no;
	private String name;
	private LocalDate birthday;
	private String sex;
	private String allergies;
	private String occupation;

	
	//setters
	
	public void setNo(Long no) {
		this.no = no;
	}
	
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
	
	
	//getters
	
	public Long getNo() {
		return no;
	}
	
	public String getName() {
		return name;
	}
	
	public LocalDate getBirthday() {
		return birthday;
	}
	
	public String getAllergies() {
		return allergies;
	}
	
	public String getSex() {
		return sex;
	}
	
	public String getOccupation() {
		return occupation;
	}
	
}