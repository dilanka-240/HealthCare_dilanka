package app.thivanka.healthcare.services;

import org.springframework.stereotype.Service;

import app.thivanka.healthcare.dto.PatientDTO;
import app.thivanka.healthcare.dto.PatientInformationDTO;

@Service
public interface ShowPatientInfo {
	PatientInformationDTO showInformation(Long no);
}