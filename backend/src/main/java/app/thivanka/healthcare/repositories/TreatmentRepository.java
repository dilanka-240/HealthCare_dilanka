package app.thivanka.healthcare.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import app.thivanka.healthcare.models.Patient;
import app.thivanka.healthcare.models.Treatment;

import java.util.Optional;

public interface TreatmentRepository extends JpaRepository<Treatment, Long>{
	
	Optional<Treatment> findByPatient(Patient patient);
	Optional<Treatment> findByTreatId(Long treatId);
}