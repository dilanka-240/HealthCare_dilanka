package app.thivanka.healthcare.models;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "\"Treatment\"")
public class Treatment {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "treat_id")
	private Long treatId;

	@ManyToOne
	@JoinColumn(name = "no")
	private Patient patient;

	@Column(nullable = false)
	private LocalDate treat_date;

	@Column(nullable = false)
	private String treat_details;
	
	//setters
	
	public void setTreatId(Long treatId) {
		this.treatId = treatId;
	}
	
	public void setPatient(Patient patient) {
		this.patient = patient;
	}
	
	public void setTreat_date(LocalDate treat_date) {
		this.treat_date = treat_date;
	}
	
	public void setTreat_details(String treat_details) {
		this.treat_details = treat_details;
	}
	
	//getters
	
	public Long getTreatId() {
		return treatId;
	}
	
	public Patient getPatient() {
		return patient;
	}
	
	public LocalDate getTreat_date() {
		return treat_date;
	}
	
	public String getTreat_details() {
		return treat_details;
	}
}