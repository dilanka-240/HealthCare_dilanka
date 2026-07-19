package app.thivanka.healthcare.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import app.thivanka.healthcare.dto.ExaminationDTO;
import app.thivanka.healthcare.mappers.ExaminationMapper;
import app.thivanka.healthcare.models.Examination;
import app.thivanka.healthcare.repositories.ExaminationRepository;

@Service
public class AddExaminationImpl implements AddExamination{
	
	
	@Autowired
	ExaminationRepository examinationRepository;
	
	@Transactional
	public ExaminationDTO addExamination(ExaminationDTO examinationDto) {
		Examination examination = ExaminationMapper.toEntity(examinationDto);
		examinationRepository.save(examination);
		return ExaminationMapper.toDto(examination);
	}
}