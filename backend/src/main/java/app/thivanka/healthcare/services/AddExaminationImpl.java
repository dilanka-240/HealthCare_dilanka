package app.thivanka.healthcare.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import app.thivanka.healthcare.dto.ExaminationDTO;
import app.thivanka.healthcare.mappers.ExaminationMapper;
import app.thivanka.healthcare.models.Examination;
import app.thivanka.healthcare.models.Patient;
import app.thivanka.healthcare.repositories.ExaminationRepository;
import app.thivanka.healthcare.repositories.PatientRepository;

@Service
public class AddExaminationImpl implements AddExamination{
	
	
	@Autowired
	ExaminationRepository examinationRepository;
	
	@Autowired
	PatientRepository patientRepository;
	
	
	@Override
	@Transactional
	public ExaminationDTO addExamination(ExaminationDTO examinationDto) {
		Long no = examinationDto.getNo(); 
		Patient patient = patientRepository.findByNo(no)
				.orElseThrow(() -> new IllegalArgumentException("Patient does not exist"));

		Examination examination = ExaminationMapper.toEntity(examinationDto);
		examination.setPatient(patient);

		examinationRepository.save(examination);
		return ExaminationMapper.toDto(examination);
	}
}