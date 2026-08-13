package app.thivanka.healthcare.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import app.thivanka.healthcare.dto.TreatmentDTO;
import app.thivanka.healthcare.dto.UpdateTreatmentDTO;
import app.thivanka.healthcare.mappers.TreatmentMapper;
import app.thivanka.healthcare.mappers.UpdateTreatmentMapper;
import app.thivanka.healthcare.models.Patient;
import app.thivanka.healthcare.models.Treatment;
import app.thivanka.healthcare.repositories.PatientRepository;
import app.thivanka.healthcare.repositories.TreatmentRepository;

@Service
public class TreatmentServiceImpl implements TreatmentService{
	
	@Autowired
	TreatmentRepository treatmentRepository;
	
	@Autowired
	PatientRepository patientRepository;
	
	// Add treatment service
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
	
	// Update treatment service
	@Override
	@Transactional
	public UpdateTreatmentDTO updateTreatment(UpdateTreatmentDTO updateTreatmentDto) {
		Patient patient = patientRepository.findByNo(updateTreatmentDto.getNo())
				.orElseThrow(() -> new IllegalArgumentException("Patient not exists"));
		
		Treatment treatment = treatmentRepository.findById(updateTreatmentDto.getTreatId())
				.orElseThrow(() -> new IllegalArgumentException("Treatment not exists"));
		
		treatment = UpdateTreatmentMapper.toEntity(updateTreatmentDto, treatment);
		treatmentRepository.save(treatment);
		
		return UpdateTreatmentMapper.toDto(treatment);
	}
	
	// Delete treatment 
	@Override
	@Transactional
	public void deleteTreatment(Long treatId) {
		
		if(!treatmentRepository.existsById(treatId)) {
			throw new IllegalArgumentException("Treatment not exists");
		}
		
		treatmentRepository.deleteById(treatId);
	}
	
}