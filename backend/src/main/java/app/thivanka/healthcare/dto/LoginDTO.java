package app.thivanka.healthcare.dto;


public class LoginDTO{
	
	private Long id;
	private String name;
	private String password;
	
	//setters
	public void setId(Long id) {
		this.id = id;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	//getters
	
	public String getName() {
		return name;
	}
	
	public Long getId() {
		return id;
	}
	
	public String getPassword() {
		return password;
	}
	
}