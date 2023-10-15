package stc.laboratoriumapi.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import stc.laboratoriumapi.domain.ObjectEntity;
import stc.laboratoriumapi.domain.enums.ExceptionCode;
import stc.laboratoriumapi.exception.ApiException;
import stc.laboratoriumapi.repository.ObjectEntityRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Slf4j
@Service
@RequiredArgsConstructor
@Transactional
public class ObjectEntityService {
	private final ObjectEntityRepository objectEntityRepository;

	public List<ObjectEntity> retrieveAll() {
		return this.objectEntityRepository.findAll();
	}

	public List<ObjectEntity> retrieveByIds(List<UUID> ids) {
		return this.objectEntityRepository.findByObjectEntityIds(ids);
	}

	public ObjectEntity retrieveById(UUID id) {
		Optional<ObjectEntity> retrievedObjectEntity = this.objectEntityRepository.findById(id);
		if (retrievedObjectEntity.isEmpty()) {
			throw ApiException.builder().code(ExceptionCode.NOT_FOUND).build();
		}
		return retrievedObjectEntity.get();
	}

	public ObjectEntity save(ObjectEntity objectEntity) {
		return this.objectEntityRepository.save(objectEntity);
	}
}
