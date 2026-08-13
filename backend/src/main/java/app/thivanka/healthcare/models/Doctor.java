package app.thivanka.healthcare.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Doctor")
public class Doctor{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String d_name;
	private long no;
	
	
	//setters
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public void setDoctorName(String d_name) {
		this.d_name = d_name;
	}
	
	public void setNo(Long no) {
		this.no = no;
	}

	//getters
	
	public Long getId() {
		return id;
	}
	
	public String getDoctorName() {
		return d_name;
	}
	
	public Long getNo() {
		return no;
	}
}