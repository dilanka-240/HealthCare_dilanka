package app.thivanka.healthcare.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
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
import app.thivanka.healthcare.services.AddInvestigation;
import app.thivanka.healthcare.services.AddTreatment;
import app.thivanka.healthcare.services.ExaminationService;
import app.thivanka.healthcare.services.PatientService;
import app.thivanka.healthcare.services.ShowPatientInfo;
import app.thivanka.healthcare.services.UpdateInvestigation;
import app.thivanka.healthcare.services.UpdateTreatment;

@RestController
@RequestMapping("/patient")
public class PatientController{
	
	@Autowired
	private final PatientService patientService;
	
	@Autowired
	private final ShowPatientInfo showPatientInfo;
	
	@Autowired
	private final ExaminationService examinationService;
	
	
	@Autowired
	private final AddTreatment addTreatment;
	
	
	@Autowired
	private final AddInvestigation addInvestigation;
	
	@Autowired
	private final UpdateInvestigation updateInvestigation;
	
	@Autowired
	private final UpdateTreatment updateTreatment;
	

	public PatientController(PatientService patientService,
							ShowPatientInfo showPatientInfo,
							ExaminationService examinationService,
							AddTreatment addTreatment,
							AddInvestigation addInvestigation,
							UpdateInvestigation updateInvestigation,
							UpdateTreatment updateTreatment) {
		this.patientService = patientService;
		this.showPatientInfo = showPatientInfo;
		this.examinationService = examinationService;
		this.addTreatment = addTreatment;
		this.addInvestigation = addInvestigation;
		this.updateInvestigation = updateInvestigation;
		this.updateTreatment = updateTreatment;
	}

	// create patient
	@PostMapping("/create")
	public ResponseEntity<PatientDTO> createPatient(@RequestBody PatientDTO patientDto){
		return ResponseEntity.ok(patientService.createPatient(patientDto));
	}
	
	// Get info about patient
	@GetMapping("/info/{no}")
	public ResponseEntity<PatientInformationDTO> showPatientInfo(@PathVariable Long no) {
		return ResponseEntity.ok(showPatientInfo.showInformation(no));
	}
	
	// Create new examination
	@PostMapping("/exam")
	public ResponseEntity<ExaminationDTO> addExamination(@RequestBody ExaminationDTO examinationDto){
		return ResponseEntity.ok(examinationService.addExamination(examinationDto));
	}

	// Update existing examination
	@PutMapping("/exam/update")
	public ResponseEntity<UpdateExaminationDTO> updateExamination(@RequestBody UpdateExaminationDTO updateExaminationDto){
		return ResponseEntity.ok(examinationService.updateExamination(updateExaminationDto));
	}
	
	// Delete Examination
	@DeleteMapping("{no}/exam/{examId}/delete")
	public ResponseEntity<Long> deleteExamination(@PathVariable Long examId){
		examinationService.deleteExamination(examId);
		return ResponseEntity.ok(examId);
	}
	
	@PostMapping("/treat")
	public ResponseEntity<TreatmentDTO> addTreatment(@RequestBody TreatmentDTO treatmentDto){
		return ResponseEntity.ok(addTreatment.addTreatment(treatmentDto));
	}
		
	@PostMapping("/inv")
	public ResponseEntity<InvestigationDTO> addInvestigation(@RequestBody InvestigationDTO investigationDto){
		return ResponseEntity.ok(addInvestigation.addInvestigation(investigationDto));
	}
	
	@PutMapping("/inv/update")
	public ResponseEntity<UpdateInvestigationDTO> updateInvestigation(@RequestBody UpdateInvestigationDTO updateInvestigationDto){
		return ResponseEntity.ok(updateInvestigation.updateInvestigation(updateInvestigationDto));
	}
	
	@PutMapping("/treat/update")
	public ResponseEntity<UpdateTreatmentDTO> updateTreatment(@RequestBody UpdateTreatmentDTO updateTreatmentDto){
		return ResponseEntity.ok(updateTreatment.updateTreatment(updateTreatmentDto));
	}
	
	@DeleteMapping("/{no}/delete")
	public ResponseEntity<Long> deletePatient(@PathVariable Long no){
		patientService.deletePatient(no);
		return ResponseEntity.ok(no);
	}
}