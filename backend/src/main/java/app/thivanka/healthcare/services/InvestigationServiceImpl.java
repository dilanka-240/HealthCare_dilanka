package app.thivanka.healthcare.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import app.thivanka.healthcare.dto.InvestigationDTO;
import app.thivanka.healthcare.dto.UpdateInvestigationDTO;
import app.thivanka.healthcare.mappers.InvestigationMapper;
import app.thivanka.healthcare.mappers.UpdateInvestigationMapper;
import app.thivanka.healthcare.repositories.InvestigationRepository;
import app.thivanka.healthcare.repositories.PatientRepository;
import app.thivanka.healthcare.models.Investigation;
import app.thivanka.healthcare.models.Patient;

@Service
public class InvestigationServiceImpl implements InvestigationService{
	
	@Autowired
	PatientRepository patientRepository;
	
	@Autowired
	InvestigationRepository investigationRepository;

	// Create new investigation
	public InvestigationDTO addInvestigation(InvestigationDTO investigationDto) {
		Long no = investigationDto.getNo();
		Patient patient = patientRepository.findByNo(no)
				.orElseThrow(() -> new IllegalArgumentException("Patient does not exits"));
		
		Investigation investigation = InvestigationMapper.toEntity(investigationDto);
		investigation.setPatient(patient);
		investigationRepository.save(investigation);
		
		return InvestigationMapper.toDto(investigation);
	}
	
	// Update existing investigation
	@Transactional
	public UpdateInvestigationDTO updateInvestigation(UpdateInvestigationDTO updateInvestigationDto) {

		Patient patient = patientRepository.findByNo(updateInvestigationDto.getNo())
				.orElseThrow(() -> new IllegalArgumentException("Patient not exits"));

		Investigation investigation = investigationRepository.findById(updateInvestigationDto.getInvId())
				.orElseThrow(() -> new IllegalArgumentException("investigation not exists"));
		
		UpdateInvestigationMapper.toEntity(updateInvestigationDto, investigation);
		investigationRepository.save(investigation);
		
		return UpdateInvestigationMapper.toDto(investigation);
	}

	// Delete existing investigation
	public void deleteInvestigation(Long invId) {
		
		if(!investigationRepository.existsById(invId)) {
			throw new IllegalArgumentException("Investigation not exists");
		}
		
		investigationRepository.deleteById(invId);
	}
}