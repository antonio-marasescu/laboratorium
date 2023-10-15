package stc.laboratoriumapi.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
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
@Table(name = "object_entity")
public class ObjectEntity {
	@Id
	@UuidGenerator(style = UuidGenerator.Style.RANDOM)
	private UUID id;
	private String name;
}
