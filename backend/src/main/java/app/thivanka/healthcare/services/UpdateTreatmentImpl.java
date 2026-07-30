package app.thivanka.healthcare.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.thivanka.healthcare.dto.UpdateTreatmentDTO;
import app.thivanka.healthcare.mappers.UpdateTreatmentMapper;
import app.thivanka.healthcare.models.Patient;
import app.thivanka.healthcare.models.Treatment;
import app.thivanka.healthcare.repositories.PatientRepository;
import app.thivanka.healthcare.repositories.TreatmentRepository;

@Service
public class UpdateTreatmentImpl implements UpdateTreatment{
	
	@Autowired
	PatientRepository patientRepository;
	
	@Autowired
	TreatmentRepository treatmentRepository;
	
	public UpdateTreatmentDTO updateTreatment(UpdateTreatmentDTO updateTreatmentDto) {
		Patient patient = patientRepository.findByNo(updateTreatmentDto.getNo())
				.orElseThrow(() -> new IllegalArgumentException("Patient not exists"));
		
		Treatment treatment = treatmentRepository.findById(updateTreatmentDto.getTreatId())
				.orElseThrow(() -> new IllegalArgumentException("Treatment not exists"));
		
		treatment = UpdateTreatmentMapper.toEntity(updateTreatmentDto, treatment);
		treatmentRepository.save(treatment);
		
		return UpdateTreatmentMapper.toDto(treatment);
	}
}