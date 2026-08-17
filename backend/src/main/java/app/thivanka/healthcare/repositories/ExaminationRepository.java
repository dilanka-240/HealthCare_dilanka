package app.thivanka.healthcare.repositories;

import java.util.Optional;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import app.thivanka.healthcare.models.Examination;
import app.thivanka.healthcare.models.Patient;

public interface ExaminationRepository extends JpaRepository<Examination, Long>{
	List<Examination> findByPatient(Patient patient);
	Optional<Examination> findByExamId(Long examId);
}
