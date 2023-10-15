package stc.laboratoriumapi.mapper;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import stc.laboratoriumapi.domain.ObjectEntity;
import stc.laboratoriumapi.dto.objectEntity.ObjectEntityDto;
import stc.laboratoriumapi.dto.objectEntity.ObjectEntityInputDto;
import stc.laboratoriumapi.mapper.base.BaseDtoMapper;

@Component
@RequiredArgsConstructor
public class ObjectEntityDtoMapper implements BaseDtoMapper<ObjectEntity, ObjectEntityInputDto, ObjectEntityDto> {
	@Override
	public ObjectEntityDto toDto(ObjectEntity domain) {
		return ObjectEntityDto.builder().id(domain.getId()).name(domain.getName()).build();
	}

	@Override
	public ObjectEntity toDomain(ObjectEntityInputDto dto) {
		return ObjectEntity.builder().id(dto.getId()).name(dto.getName()).build();
	}
}
