package stc.laboratoriumapi.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.UuidGenerator;

import java.util.List;
import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "world")
public class World {
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "object_entity_world", joinColumns = @JoinColumn(name = "world_id"), inverseJoinColumns =
	@JoinColumn(name = "object_entity_id"))
	List<ObjectEntity> objectEntities;
	@Id
	@UuidGenerator(style = UuidGenerator.Style.RANDOM)
	private UUID id;
	private String name;
	private String description;

}
