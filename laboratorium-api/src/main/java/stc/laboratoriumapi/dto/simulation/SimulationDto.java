package stc.laboratoriumapi.dto.simulation;

import lombok.Builder;
import lombok.Data;

import java.util.UUID;

@Data
@Builder
public class SimulationDto {
	private UUID id;
	private String name;
	private String description;
	private UUID worldId;
}
