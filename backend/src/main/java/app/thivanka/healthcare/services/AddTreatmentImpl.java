package app.thivanka.healthcare.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import app.thivanka.healthcare.dto.TreatmentDTO;
import app.thivanka.healthcare.mappers.TreatmentMapper;
import app.thivanka.healthcare.models.Patient;
import app.thivanka.healthcare.models.Treatment;
import app.thivanka.healthcare.repositories.PatientRepository;
import app.thivanka.healthcare.repositories.TreatmentRepository;

@Service
public class AddTreatmentImpl implements AddTreatment{
	
	@Autowired
	TreatmentRepository treatmentRepository;
	
	@Autowired
	PatientRepository patientRepository;
	
	@Override
	@Transactional
	public TreatmentDTO addTreatment(TreatmentDTO treatmentDto) {
		
		Long no = treatmentDto.getNo();
		Patient patient = patientRepository.findByNo(no)
				.orElseThrow(() -> new IllegalArgumentException("Patient does not exits"));

		Treatment treatment = TreatmentMapper.toEntity(treatmentDto);
		treatment.setPatient(patient);
		treatmentRepository.save(treatment);
		return TreatmentMapper.toDTO(treatment);
	}
	
}