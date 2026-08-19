package app.thivanka.healthcare.dto;

import app.thivanka.healthcare.models.Examination; 
import app.thivanka.healthcare.models.Treatment;

import java.time.LocalDate;
import java.util.List;

public class PatientInformationDTO {
	
	private String name;
	private LocalDate birthday;
	private String sex;
	private String allergies;
	private String occupation;
  private List<Examination> examination;
  private List<Treatment> treatment;
	
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
	
  public void setExamination(List<Examination> examination){
    this.examination = examination;
  }

  public void setTreatment(List<Treatment> treatment){
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

  public List<Examination> getExamination(){
    return examination;
  }

  public List<Treatment> getTreatment(){
    return treatment;
  }
	
}
