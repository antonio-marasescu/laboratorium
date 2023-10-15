package stc.laboratoriumapi.mapper;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import stc.laboratoriumapi.domain.Simulation;
import stc.laboratoriumapi.domain.World;
import stc.laboratoriumapi.dto.simulation.SimulationDto;
import stc.laboratoriumapi.dto.simulation.SimulationInputDto;
import stc.laboratoriumapi.mapper.base.BaseDtoMapper;

@Component
@RequiredArgsConstructor
public class SimulationDtoMapper implements BaseDtoMapper<Simulation, SimulationInputDto, SimulationDto> {
	@Override
	public SimulationDto toDto(Simulation domain) {
		return SimulationDto.builder()
		                    .id(domain.getId())
		                    .name(domain.getName())
		                    .description(domain.getDescription())
		                    .worldId(domain.getWorld().getId())
		                    .build();
	}

	@Override
	public Simulation toDomain(SimulationInputDto dto) {
		return Simulation.builder().id(dto.getId()).name(dto.getName()).description(dto.getDescription()).build();
	}

	public Simulation toDomain(SimulationInputDto dto, World world) {
		return Simulation.builder()
		                 .id(dto.getId())
		                 .name(dto.getName())
		                 .description(dto.getDescription())
		                 .world(world)
		                 .build();
	}
}
