package app.thivanka.healthcare.services;

import app.thivanka.healthcare.dto.TreatmentDTO;
import app.thivanka.healthcare.dto.UpdateTreatmentDTO;

public interface TreatmentService {
	TreatmentDTO addTreatment(TreatmentDTO treatmentDto); // Add treatment 
	UpdateTreatmentDTO updateTreatment(UpdateTreatmentDTO updateTreatmentDto); // Update Treatment
	void deleteTreatment(Long treatId);
}