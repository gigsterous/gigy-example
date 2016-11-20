DROP TABLE IF EXISTS users;
CREATE TABLE users (
    user_id BIGINT PRIMARY KEY auto_increment,
    username VARCHAR(128) UNIQUE,
    password VARCHAR(256),
    enabled BOOL,
);

DROP TABLE IF EXISTS people;
CREATE TABLE people (
    person_id BIGINT PRIMARY KEY auto_increment,
    name VARCHAR(32),
    username VARCHAR(128) UNIQUE REFERENCES users (username),
    age INT,
);

DROP TABLE IF EXISTS skills;
CREATE TABLE skills (
    skill_id BIGINT PRIMARY KEY auto_increment,
    person_id BIGINT REFERENCES people (person_id),
    name VARCHAR(16),
    level VARCHAR(16)
);

DROP TABLE IF EXISTS parties;
CREATE TABLE parties (
    party_id BIGINT PRIMARY KEY auto_increment,
    location VARCHAR(64),
    party_date TIMESTAMP,
);

DROP TABLE IF EXISTS people_parties;
CREATE TABLE people_parties (
  person_id BIGINT NOT NULL REFERENCES people (person_id),
  party_id BIGINT NOT NULL REFERENCES parties (party_id),
  PRIMARY KEY (person_id, party_id),
);