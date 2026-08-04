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
import app.thivanka.healthcare.services.ExaminationService;
import app.thivanka.healthcare.services.InvestigationService;
import app.thivanka.healthcare.services.PatientService;
import app.thivanka.healthcare.services.ShowPatientInfo;
import app.thivanka.healthcare.services.TreatmentService;

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
	private final TreatmentService treatmentService;
	

	@Autowired
	private final InvestigationService investigationService;
	
	

	public PatientController(PatientService patientService,
							ShowPatientInfo showPatientInfo,
							ExaminationService examinationService,
							TreatmentService treatmentService,
							InvestigationService investigationService) {
		this.patientService = patientService;
		this.showPatientInfo = showPatientInfo;
		this.examinationService = examinationService;
		this.treatmentService = treatmentService;
		this.investigationService = investigationService;
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
	@PostMapping("/{no}/exam")
	public ResponseEntity<ExaminationDTO> addExamination(
			@PathVariable Long no,
			@RequestBody ExaminationDTO examinationDto){
		return ResponseEntity.ok(examinationService.addExamination(examinationDto));
	}

	// Update existing examination
	@PutMapping("/{no}/exam/{examId}/update")
	public ResponseEntity<UpdateExaminationDTO> updateExamination(
			@PathVariable Long examId,
			@PathVariable Long no,
			@RequestBody UpdateExaminationDTO updateExaminationDto){
		return ResponseEntity.ok(examinationService.updateExamination(updateExaminationDto));
	}
	
	// Delete Examination
	@DeleteMapping("{no}/exam/{examId}/delete")
	public ResponseEntity<Long> deleteExamination(
			@PathVariable Long examId,
			@PathVariable Long no){
		examinationService.deleteExamination(examId);
		return ResponseEntity.ok(examId);
	}
	
	// Add Treatment
	@PostMapping("/{no}/treat")
	public ResponseEntity<TreatmentDTO> addTreatment(
			@PathVariable Long no,
			@RequestBody TreatmentDTO treatmentDto){
		return ResponseEntity.ok(treatmentService.addTreatment(treatmentDto));
	}
	
	// Update existing Treatment
	@PutMapping("/{no}/treat/{treatId}/update")
	public ResponseEntity<UpdateTreatmentDTO> updateTreatment(
			@PathVariable Long no,
			@PathVariable Long treatId,
			@RequestBody UpdateTreatmentDTO updateTreatmentDto){
		return ResponseEntity.ok(treatmentService.updateTreatment(updateTreatmentDto));
	}
	
	// Delete treatment
	@DeleteMapping("/{no}/treat/{treatId}/delete")
	public ResponseEntity<Long> deleteTreatment(
			@PathVariable Long treatId,
			@PathVariable Long no){
		treatmentService.deleteTreatment(treatId);
		return ResponseEntity.ok(treatId);
	}
		
	
	// Create investigation
	@PostMapping("/{no}/inv")
	public ResponseEntity<InvestigationDTO> addInvestigation(
			@PathVariable Long no,
			@RequestBody InvestigationDTO investigationDto){
		return ResponseEntity.ok(investigationService.addInvestigation(investigationDto));
	}
	
	// Update investigation
	@PutMapping("/{no}/inv/{invId}/update")
	public ResponseEntity<UpdateInvestigationDTO> updateInvestigation(
			@PathVariable Long no,
			@PathVariable Long invId,
			@RequestBody UpdateInvestigationDTO updateInvestigationDto){
		return ResponseEntity.ok(investigationService.updateInvestigation(updateInvestigationDto));
	}
	
	// Delete investigation
	@DeleteMapping("/{no}/inv/{invId}/delete")
	public ResponseEntity<Long> deleteInvestigation(
			@PathVariable Long invId,
			@PathVariable Long no){
		investigationService.deleteInvestigation(invId);
		return ResponseEntity.ok(invId);
	}
	
	
	@DeleteMapping("/{no}/delete")
	public ResponseEntity<Long> deletePatient(@PathVariable Long no){
		patientService.deletePatient(no);
		return ResponseEntity.ok(no);
	}
}