package app.thivanka.healthcare.mappers;

import app.thivanka.healthcare.dto.UpdateExaminationDTO;
import app.thivanka.healthcare.models.Examination;

public class UpdateExaminationMapper{
	
	public static Examination toEntity(UpdateExaminationDTO updateExaminationDto, Examination existing) {
		
		existing.setBp(updateExaminationDto.getBp());
		existing.setHp(updateExaminationDto.getHp());
		existing.setWi(updateExaminationDto.getWi());
		existing.setTemp(updateExaminationDto.getTemp());
		return existing;
	}
	
	public static UpdateExaminationDTO toDto(Examination examination) {
		UpdateExaminationDTO updateExaminationDto = new UpdateExaminationDTO();
		
		updateExaminationDto.setExam_id(examination.getExam_id());
		updateExaminationDto.setNo(examination.getPatient().getNo());
		updateExaminationDto.setBp(examination.getBp());
		updateExaminationDto.setHp(examination.getHp());
		updateExaminationDto.setWi(examination.getWi());
		updateExaminationDto.setTemp(examination.getTemp());
		return updateExaminationDto;
	}
}