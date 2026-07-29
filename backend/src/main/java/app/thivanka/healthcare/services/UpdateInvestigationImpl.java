package app.thivanka.healthcare.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import app.thivanka.healthcare.dto.InvestigationDTO;
import app.thivanka.healthcare.dto.UpdateInvestigationDTO;
import app.thivanka.healthcare.mappers.InvestigationMapper;
import app.thivanka.healthcare.models.Investigation;
import app.thivanka.healthcare.models.Patient;
import app.thivanka.healthcare.repositories.InvestigationRepository;
import app.thivanka.healthcare.repositories.PatientRepository;
import app.thivanka.healthcare.mappers.UpdateInvestigationMapper;

@Service
public class UpdateInvestigationImpl implements UpdateInvestigation{
	
	@Autowired
	InvestigationRepository investigationRepository;
	
	@Autowired
	PatientRepository patientRepository;
	
	@Transactional
	public UpdateInvestigationDTO updateInvestigation(UpdateInvestigationDTO updateInvestigationDto) {

		Patient patient = patientRepository.findByNo(updateInvestigationDto.getNo())
				.orElseThrow(() -> new IllegalArgumentException("Patient not exits"));

		Investigation investigation = investigationRepository.findByPatient(patient)
				.orElseThrow(() -> new IllegalArgumentException("Investigation not exits"));
		
		UpdateInvestigationMapper.toEntity(updateInvestigationDto, investigation);
		investigationRepository.save(investigation);
		
		return UpdateInvestigationMapper.toDto(investigation);
	}
}
