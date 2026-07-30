package app.thivanka.healthcare.mappers;

import app.thivanka.healthcare.dto.UpdateInvestigationDTO;
import app.thivanka.healthcare.models.Investigation;

public class UpdateInvestigationMapper {
	
	public static Investigation toEntity(UpdateInvestigationDTO updateInvestigationDto, Investigation existing) {
		existing.setInv_details(updateInvestigationDto.getInv_details());
		return existing;
	}
	
	public static UpdateInvestigationDTO toDto(Investigation investigation) {
		UpdateInvestigationDTO updateInvestigationDto = new UpdateInvestigationDTO();
		updateInvestigationDto.setInvId(investigation.getInvId());
		updateInvestigationDto.setNo(investigation.getPatient().getNo());
		updateInvestigationDto.setInv_details(investigation.getInv_details());
		return updateInvestigationDto;
	}
}