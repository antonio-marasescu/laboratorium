package stc.laboratoriumapi.mapper;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import stc.laboratoriumapi.domain.ObjectEntity;
import stc.laboratoriumapi.domain.World;
import stc.laboratoriumapi.dto.world.WorldDto;
import stc.laboratoriumapi.dto.world.WorldInputDto;
import stc.laboratoriumapi.mapper.base.BaseDtoMapper;

import java.util.List;

@Component
@RequiredArgsConstructor
public class WorldDtoMapper implements BaseDtoMapper<World, WorldInputDto, WorldDto> {
	private final ObjectEntityDtoMapper objectEntityDtoMapper;

	@Override
	public WorldDto toDto(World domain) {
		return WorldDto.builder()
		               .id(domain.getId())
		               .name(domain.getName())
		               .description(domain.getDescription())
		               .objectEntities(domain.getObjectEntities().stream().map(objectEntityDtoMapper::toDto).toList())
		               .build();
	}

	@Override
	public World toDomain(
			WorldInputDto dto
	) {
		return World.builder().id(dto.getId()).name(dto.getName()).description(dto.getDescription()).build();
	}

	public World toDomain(
			WorldInputDto dto, List<ObjectEntity> objectEntities
	) {
		return World.builder().id(dto.getId()).name(dto.getName()).description(dto.getDescription()).objectEntities(
				objectEntities).build();
	}
}
