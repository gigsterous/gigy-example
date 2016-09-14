INSERT INTO people (person_id, name, age) VALUES 
	(1, 'Peter', 25),
	(2, 'John', 30),
	(3, 'Katie', 18);
	
INSERT INTO skills (skill_id, person_id, name, level) VALUES
	(1, 1, 'Juggling', 'GOOD'),
	(2, 1, 'Dancing', 'AWESOME'),
	(3, 2, 'Juggling', 'AWESOME'),
	(4, 2, 'Story-telling', 'GODLIKE'),
	(5, 3, 'Singing', 'GOOD');

INSERT INTO parties (party_id, location, party_date) VALUES 
	(1, 'Old Folks Club', '2016-09-20'),
	(2, 'Luxury Yacht Party', '2016-12-05');
	
INSERT INTO people_parties (person_id, party_id) VALUES
	(1, 1),
	(1, 2),
	(2, 1),
	(3, 2);
	