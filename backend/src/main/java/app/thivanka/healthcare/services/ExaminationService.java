package app.thivanka.healthcare.services;

import app.thivanka.healthcare.dto.ExaminationDTO;
import app.thivanka.healthcare.dto.UpdateExaminationDTO;

public interface ExaminationService{
	ExaminationDTO addExamination(ExaminationDTO examinationDto);
	UpdateExaminationDTO updateExamination(UpdateExaminationDTO updateExaminationDto);
	void deleteExamination(Long examId);
}