package app.thivanka.healthcare.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import app.thivanka.healthcare.dto.PatientDTO;
import app.thivanka.healthcare.mappers.PatientMapper;
import app.thivanka.healthcare.models.Patient;
import app.thivanka.healthcare.repositories.PatientRepository;


@Service
public class CreatePatientImpl implements CreatePatient{
	
	private final PatientRepository patientRepository;
	
	public CreatePatientImpl(PatientRepository patientRepository) {
		this.patientRepository = patientRepository;
	}
	
	
	@Transactional
	public PatientDTO createPatient(PatientDTO patientDto) {
		Patient patient = PatientMapper.toCreateEntity(patientDto);
		patientRepository.save(patient);
		return PatientMapper.toCreateInfoDto(patient);

	}
}