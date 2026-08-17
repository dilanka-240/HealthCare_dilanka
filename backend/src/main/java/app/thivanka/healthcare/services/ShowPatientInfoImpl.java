package app.thivanka.healthcare.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.thivanka.healthcare.dto.PatientInformationDTO;
import app.thivanka.healthcare.mappers.PatientMapper;
import app.thivanka.healthcare.models.Examination;
import app.thivanka.healthcare.models.Patient;
import app.thivanka.healthcare.models.Treatment;
import app.thivanka.healthcare.repositories.ExaminationRepository;
import app.thivanka.healthcare.repositories.InvestigationRepository;
import app.thivanka.healthcare.repositories.PatientRepository;
import app.thivanka.healthcare.repositories.TreatmentRepository;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
public class ShowPatientInfoImpl implements ShowPatientInfo {

  @Autowired
  private final PatientRepository patientRepository;

  @Autowired
  private final InvestigationRepository investigationRepository;

  @Autowired
  private final ExaminationRepository examinationRepository;

  @Autowired
  private final TreatmentRepository treatmentRepository;

  public ShowPatientInfoImpl(PatientRepository patientRepository,
      InvestigationRepository investigationRepository,
      ExaminationRepository examinationRepository,
      TreatmentRepository treatmentRepository) {

    this.patientRepository = patientRepository;
    this.investigationRepository = investigationRepository;
    this.examinationRepository = examinationRepository;
    this.treatmentRepository = treatmentRepository;
  }

  @Transactional
  public PatientInformationDTO showInformation(Long no) {
    Patient patient = patientRepository.findByNo(no)
        .orElseThrow(() -> new RuntimeException("Patient not found"));

    List<Examination> examination = examinationRepository.findByPatient(patient);
    if (examination.isEmpty()) {
      throw new Exception("No examination record");
    }

    List<Treatment> treatment = treatmentRepository.findByPatient(patient);
    if (treatment.isEmpty()) {
      throw new Exception("No treatment record");
    }

    return PatientMapper.toInfoDto(patient, examination, treatment);

  }

}
