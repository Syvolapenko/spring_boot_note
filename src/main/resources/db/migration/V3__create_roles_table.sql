CREATE TABLE roles (
  id int PRIMARY KEY AUTO_INCREMENT,
  name varchar(45) NOT NULL
);

INSERT INTO roles
(name)
VALUES
('USER'),
('ADMIN');