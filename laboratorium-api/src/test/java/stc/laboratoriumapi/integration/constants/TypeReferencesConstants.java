package stc.laboratoriumapi.integration.constants;

import com.fasterxml.jackson.core.type.TypeReference;
import stc.laboratoriumapi.dto.objectEntity.ObjectEntityDto;

import java.util.List;

public class TypeReferencesConstants {
	public static final TypeReference<List<ObjectEntityDto>> ObjectEntityDtoRef = new TypeReference<>() {
	};
}
