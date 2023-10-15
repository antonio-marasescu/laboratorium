package stc.laboratoriumapi.dto.world;

import lombok.Builder;
import lombok.Data;

import java.util.List;
import java.util.UUID;

@Data
@Builder
public class WorldInputDto {
	private UUID id;
	private String name;
	private String description;
	private List<UUID> objectEntities;
}
