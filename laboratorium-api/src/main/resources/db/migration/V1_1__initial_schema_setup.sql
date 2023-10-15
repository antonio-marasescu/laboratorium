CREATE TABLE world (
    id UUID PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    description VARCHAR(1025)
);

CREATE TABLE object_entity (
    id UUID PRIMARY KEY,
    name VARCHAR(255) NOT NULL
);

CREATE TABLE object_entity_world (
    object_entity_id UUID,
    world_id UUID,
    PRIMARY KEY (object_entity_id, world_id),
    CONSTRAINT fk_object_entity_world_to_object_entity FOREIGN KEY (object_entity_id) REFERENCES object_entity (id),
    CONSTRAINT fk_object_entity_world_to_world FOREIGN KEY (world_id) REFERENCES world (id)
);

CREATE TABLE simulation (
    id UUID PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    description VARCHAR(1025),
    world_id UUID,
    CONSTRAINT fk_simulation_to_world FOREIGN KEY (world_id) REFERENCES world (id)
)

