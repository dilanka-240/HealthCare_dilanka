package app.thivanka.healthcare.dto;


public class UpdateInvestigationDTO {
	private Long no;
	private Long inv_id;
	private String inv_details;
	
	
	//setters
	
	public void setNo(Long no) {
		this.no = no;
	}
	
	public void setInv_id(Long inv_id) {
		this.inv_id = inv_id;
	}
	
	public void setInv_details(String inv_details) {
		this.inv_details = inv_details;
	}
	
	public Long getNo() {
		return no;
	}
	
	public Long getInv_id() {
		return inv_id;
	}
	
	public String getInv_details() {
		return inv_details;
	}
}