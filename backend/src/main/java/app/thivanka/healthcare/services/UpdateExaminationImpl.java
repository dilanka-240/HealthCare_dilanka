package app.thivanka.healthcare.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.thivanka.healthcare.dto.UpdateExaminationDTO;
import app.thivanka.healthcare.mappers.UpdateExaminationMapper;
import app.thivanka.healthcare.models.Examination;
import app.thivanka.healthcare.models.Patient;
import app.thivanka.healthcare.repositories.ExaminationRepository;
import app.thivanka.healthcare.repositories.PatientRepository;

@Service
public class UpdateExaminationImpl implements UpdateExamination{
	
	@Autowired
	PatientRepository patientRepository;
	
	@Autowired
	ExaminationRepository examinationRepository;
	
	public UpdateExaminationDTO updateExamination(UpdateExaminationDTO updateExaminationDto) {
		
		Patient patinet = patientRepository.findByNo(updateExaminationDto.getNo())
				.orElseThrow(() -> new IllegalArgumentException("patient not exists"));
		
		Examination examination = examinationRepository.findByExam_id(updateExaminationDto.getExam_id())
				.orElseThrow(() -> new IllegalArgumentException("Examination not exists"));
		
		UpdateExaminationMapper.toEntity(updateExaminationDto, examination);
		examinationRepository.save(examination);
		return UpdateExaminationMapper.toDto(examination);
	}
}