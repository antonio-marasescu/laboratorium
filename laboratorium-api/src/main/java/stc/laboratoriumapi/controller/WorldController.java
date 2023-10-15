package stc.laboratoriumapi.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import stc.laboratoriumapi.domain.ObjectEntity;
import stc.laboratoriumapi.domain.World;
import stc.laboratoriumapi.dto.world.WorldDto;
import stc.laboratoriumapi.dto.world.WorldInputDto;
import stc.laboratoriumapi.mapper.WorldDtoMapper;
import stc.laboratoriumapi.service.ObjectEntityService;
import stc.laboratoriumapi.service.WorldService;

import java.util.List;
import java.util.UUID;

@Slf4j
@RestController
@RequestMapping("worlds")
@Tag(name = "Worlds")
@RequiredArgsConstructor
public class WorldController {
	private final WorldService worldService;
	private final ObjectEntityService objectEntityService;
	private final WorldDtoMapper worldDtoMapper;

	@GetMapping()
	public ResponseEntity<List<WorldDto>> retrieveAll() {
		List<World> worlds = this.worldService.retrieveAll();
		return ResponseEntity.ok(this.worldDtoMapper.toDtoList(worlds));
	}

	@GetMapping("/{id}")
	public ResponseEntity<WorldDto> retrieveById(@PathVariable UUID id) {
		World retrievedWorld = this.worldService.retrieveById(id);
		return ResponseEntity.ok(this.worldDtoMapper.toDto(retrievedWorld));
	}


	@PostMapping()
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<WorldDto> save(
			@RequestBody WorldInputDto worldInputDto
	) {
		List<ObjectEntity> objectEntities = this.objectEntityService.retrieveByIds(worldInputDto.getObjectEntities());
		World mappedWorld = this.worldDtoMapper.toDomain(worldInputDto, objectEntities);
		World savedWorld = this.worldService.save(mappedWorld);
		return ResponseEntity.ok(this.worldDtoMapper.toDto(savedWorld));
	}
}
