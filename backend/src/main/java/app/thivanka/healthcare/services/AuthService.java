package app.thivanka.healthcare.services;

import app.thivanka.healthcare.dto.LoginDTO;

public interface AuthService{
	LoginDTO login(LoginDTO loginDto);
}
		