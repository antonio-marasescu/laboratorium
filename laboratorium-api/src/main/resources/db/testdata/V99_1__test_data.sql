INSERT INTO world (id, name, description)
VALUES ('5aeb298b-0d5e-4f0a-8db1-af0d91a2a846', 'World One', 'The first world'),
       ('bb1b02e1-c8d3-48ac-9b99-55c6cc815fe3', 'World Primitiva', 'A primitive world');


INSERT INTO object_entity (id, name)
VALUES ('356f8f63-37ef-432a-aa1e-878fa32ad9b3', 'Asset 01'),
       ('3b7c2ad6-19e5-4d4e-849e-e7a24a3e9a3e', 'Asset 02'),
       ('3b4c5d6e-7f8a9b0c-1d2e3f4a-5d6e7f8a', 'Asset 03'),
       ('4c5d6e7f-8a9b0c1d-2e3f4a5d-6e7f8a9b', 'Asset 04'),
       ('5d6e7f8a-9b0c1d2e-3f4a5d6e-7f8a9b0c', 'Asset 05');

INSERT INTO object_entity_world (object_entity_id, world_id)
VALUES ('356f8f63-37ef-432a-aa1e-878fa32ad9b3', '5aeb298b-0d5e-4f0a-8db1-af0d91a2a846'),
       ('3b7c2ad6-19e5-4d4e-849e-e7a24a3e9a3e', '5aeb298b-0d5e-4f0a-8db1-af0d91a2a846'),
       ('3b4c5d6e-7f8a9b0c-1d2e3f4a-5d6e7f8a', 'bb1b02e1-c8d3-48ac-9b99-55c6cc815fe3'),
       ('4c5d6e7f-8a9b0c1d-2e3f4a5d-6e7f8a9b', 'bb1b02e1-c8d3-48ac-9b99-55c6cc815fe3'),
       ('5d6e7f8a-9b0c1d2e-3f4a5d6e-7f8a9b0c', 'bb1b02e1-c8d3-48ac-9b99-55c6cc815fe3');

INSERT INTO simulation (id, name, description, world_id)
VALUES ('a6be104c-5139-11ee-be56-0242ac120002', 'Simulation A', 'A test simulation for World One', '5aeb298b-0d5e-4f0a-8db1-af0d91a2a846'),
	   ('a859bfa2-5a0c-4101-93a1-bc0d6b99772c', 'Simulation B', 'A test simulation for World Primitiva', 'bb1b02e1-c8d3-48ac-9b99-55c6cc815fe3');
