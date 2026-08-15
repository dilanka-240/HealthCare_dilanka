package app.thivanka.healthcare.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.thivanka.healthcare.dto.LoginDTO;
import app.thivanka.healthcare.models.Doctor;
import app.thivanka.healthcare.repositories.DoctorRepository;
import app.thivanka.healthcare.security.JwtUtil;

@Service
public class AuthServiceImpl implements AuthService {

  @Autowired
  DoctorRepository doctorRepository;

  public LoginDTO login(LoginDTO loginDto) {

    Doctor doctor = doctorRepository.findById(loginDto.getId())
        .orElseThrow(() -> new IllegalArgumentException("Account not exists"));

    if (loginDto.getPassword().equals(doctor.getPassword())) {
      String accessToken = JwtUtil.generateAccessToken(doctor.getName());
      String refreshToken = JwtUtil.generateRefreshToken(doctor.getName());
      loginDto.setAccessToken(accessToken);
      loginDto.setRefreshToken(refreshToken);

      return loginDto;
    } else {
      throw new IllegalArgumentException("Password invalid");
    }

  }
}
