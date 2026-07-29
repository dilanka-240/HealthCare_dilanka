package app.thivanka.healthcare.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.thivanka.healthcare.dto.InvestigationDTO;
import app.thivanka.healthcare.mappers.InvestigationMapper;
import app.thivanka.healthcare.repositories.InvestigationRepository;
import app.thivanka.healthcare.repositories.PatientRepository;
import app.thivanka.healthcare.models.Investigation;
import app.thivanka.healthcare.models.Patient;

@Service
public class AddInvestigationImpl implements AddInvestigation{
	
	@Autowired
	PatientRepository patientRepository;
	
	@Autowired
	InvestigationRepository investigationRepository;

	public InvestigationDTO addInvestigation(InvestigationDTO investigationDto) {
		Long no = investigationDto.getNo();
		Patient patient = patientRepository.findByNo(no)
				.orElseThrow(() -> new IllegalArgumentException("Patient does not exits"));
		
		Investigation investigation = InvestigationMapper.toEntity(investigationDto);
		investigation.setPatient(patient);
		investigationRepository.save(investigation);
		
		return InvestigationMapper.toDto(investigation);
	}
}