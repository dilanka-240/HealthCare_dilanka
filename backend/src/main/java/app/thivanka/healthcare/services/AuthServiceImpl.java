package app.thivanka.healthcare.services;

import org.springframework.beans.factory.annotation.Autowired;

import app.thivanka.healthcare.dto.LoginDTO;
import app.thivanka.healthcare.models.Doctor;
import app.thivanka.healthcare.repositories.DoctorRepository;

public class AuthServiceImpl implements AuthService{
	
	@Autowired
	DoctorRepository doctorRepository;
	
	public LoginDTO login(LoginDTO loginDto){
		
		Doctor doctor = doctorRepository.findById(loginDto.getId())
				.orElseThrow(() -> new IllegalArgumentException("Account not exists"));
		
		if(loginDto.getPassword() == doctor.getPassword()) {
			return loginDto;
		}else {
			throw new Exception("Password is incorrect");
		}
	}
}


