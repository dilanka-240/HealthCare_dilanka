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
	private String name;
	private long no;
	private String password;
	
	
	//setters
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setNo(Long no) {
		this.no = no;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}

	//getters
	
	public Long getId() {
		return id;
	}
	
	public String getName() {
		return name;
	}
	
	public Long getNo() {
		return no;
	}
	
	public String getPassword() {
		return password;
	}
}