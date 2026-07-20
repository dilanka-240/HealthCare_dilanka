package app.thivanka.healthcare.dto;

import java.time.LocalDate;

import app.thivanka.healthcare.models.Patient;

public class TreatmentDTO{
	private Long treat_id;
	Long no;
	private LocalDate treat_date;
	private String treat_details;
	
	//setters
	
	public void setTreat_id(Long treat_id) {
		this.treat_id = treat_id;
	}
	
	public void setNo(Long no) {
		this.no = no;
	}
	
	public void setTreat_date(LocalDate treat_date) {
		this.treat_date = treat_date;
	}
	
	public void setTreat_details(String treat_details) {
		this.treat_details = treat_details;
	}
	
	
	//getters
	
	public Long getTreat_id() {
		return treat_id;
	}
	
	public Long getNo() {
		return no;
	}
	
	public LocalDate getTreat_date() {
		return treat_date;
	}
	
	public String getTreat_details() {
		return treat_details;
	}
}