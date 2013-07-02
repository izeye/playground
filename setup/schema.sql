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