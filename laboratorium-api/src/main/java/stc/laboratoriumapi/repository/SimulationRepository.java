package stc.laboratoriumapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import stc.laboratoriumapi.domain.Simulation;

import java.util.UUID;

public interface SimulationRepository extends JpaRepository<Simulation, UUID> {
}
