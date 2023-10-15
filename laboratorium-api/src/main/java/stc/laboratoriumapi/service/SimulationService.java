package stc.laboratoriumapi.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import stc.laboratoriumapi.domain.Simulation;
import stc.laboratoriumapi.domain.enums.ExceptionCode;
import stc.laboratoriumapi.exception.ApiException;
import stc.laboratoriumapi.repository.SimulationRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Slf4j
@Service
@RequiredArgsConstructor
@Transactional
public class SimulationService {
	private final SimulationRepository simulationRepository;

	public List<Simulation> retrieveAll() {
		return this.simulationRepository.findAll();
	}

	public Simulation retrieveById(UUID id) {
		Optional<Simulation> retrievedSimulation = this.simulationRepository.findById(id);
		if (retrievedSimulation.isEmpty()) {
			throw ApiException.builder().code(ExceptionCode.NOT_FOUND).build();
		}
		return retrievedSimulation.get();
	}

	public Simulation save(Simulation simulation) {
		return this.simulationRepository.save(simulation);
	}
}
