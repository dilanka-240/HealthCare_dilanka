package app.thivanka.healthcare.mappers;

import app.thivanka.healthcare.dto.ExaminationDTO;
import app.thivanka.healthcare.models.Examination;

public class ExaminationMapper{
	
	public static Examination toEntity(ExaminationDTO examinationDto) {
		Examination examination = new Examination();
		examination.setExam_id(examination.getExam_id());
		examination.setExam_date(examinationDto.getExam_date());
		examination.setBp(examinationDto.getBp());
		examination.setHp(examinationDto.getHp());
		examination.setWi(examinationDto.getWi());
		examination.setTemp(examinationDto.getTemp());
		return examination;
	}
	
	public static ExaminationDTO toDto(Examination examination) {
		ExaminationDTO examinationDto = new ExaminationDTO();
		examinationDto.setExam_id(examination.getExam_id());
		examinationDto.setNo(examination.getPatient().getNo());
		examinationDto.setExam_date(examination.getExam_date());
		examinationDto.setBp(examination.getBp());
		examinationDto.setHp(examination.getHp());
		examinationDto.setWi(examination.getWi());
		examinationDto.setTemp(examination.getTemp());
		return examinationDto;
	}
}