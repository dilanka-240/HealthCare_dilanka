package app.thivanka.healthcare.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import app.thivanka.healthcare.models.Investigation;
import app.thivanka.healthcare.models.Patient;

public interface InvestigationRepository extends JpaRepository <Investigation, Long>{
	List<Investigation> findByPatient(Patient patient);
	Optional<Investigation> findById(Long invId);
}