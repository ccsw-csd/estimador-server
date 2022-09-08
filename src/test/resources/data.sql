

CREATE TABLE block (
	id INT NOT NULL AUTO_INCREMENT,
	name VARCHAR(100) NOT NULL,
	PRIMARY KEY (ID)
);



CREATE TABLE user (
	id INT NOT NULL AUTO_INCREMENT,
	username VARCHAR(100) NOT NULL UNIQUE,
	email VARCHAR(100) NOT NULL UNIQUE,
	first_name VARCHAR(100),
	last_name VARCHAR(100),
	PRIMARY KEY (id)
);


CREATE TABLE customer (
	id INT NOT NULL AUTO_INCREMENT,
	name VARCHAR(100) NOT NULL,
	PRIMARY KEY (ID)
);


CREATE TABLE project (
	id INT NOT NULL AUTO_INCREMENT,
	name VARCHAR(100) NOT NULL,
	created DATE NOT NULL,
	created_by INT,
	customer INT,
	PRIMARY KEY (ID)
);


CREATE TABLE estimation (
	id INT NOT NULL AUTO_INCREMENT,
	created DATE NOT NULL,
	created_by INT NOT NULL,
	est_version VARCHAR(100) NOT NULL,
	project INT NOT NULL,
	total_cost DECIMAL(10,2) DEFAULT 0,
	total_days DECIMAL(10,2) DEFAULT 0,
	last_update DATE,
	status INT NOT NULL DEFAULT 0,
	showHours TINYINT DEFAULT 1,
	PRIMARY KEY (ID)
);


INSERT INTO block (id,name) VALUES (1,'B1');
INSERT INTO block (id,name) VALUES (2,'B2');
INSERT INTO block (id,name) VALUES (3,'B3');

INSERT INTO user (id,username,email,first_name,last_name) VALUES (1,'USERNAME','USER@USER.COM','NAME','LASTNAME');

INSERT INTO customer (id,name) VALUES (1,'CUSTOMER1');

INSERT INTO project (id,name,created,created_by,customer) VALUES (1,'PROJECT1','1970-01-01',1,1);

INSERT INTO estimation (id,created,created_by,est_version,project,total_cost,total_days,last_update,status,showhours) VALUES
(1,'1970-01-01',1,'1.0',1,0.0,0.0,'1970-01-01',1,0);

INSERT INTO estimation_collaborators (id,estimation,collaborator) VALUES (1,1,1);

INSERT INTO profile (id,name) VALUES (1,'P1');

INSERT INTO block_profile (id_block,id_profile) VALUES (1,1);