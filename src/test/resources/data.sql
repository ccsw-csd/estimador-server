INSERT INTO block (id,name) VALUES (1,'B1');
INSERT INTO block (id,name) VALUES (2,'B2');
INSERT INTO block (id,name) VALUES (3,'B3');

INSERT INTO role (id,name) VALUES (1,'ADMIN');
INSERT INTO role (id,name) VALUES (2,'USER');

INSERT INTO user (id,username,email,first_name,last_name,role) VALUES (1,'USERNAME','USER@USER.COM','NAME','LASTNAME',1);

INSERT INTO customer (id,name) VALUES (1,'CUSTOMER1');

INSERT INTO project (id,name,created,created_by,customer) VALUES (1,'PROJECT1','1970-01-01',1,1);

INSERT INTO estimation (id,created,created_by,est_version,project,total_cost,total_days,last_update,status,showhours) VALUES
(1,'1970-01-01',1,'1.0',1,0.0,0.0,'1970-01-01',1,0);

INSERT INTO estimation_collaborators (id,estimation,collaborator) VALUES (1,1,1);

INSERT INTO profile (id,name) VALUES (1,'P1');

INSERT INTO block_profile (id_block,id_profile) VALUES (1,1);