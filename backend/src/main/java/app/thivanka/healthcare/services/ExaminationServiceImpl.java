package app.thivanka.healthcare.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import app.thivanka.healthcare.dto.ExaminationDTO;
import app.thivanka.healthcare.dto.UpdateExaminationDTO;
import app.thivanka.healthcare.mappers.ExaminationMapper;
import app.thivanka.healthcare.mappers.UpdateExaminationMapper;
import app.thivanka.healthcare.models.Examination;
import app.thivanka.healthcare.models.Patient;
import app.thivanka.healthcare.repositories.ExaminationRepository;
import app.thivanka.healthcare.repositories.PatientRepository;

@Service
public class ExaminationServiceImpl implements ExaminationService{
	
	
	@Autowired
	ExaminationRepository examinationRepository;
	
	@Autowired
	PatientRepository patientRepository;
	
	// Add examination 
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
	
	// Update examination
	@Transactional
	public UpdateExaminationDTO updateExamination(UpdateExaminationDTO updateExaminationDto) {
		
		Patient patinet = patientRepository.findByNo(updateExaminationDto.getNo())
				.orElseThrow(() -> new IllegalArgumentException("patient not exists"));
		
		Examination examination = examinationRepository.findByExamId(updateExaminationDto.getExam_id())
				.orElseThrow(() -> new IllegalArgumentException("Examination not exists"));
		
		UpdateExaminationMapper.toEntity(updateExaminationDto, examination);
		examinationRepository.save(examination);
		return UpdateExaminationMapper.toDto(examination);
	}
	
	// Delete examination
	@Override
	@Transactional
	public void deleteExamination(Long examId) {
		
		if(!examinationRepository.existsById(examId)) {
			throw new IllegalArgumentException("Examination not exists");
		}
		
		examinationRepository.deleteById(examId);
	}
}