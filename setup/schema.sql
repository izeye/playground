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

CREATE TABLE tb_korean_lotto_winning_log (
	id INT AUTO_INCREMENT,
	sequence INT NOT NULL UNIQUE,
	day DATE NOT NULL UNIQUE,
	numbers VARCHAR(1024) NOT NULL,
	PRIMARY KEY (id)
);

CREATE TABLE tb_whois (
	id INT AUTO_INCREMENT,
	ip VARCHAR(128) NOT NULL UNIQUE,
	whois VARCHAR(2048) NOT NULL,
	created_time DATETIME NOT NULL,
	PRIMARY KEY (id)
);

CREATE TABLE tb_user (
	id INT AUTO_INCREMENT,
	user_id VARCHAR(128) NOT NULL UNIQUE,
	password VARCHAR(128) NOT NULL,
	nickname VARCHAR(128) NOT NULL UNIQUE,
	country_code CAHR(2),
	image_url VARCHAR(128),
	-- Role
	-- 0: Supervisor
	-- 1: User
	role INT DEFAULT 1,
	create_time DATETIME NOT NULL,
	modified_time DATETIME,
	deleted_time DATETIME,
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