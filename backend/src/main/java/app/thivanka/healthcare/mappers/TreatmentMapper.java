package app.thivanka.healthcare.mappers;

import app.thivanka.healthcare.dto.TreatmentDTO;
import app.thivanka.healthcare.models.Treatment;

public class TreatmentMapper{
	
	public static Treatment toEntity(TreatmentDTO treatmentDto) {
		Treatment treatment = new Treatment();
		treatment.setTreat_id(treatmentDto.getTreat_id());
		treatment.setPatient(treatmentDto.getPatient());
		treatment.setTreat_details(treatmentDto.getTreat_details());
		treatment.setTreat_date(treatmentDto.getTreat_date());
		return treatment; 
	}
	
	public static TreatmentDTO toDTO(Treatment treatment) {
		TreatmentDTO treatmentDto = new TreatmentDTO();
		treatmentDto.setTreat_id(treatment.getTreat_id());
		treatmentDto.setPatient(treatmentDto.getPatient());
		treatmentDto.setTreat_details(treatment.getTreat_details());
		treatmentDto.setTreat_date(treatment.getTreat_date());
		return treatmentDto;
	}
}