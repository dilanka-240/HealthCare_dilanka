package app.thivanka.healthcare.services;

import app.thivanka.healthcare.dto.PatientDTO;

public interface PatientService{
	PatientDTO createPatient(PatientDTO patientDto);
	void deletePatient(Long no);
}
