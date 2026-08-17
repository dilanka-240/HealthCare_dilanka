package app.thivanka.healthcare.mappers;

import java.util.List;

import app.thivanka.healthcare.dto.PatientDTO;
import app.thivanka.healthcare.dto.PatientInformationDTO;
import app.thivanka.healthcare.models.Examination;
import app.thivanka.healthcare.models.Patient;
import app.thivanka.healthcare.models.Treatment;

public class PatientMapper{
	
	public static Patient toCreateEntity(PatientDTO patientDto) { //to create patient
		Patient patient = new Patient();
		patient.setName(patientDto.getName());
		patient.setBirthday(patientDto.getBirthday());
		patient.setSex(patientDto.getSex());
		patient.setAllergies(patientDto.getAllergies());
		patient.setOccupation(patientDto.getOccupation());
		return patient;
	}
	
	public static PatientDTO toCreateInfoDto(Patient patient) { //to create patient
		PatientDTO patientDto = new PatientDTO();
		patientDto.setNo(patient.getNo());
		patientDto.setName(patient.getName());
		patientDto.setBirthday(patient.getBirthday());
		patientDto.setSex(patient.getSex());
		patientDto.setAllergies(patient.getAllergies());
		patientDto.setOccupation(patient.getOccupation());
		return patientDto;
	}
	
	public static PatientInformationDTO toInfoDto(Patient patient,
		                List<Examination> examination,
	                  List<Treatment> treatment) { //to patient information

		PatientInformationDTO patientInformationDto = new PatientInformationDTO();
		patientInformationDto.setName(patient.getName());
		patientInformationDto.setBirthday(patient.getBirthday());
		patientInformationDto.setSex(patient.getSex());
		patientInformationDto.setOccupation(patient.getOccupation());
		patientInformationDto.setAllergies(patient.getAllergies());
		patientInformationDto.setBp(examination.getBp());
		patientInformationDto.setHp(examination.getHp());
		patientInformationDto.setWi(examination.getWi());
		patientInformationDto.setTemp(examination.getTemp());
		patientInformationDto.setTreatment(treatment.getTreat_details());
		return patientInformationDto;
	}
	
	public static Patient toInfoEntity(PatientInformationDTO patientInformationDto) {
		Patient patient = new Patient();
		patient.setName(patientInformationDto.getName());
		patient.setBirthday(patientInformationDto.getBirthday());
		patient.setSex(patientInformationDto.getSex());
		patient.setAllergies(patientInformationDto.getAllergies());
		patient.setOccupation(patientInformationDto.getOccupation());
		return patient;
	}
	
}
