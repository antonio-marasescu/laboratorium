package stc.laboratoriumapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import stc.laboratoriumapi.domain.World;

import java.util.UUID;

public interface WorldRepository extends JpaRepository<World, UUID> {
}
