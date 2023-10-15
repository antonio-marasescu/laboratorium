package stc.laboratoriumapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import stc.laboratoriumapi.domain.ObjectEntity;

import java.util.List;
import java.util.UUID;

public interface ObjectEntityRepository extends JpaRepository<ObjectEntity, UUID> {
	@Query("SELECT obj FROM ObjectEntity obj WHERE obj.id IN :ids")
	List<ObjectEntity> findByObjectEntityIds(
			List<UUID> ids
	);
}
