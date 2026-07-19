package app.thivanka.healthcare.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.thivanka.healthcare.dto.TreatmentDTO;
import app.thivanka.healthcare.mappers.TreatmentMapper;
import app.thivanka.healthcare.models.Treatment;
import app.thivanka.healthcare.repositories.TreatmentRepository;

@Service
public class AddTreatmentImpl implements AddTreatment{
	
	@Autowired
	TreatmentRepository treatmentRepository;
	
	public TreatmentDTO addTreatment(TreatmentDTO treatmentDto) {
		Treatment treatment = TreatmentMapper.toEntity(treatmentDto);
		return TreatmentMapper.toDTO(treatment);
	}
	
}