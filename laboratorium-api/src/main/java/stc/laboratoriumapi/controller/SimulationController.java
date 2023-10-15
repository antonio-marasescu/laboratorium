package stc.laboratoriumapi.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import stc.laboratoriumapi.domain.Simulation;
import stc.laboratoriumapi.domain.World;
import stc.laboratoriumapi.dto.simulation.SimulationDto;
import stc.laboratoriumapi.dto.simulation.SimulationInputDto;
import stc.laboratoriumapi.mapper.SimulationDtoMapper;
import stc.laboratoriumapi.mapper.WorldDtoMapper;
import stc.laboratoriumapi.service.SimulationService;
import stc.laboratoriumapi.service.WorldService;

import java.util.List;
import java.util.UUID;

@Slf4j
@RestController
@RequestMapping("simulations")
@Tag(name = "Simulations")
@RequiredArgsConstructor
public class SimulationController {
	private final WorldService worldService;
	private final SimulationService simulationService;
	private final WorldDtoMapper worldDtoMapper;
	private final SimulationDtoMapper simulationDtoMapper;

	@GetMapping()
	public ResponseEntity<List<SimulationDto>> retrieveAll() {
		List<Simulation> simulations = this.simulationService.retrieveAll();
		return ResponseEntity.ok(this.simulationDtoMapper.toDtoList(simulations));
	}

	@GetMapping("/{id}")
	public ResponseEntity<SimulationDto> retrieveById(@PathVariable UUID id) {
		Simulation retrievedSimulation = this.simulationService.retrieveById(id);
		return ResponseEntity.ok(this.simulationDtoMapper.toDto(retrievedSimulation));
	}


	@PostMapping()
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<SimulationDto> save(
			@RequestBody SimulationInputDto simulationInputDto
	) {
		World selectedWorld = this.worldService.retrieveById(simulationInputDto.getWorldId());
		Simulation mappedSimulation = this.simulationDtoMapper.toDomain(simulationInputDto, selectedWorld);
		Simulation savedSimulation = this.simulationService.save(mappedSimulation);
		return ResponseEntity.ok(this.simulationDtoMapper.toDto(savedSimulation));
	}
}
