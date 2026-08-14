package app.thivanka.healthcare.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import app.thivanka.healthcare.dto.LoginDTO;
import app.thivanka.healthcare.repositories.DoctorRepository;
import app.thivanka.healthcare.services.AuthService;

@RestController
@RequestMapping("/doctor")
public class DoctorController{
	
	@Autowired
	AuthService authService;

	public DoctorController(
			AuthService authService
			) {
		this.authService = authService;
	}
	
	@GetMapping("/login")
	public ResponseEntity<LoginDTO> login(@RequestBody LoginDTO loginDto){
		return ResponseEntity.ok(authService.login(loginDto));
	}
}