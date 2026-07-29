package app.thivanka.healthcare.mappers;

import app.thivanka.healthcare.dto.TreatmentDTO;
import app.thivanka.healthcare.models.Treatment;

public class TreatmentMapper{
	
	public static Treatment toEntity(TreatmentDTO treatmentDto) {
		Treatment treatment = new Treatment();
		treatment.setTreatId(treatmentDto.getTreat_id());
		treatment.setTreat_details(treatmentDto.getTreat_details());
		treatment.setTreat_date(treatmentDto.getTreat_date());
		return treatment; 
	}
	
	public static TreatmentDTO toDTO(Treatment treatment) {
		TreatmentDTO treatmentDto = new TreatmentDTO();
		treatmentDto.setTreat_id(treatment.getTreatId());
		treatmentDto.setNo(treatment.getPatient().getNo());
		treatmentDto.setTreat_details(treatment.getTreat_details());
		treatmentDto.setTreat_date(treatment.getTreat_date());
		return treatmentDto;
	}
}