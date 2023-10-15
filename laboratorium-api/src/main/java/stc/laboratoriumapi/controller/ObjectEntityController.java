package stc.laboratoriumapi.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import stc.laboratoriumapi.domain.ObjectEntity;
import stc.laboratoriumapi.dto.objectEntity.ObjectEntityDto;
import stc.laboratoriumapi.dto.objectEntity.ObjectEntityInputDto;
import stc.laboratoriumapi.mapper.ObjectEntityDtoMapper;
import stc.laboratoriumapi.service.ObjectEntityService;

import java.util.List;
import java.util.UUID;

@Slf4j
@RestController
@RequestMapping("object-entities")
@Tag(name = "Object Entities")
@RequiredArgsConstructor
public class ObjectEntityController {
	private final ObjectEntityService objectEntityService;
	private final ObjectEntityDtoMapper objectEntityDtoMapper;

	@GetMapping()
	public ResponseEntity<List<ObjectEntityDto>> retrieveAll() {
		List<ObjectEntity> objectEntities = this.objectEntityService.retrieveAll();
		return ResponseEntity.ok(this.objectEntityDtoMapper.toDtoList(objectEntities));
	}

	@GetMapping("/{id}")
	public ResponseEntity<ObjectEntityDto> retrieveById(@PathVariable UUID id) {
		ObjectEntity retrievedObjectEntity = this.objectEntityService.retrieveById(id);
		return ResponseEntity.ok(this.objectEntityDtoMapper.toDto(retrievedObjectEntity));
	}

	@PostMapping()
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<ObjectEntityDto> save(
			@RequestBody ObjectEntityInputDto objectEntityInputDto
	) {
		ObjectEntity mappedObjectEntity = this.objectEntityDtoMapper.toDomain(objectEntityInputDto);
		ObjectEntity savedObjectEntity = this.objectEntityService.save(mappedObjectEntity);
		return ResponseEntity.ok(this.objectEntityDtoMapper.toDto(savedObjectEntity));
	}
}
