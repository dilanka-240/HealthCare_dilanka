package app.thivanka.healthcare.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import app.thivanka.healthcare.dto.ExaminationDTO;
import app.thivanka.healthcare.dto.InvestigationDTO;
import app.thivanka.healthcare.dto.PatientDTO;
import app.thivanka.healthcare.dto.PatientInformationDTO;
import app.thivanka.healthcare.dto.TreatmentDTO;
import app.thivanka.healthcare.dto.UpdateExaminationDTO;
import app.thivanka.healthcare.dto.UpdateInvestigationDTO;
import app.thivanka.healthcare.dto.UpdateTreatmentDTO;
import app.thivanka.healthcare.services.AddExamination;
import app.thivanka.healthcare.services.AddInvestigation;
import app.thivanka.healthcare.services.AddTreatment;
import app.thivanka.healthcare.services.CreatePatient;
import app.thivanka.healthcare.services.ShowPatientInfo;
import app.thivanka.healthcare.services.UpdateExamination;
import app.thivanka.healthcare.services.UpdateInvestigation;
import app.thivanka.healthcare.services.UpdateTreatment;

@RestController
@RequestMapping("/patient")
public class PatientController{
	
	@Autowired
	private final CreatePatient createPatient;
	
	@Autowired
	private final ShowPatientInfo showPatientInfo;
	
	@Autowired
	private final AddExamination addExamination;
	
	@Autowired
	private final AddTreatment addTreatment;
	
	@Autowired
	private final UpdateExamination updateExamination;
	
	@Autowired
	private final AddInvestigation addInvestigation;
	
	@Autowired
	private final UpdateInvestigation updateInvestigation;
	
	@Autowired
	private final UpdateTreatment updateTreatment;
	

	public PatientController(CreatePatient createPatient,
							ShowPatientInfo showPatientInfo,
							AddExamination addExamination,
							AddTreatment addTreatment,
							UpdateExamination updateExamination, 
							AddInvestigation addInvestigation,
							UpdateInvestigation updateInvestigation,
							UpdateTreatment updateTreatment) {
		this.createPatient = createPatient;
		this.showPatientInfo = showPatientInfo;
		this.addExamination = addExamination;
		this.addTreatment = addTreatment;
		this.updateExamination = updateExamination;
		this.addInvestigation = addInvestigation;
		this.updateInvestigation = updateInvestigation;
		this.updateTreatment = updateTreatment;
	}

	@PostMapping("/create")
	public ResponseEntity<PatientDTO> createPatient(@RequestBody PatientDTO patientDto){
		return ResponseEntity.ok(createPatient.createPatient(patientDto));
	}
	
	@GetMapping("/info/{no}")
	public ResponseEntity<PatientInformationDTO> showPatientInfo(@PathVariable Long no) {
		return ResponseEntity.ok(showPatientInfo.showInformation(no));
	}
	
	@PostMapping("/exam")
	public ResponseEntity<ExaminationDTO> addExamination(@RequestBody ExaminationDTO examinationDto){
		return ResponseEntity.ok(addExamination.addExamination(examinationDto));
	}
	
	@PostMapping("/treat")
	public ResponseEntity<TreatmentDTO> addTreatment(@RequestBody TreatmentDTO treatmentDto){
		return ResponseEntity.ok(addTreatment.addTreatment(treatmentDto));
	}
	
	@PostMapping("/exam/update")
	public ResponseEntity<UpdateExaminationDTO> updateExamination(@RequestBody UpdateExaminationDTO updateExaminationDto){
		return ResponseEntity.ok(updateExamination.updateExamination(updateExaminationDto));
	}
		
	@PostMapping("/inv")
	public ResponseEntity<InvestigationDTO> addInvestigation(@RequestBody InvestigationDTO investigationDto){
		return ResponseEntity.ok(addInvestigation.addInvestigation(investigationDto));
	}
	
	@PutMapping("/inv/update")
	public ResponseEntity<UpdateInvestigationDTO> updateInvestigation(@RequestBody UpdateInvestigationDTO updateInvestigationDto){
		return ResponseEntity.ok(updateInvestigation.updateInvestigation(updateInvestigationDto));
	}
	
	@PostMapping("/treat/update")
	public ResponseEntity<UpdateTreatmentDTO> updateTreatment(@RequestBody UpdateTreatmentDTO updateTreatmentDto){
		return ResponseEntity.ok(updateTreatment.updateTreatment(updateTreatmentDto));
	}
}