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
@Table(name = "\"Investigation\"")
public class Investigation{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long inv_id;
	
	@ManyToOne
	@JoinColumn(name = "no")
	private Patient patient;
	
	@Column(nullable = false)
	private String inv_details;
	
	@Column(nullable = false)
	private LocalDate inv_date;

	@Column(nullable = false)
	private String results;
	
	//setters
	
	public void setInv_id(Long inv_id) {
		this.inv_id = inv_id;
	}
	
	public void setPatient(Patient patient) {
		this.patient = patient;
	}
	
	public void setInv_details(String inv_details) {
		this.inv_details = inv_details;
	}
	
	public void setInv_date(LocalDate inv_date) {
		this.inv_date = inv_date;
	}
	
	public void setResults(String results) {
		this.results = results;
	}
	
	//getters
	
	public Long getInv_id() {
		return inv_id;
	}
	
	public Patient getPatient() {
		return patient;
	}
	
	public String getInv_details() {
		return inv_details;
	}
	
	public LocalDate getInv_date() {
		return inv_date;
	}
	
	public String getResults() {
		return results;
	}
	
}