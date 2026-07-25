package app.thivanka.healthcare.dto;


public class UpdateExaminationDTO {
	
	private Long exam_id;
	private Long no;
	private int bp;
	private int hp;
	private float wi;
	private float temp;
	
	//setters
	
	public void setExam_id(Long exam_id) {
		this.exam_id = exam_id;
	}
	
	public void setNo(Long no) {
		this.no = no;
	}
	
	public void setBp(int bp) {
		this.bp = bp;
	}
	
	public void setHp(int hp) {
		this.hp = hp;
	}
	
	public void setWi(float wi) {
		this.wi = wi;
	}
	
	public void setTemp(float temp) {
		this.temp = temp;
	}
	
	
	//getters
	
	public Long getExam_id() {
		return exam_id;
	}
	
	public Long getNo() {
		return no;
	}
	
	public int getBp() {
		return bp;
	}
	
	public int getHp() {
		return hp;
	}
	
	public float getWi() {
		return wi;
	}
	
	public float getTemp() {
		return temp;
	}
}