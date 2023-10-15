package stc.laboratoriumapi.dto.objectEntity;

import lombok.Builder;
import lombok.Data;

import java.util.UUID;

@Data
@Builder
public class ObjectEntityDto {
	private UUID id;
	private String name;
}
