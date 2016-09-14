CREATE TABLE people (
    person_id BIGINT PRIMARY KEY auto_increment,
    name VARCHAR(32),
    age INT,
);

CREATE TABLE skills (
    skill_id BIGINT PRIMARY KEY auto_increment,
    person_id BIGINT REFERENCES people (person_id),
    name VARCHAR(16),
    level VARCHAR(16)
);

CREATE TABLE parties (
    party_id BIGINT PRIMARY KEY auto_increment,
    location VARCHAR(64),
    party_date TIMESTAMP,
);

CREATE TABLE people_parties (
  person_id BIGINT NOT NULL REFERENCES people (person_id),
  party_id BIGINT NOT NULL REFERENCES parties (party_id),
  PRIMARY KEY (person_id, party_id),
);