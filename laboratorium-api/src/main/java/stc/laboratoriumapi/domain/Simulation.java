package stc.laboratoriumapi.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.UuidGenerator;

import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "simulation")
public class Simulation {
	@Id
	@UuidGenerator(style = UuidGenerator.Style.RANDOM)
	private UUID id;
	private String name;
	private String description;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "world_id", nullable = false)
	private World world;
}
