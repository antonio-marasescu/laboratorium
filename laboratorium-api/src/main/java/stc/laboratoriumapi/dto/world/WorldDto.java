package stc.laboratoriumapi.dto.world;

import lombok.Builder;
import lombok.Data;
import stc.laboratoriumapi.dto.objectEntity.ObjectEntityDto;

import java.util.List;
import java.util.UUID;

@Data
@Builder
public class WorldDto {
	private UUID id;
	private String name;
	private String description;
	private List<ObjectEntityDto> objectEntities;
}
