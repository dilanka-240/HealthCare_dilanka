package app.thivanka.healthcare.services;

import app.thivanka.healthcare.dto.InvestigationDTO;
import app.thivanka.healthcare.dto.UpdateInvestigationDTO;

public interface InvestigationService{
	
	InvestigationDTO addInvestigation(InvestigationDTO investigationDto);
	UpdateInvestigationDTO updateInvestigation(UpdateInvestigationDTO updateInvestigationDto);
	void deleteInvestigation(Long invId);
}