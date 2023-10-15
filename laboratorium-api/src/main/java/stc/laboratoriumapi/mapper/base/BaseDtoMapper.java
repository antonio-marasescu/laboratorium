package stc.laboratoriumapi.mapper.base;

import java.util.Collection;
import java.util.List;

public interface BaseDtoMapper<Domain, InputDto, OutputDto> {
	OutputDto toDto(Domain domain);

	Domain toDomain(InputDto dto);

	default List<OutputDto> toDtoList(Collection<Domain> domains) {
		return domains.stream().map(this::toDto).toList();
	}

	default List<Domain> toDomainList(Collection<InputDto> dtos) {
		return dtos.stream().map(this::toDomain).toList();
	}
}
