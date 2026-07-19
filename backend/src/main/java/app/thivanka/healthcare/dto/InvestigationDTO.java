package app.thivanka.healthcare.dto;

import java.time.LocalDate;

public class InvestigationDTO{
	private Long inv_id;
	
	private Long no;
	private String inv_details;
	private LocalDate inv_date;
	private String results;
	
	//setters
	
	public void setInvId(Long inv_id) {
		this.inv_id = inv_id;
	}
	
	public void setNo(Long no) {
		this.no = no;
	}
	
	public void setInvDetails(String inv_details) {
		this.inv_details = inv_details;
	}
	
	public void setInvDate(LocalDate inv_date) {
		this.inv_date = inv_date;
	}
	
	public void setResults(String results) {
		this.results = results;
	}
	
	//getters
	
	public Long getInvId() {
		return inv_id;
	}
	
	public Long getNo() {
		return no;
	}
	
	public String getInvDetails() {
		return inv_details;
	}
	
	public LocalDate getInvDate() {
		return inv_date;
	}
	
	public String getResults() {
		return results;
	}
	

}