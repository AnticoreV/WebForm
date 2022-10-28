--CREATE DATABASE webform;
--
--CREATE TABLE users(
--  id INT PRIMARY KEY AUTO_INCREMENT,
--  policy_number VARCHAR(255) NOT NULL,
--  name VARCHAR(127) NOT NULL,
--  surname VARCHAR(127) NOT NULL
--);
--
--CREATE TABLE requests(
--  id INT PRIMARY KEY,
--  user_id INT,
--  data VARCHAR(5000)
--);

DROP TABLE users;
DROP TABLE requests;

SELECT * FROM users;
SELECT * FROM requests;

ALTER TABLE requests ADD FOREIGN KEY (user_id) REFERENCES users(id);