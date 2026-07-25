package app.thivanka.healthcare.mappers;

import app.thivanka.healthcare.dto.InvestigationDTO;
import app.thivanka.healthcare.models.Investigation;

public class InvestigationMapper{
	
	public static Investigation toEntity(InvestigationDTO investigationDto) {
		Investigation investigation = new Investigation();
		investigation.setInv_id(investigationDto.getInv_id());
		investigation.setInv_date(investigationDto.getInv_date());
		investigation.setInv_details(investigationDto.getInv_details());
		investigation.setResults(investigationDto.getResults());
		return investigation;
	}
	
	public static InvestigationDTO toDto(Investigation investigation) {
		InvestigationDTO investigationDto = new InvestigationDTO();
		investigationDto.setInv_id(investigation.getInv_id());
		investigationDto.setNo(investigation.getPatient().getNo());
		investigationDto.setInv_date(investigation.getInv_date());
		investigationDto.setInv_details(investigation.getInv_details());
		investigationDto.setResults(investigation.getResults());
		return investigationDto;
	}
}