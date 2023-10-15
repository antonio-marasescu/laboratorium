package stc.laboratoriumapi.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import stc.laboratoriumapi.domain.World;
import stc.laboratoriumapi.domain.enums.ExceptionCode;
import stc.laboratoriumapi.exception.ApiException;
import stc.laboratoriumapi.repository.WorldRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Slf4j
@Service
@RequiredArgsConstructor
@Transactional
public class WorldService {
	private final WorldRepository worldRepository;

	public List<World> retrieveAll() {
		return this.worldRepository.findAll();
	}

	public World retrieveById(UUID id) {
		Optional<World> retrievedWorld = this.worldRepository.findById(id);
		if (retrievedWorld.isEmpty()) {
			throw ApiException.builder().code(ExceptionCode.NOT_FOUND).build();
		}
		return retrievedWorld.get();
	}

	public World save(World world) {
		return this.worldRepository.save(world);
	}
}
