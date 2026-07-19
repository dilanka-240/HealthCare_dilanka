package app.thivanka.healthcare.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import app.thivanka.healthcare.models.Doctor;

@Repository
public interface DoctorRepository extends JpaRepository<Doctor, Long>{
	Optional<Doctor> findById(Long id);
}