package app.thivanka.healthcare.models;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "\"Patient\"")
public class Patient {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long no;

	@Column(nullable = false)
	private String name;
	
	@Column(nullable = false)
	private LocalDate birthday;
	
	@Column(nullable = false)
	private String sex;
	
	@Column(nullable = true)
	private String allergies;
	
	@Column(nullable = true)
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
	
	public String getSex() {
		return sex;
	}
	
	public String getAllergies() {
		return allergies;
	}
	
	public String getOccupation() {
		return occupation;
	}
}