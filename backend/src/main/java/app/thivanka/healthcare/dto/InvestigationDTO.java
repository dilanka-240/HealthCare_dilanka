package app.thivanka.healthcare.dto;

import java.time.LocalDate;

public class InvestigationDTO{
	private Long inv_id;
	
	private Long no;
	private String inv_details;
	private LocalDate inv_date;
	private String results;
	
	//setters
	
	public void setInv_id(Long inv_id) {
		this.inv_id = inv_id;
	}
	
	public void setNo(Long no) {
		this.no = no;
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
	
	public Long getNo() {
		return no;
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