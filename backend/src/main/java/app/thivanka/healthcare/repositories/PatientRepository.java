package app.thivanka.healthcare.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import app.thivanka.healthcare.models.Patient;

import java.util.List;
import java.util.Optional;


@Repository
public interface PatientRepository extends JpaRepository<Patient, Long> {
	Optional<Patient> findByNo(Long no);
	List<Patient> findByName(String name);
}