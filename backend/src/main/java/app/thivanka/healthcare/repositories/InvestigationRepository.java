package app.thivanka.healthcare.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import app.thivanka.healthcare.models.Investigation;

public interface InvestigationRepository extends JpaRepository <Investigation, Long>{
	Optional<Investigation> findByNo(Long no);
}