package app.thivanka.healthcare.dto;


public class UpdateTreatmentDTO {
	private Long treatId;
	private Long no;
	private String treat_details;
	
	//setters 
	
	public void setTreatId(Long treatId) {
		this.treatId = treatId;
	}
	
	public void setNo(Long no) {
		this.no = no;
	}
	
	public void setTreat_details(String treat_details) {
		this.treat_details = treat_details;
	}
	
	//getters
	
	public Long getTreatId() {
		return treatId;
	}
	
	public Long getNo() {
		return no;
	}
	
	public String getTreat_details() {
		return treat_details;
	}
}