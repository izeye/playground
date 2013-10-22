GRANT ALL PRIVILEGES ON playground.* TO 'playground'@'localhost' IDENTIFIED BY 'playground';

CREATE DATABASE playground CHARACTER SET utf8;

CREATE TABLE tb_access_log (
	id INT AUTO_INCREMENT,
	access_time DATETIME NOT NULL,
	ip VARCHAR(128) NOT NULL,
	url VARCHAR(1024) NOT NULL,
	user_agent VARCHAR(1024) NOT NULL,
	referer VARCHAR(1024),
	PRIMARY KEY (id)
);

ALTER TABLE tb_access_log MODIFY user_agent VARCHAR(1024);

CREATE TABLE tb_qrcode_generation_log (
	id INT AUTO_INCREMENT,
	text VARCHAR(1024) NOT NULL,
	size INT NOT NULL,
	ip VARCHAR(128) NOT NULL,
	generated_time DATETIME NOT NULL,
	PRIMARY KEY (id)
);

CREATE TABLE tb_korean_lotto_log (
	id INT AUTO_INCREMENT,
	numbers VARCHAR(1024) NOT NULL,
	ip VARCHAR(128) NOT NULL,
	generated_time DATETIME NOT NULL,
	PRIMARY KEY (id)
);
RENAME TABLE tb_korean_lotto_log TO tb_korean_lotto_generation_log;

DROP TABLE tb_korean_lotto_winning_log;
CREATE TABLE tb_korean_lotto_winning_log (
	id INT AUTO_INCREMENT,
	sequence INT NOT NULL UNIQUE,
	day DATE NOT NULL UNIQUE,
	numbers VARCHAR(1024) NOT NULL,
	prize1 BIGINT NOT NULL,
	prize2 BIGINT NOT NULL,
	prize3 BIGINT NOT NULL,
	prize4 BIGINT NOT NULL,
	prize5 BIGINT NOT NULL,
	PRIMARY KEY (id)
);

CREATE TABLE tb_whois (
	id INT AUTO_INCREMENT,
	ip VARCHAR(128) NOT NULL UNIQUE,
	whois VARCHAR(2048) NOT NULL,
	created_time DATETIME NOT NULL,
	PRIMARY KEY (id)
);

DROP TABLE tb_users;
CREATE TABLE tb_users (
	id INT NOT NULL AUTO_INCREMENT,
	username VARCHAR(128) NOT NULL UNIQUE,
	password VARCHAR(128) NOT NULL,
	nickname VARCHAR(128) NOT NULL UNIQUE,
	first_name VARCHAR(128),
	last_name VARCHAR(128),
	country_code CHAR(2),
	image_url VARCHAR(128),
	created_time DATETIME NOT NULL,
	modified_time DATETIME,
	deleted_time DATETIME,
	enabled BOOLEAN NOT NULL DEFAULT true,
	PRIMARY KEY(id)
);

-- NOTE: Only for test.
INSERT INTO tb_users (username, password, nickname, created_time) VALUES ('admin@izeye.cafe24.com', '1234', 'admin', now());
INSERT INTO tb_users (username, password, nickname, created_time) VALUES ('izeye@naver.com', '1234', 'izeye', now());
INSERT INTO tb_users (username, password, nickname, created_time) VALUES ('test@naver.com', '1234', 'test', now());

DROP TABLE tb_authorities;
CREATE TABLE tb_authorities (
	id INT NOT NULL AUTO_INCREMENT,
	user_id INT NOT NULL,
	authority VARCHAR(128) NOT NULL,
	CONSTRAINT fk_authorities_users FOREIGN KEY (user_id) REFERENCES tb_users (id),
	PRIMARY KEY(id)
);

-- NOTE: Only for test.
INSERT INTO tb_authorities (user_id, authority) VALUES ((SELECT id FROM tb_users WHERE username='admin@izeye.cafe24.com'), 'ROLE_SUPERVISOR');
INSERT INTO tb_authorities (user_id, authority) VALUES ((SELECT id FROM tb_users WHERE username='izeye@naver.com'), 'ROLE_USER');
INSERT INTO tb_authorities (user_id, authority) VALUES ((SELECT id FROM tb_users WHERE username='test@naver.com'), 'ROLE_USER');

CREATE UNIQUE INDEX ix_auth_user_id on tb_authorities (user_id, authority);

CREATE TABLE tb_mypeople_bot_callback_log (
	id INT AUTO_INCREMENT,
	created_time DATETIME NOT NULL,
	action VARCHAR(128) NOT NULL,
	group_id VARCHAR(128),
	buddy_id VARCHAR(128) NOT NULL,
	content VARCHAR(1024),
	PRIMARY KEY(id)
);

CREATE TABLE tb_menu_item (
	id INT AUTO_INCREMENT,
	name VARCHAR(128) NOT NULL,
	path VARCHAR(128) NOT NULL,
	description VARCHAR(1024) NOT NULL,
	sequence INT NOT NULL,
	PRIMARY KEY (id)
);
INSERT INTO tb_menu_item (name, path, description, sequence) VALUES ('Home', '/', 'This is for the home.', 1);
INSERT INTO tb_menu_item (name, path, description, sequence) VALUES ('Playground', '/playground', 'This is for the playground.', 2);
INSERT INTO tb_menu_item (name, path, description, sequence) VALUES ('Utilities', '/utilities', 'This is for utilities.', 3);
INSERT INTO tb_menu_item (name, path, description, sequence) VALUES ('About', '/about', 'This is about me.', 4);
INSERT INTO tb_menu_item (name, path, description, sequence) VALUES ('Admin', '/admin', 'This is for the administration.', 5);

CREATE TABLE tb_submenu_item_group (
	id INT AUTO_INCREMENT,
	menu_id INT NOT NULL,
	name VARCHAR(128) NOT NULL,
	description VARCHAR(1024) NOT NULL,
	sequence INT NOT NULL,
	PRIMARY KEY (id)
);
INSERT INTO tb_submenu_item_group (menu_id, name, description, sequence) VALUES (2, '?', '?', 1);
INSERT INTO tb_submenu_item_group (menu_id, name, description, sequence) VALUES (3, 'Computer', 'There are utilities for computer.', 1);
INSERT INTO tb_submenu_item_group (menu_id, name, description, sequence) VALUES (3, 'Math', 'There are utilities for mathematics.', 1);
INSERT INTO tb_submenu_item_group (menu_id, name, description, sequence) VALUES (3, 'Life', 'There are utilities for life.', 2);
INSERT INTO tb_submenu_item_group (menu_id, name, description, sequence) VALUES (3, 'Linguistics', 'There are utilities for linguistics.', 1);
# Fill the remainings.

CREATE TABLE tb_submenu_item (
	id INT AUTO_INCREMENT,
	group_id INT,
	name VARCHAR(128) NOT NULL,
	path VARCHAR(128) NOT NULL,
	description VARCHAR(1024) NOT NULL,
	sequence INT NOT NULL,
	PRIMARY KEY (id)
);