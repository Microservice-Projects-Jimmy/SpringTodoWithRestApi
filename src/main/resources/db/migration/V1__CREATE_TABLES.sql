create table hibernate_sequence (
    next_val bigint
) engine=MYISAM;

INSERT INTO hibernate_sequence VALUES (1);
INSERT INTO hibernate_sequence VALUES (1);

CREATE TABLE user (
    id BIGINT NOT NULL AUTO_INCREMENT,
    username VARCHAR(64) NOT NULL UNIQUE,
    password VARCHAR(64) NOT NULL,
    PRIMARY KEY (id)
) engine=MYISAM;

CREATE TABLE todo (
    id BIGINT NOT NULL AUTO_INCREMENT,
    title VARCHAR(64) NOT NULL UNIQUE,
    completed BOOLEAN NOT NULL,
    PRIMARY KEY (id)
) engine=MYISAM;