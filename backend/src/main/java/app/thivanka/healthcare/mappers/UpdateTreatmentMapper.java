package app.thivanka.healthcare.mappers;

import app.thivanka.healthcare.dto.UpdateTreatmentDTO;
import app.thivanka.healthcare.models.Treatment;

public class UpdateTreatmentMapper{
	
	public static Treatment toEntity(UpdateTreatmentDTO updateTreatmentDto, Treatment existing) {
		
		existing.setTreat_details(updateTreatmentDto.getTreat_details());
		return existing;
	}
	
	public static UpdateTreatmentDTO toDto(Treatment treatment) {
		UpdateTreatmentDTO updateTreatmentDto = new UpdateTreatmentDTO();
		updateTreatmentDto.setNo(treatment.getPatient().getNo());
		updateTreatmentDto.setTreatId(treatment.getTreatId());
		updateTreatmentDto.setTreat_details(treatment.getTreat_details());
		return updateTreatmentDto;
	}
}