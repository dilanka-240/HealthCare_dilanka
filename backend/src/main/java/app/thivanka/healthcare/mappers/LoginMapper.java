package app.thivanka.healthcare.mappers;

import app.thivanka.healthcare.dto.LoginDTO;
import app.thivanka.healthcare.models.Doctor;

public class LoginMapper{
	
	public static LoginDTO toDto(Doctor doctor) {
		LoginDTO loginDto = new LoginDTO();
		loginDto.setId(doctor.getId());
		loginDto.setName(doctor.getName());
		loginDto.setPassword(doctor.getPassword());
		return loginDto;
	}
	
	public static Doctor toEntity(LoginDTO loginDto) {
		Doctor doctor = new Doctor();
		doctor.setId(loginDto.getId());
		doctor.setName(loginDto.getName());
		doctor.setPassword(loginDto.getPassword());
		return doctor;
	}
}