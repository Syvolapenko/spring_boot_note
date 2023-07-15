  CREATE TABLE users (
    id int PRIMARY KEY AUTO_INCREMENT,
    username varchar(45) NOT NULL,
    password varchar(64) NOT NULL
  );

  INSERT INTO users
  (username,password)
  VALUES
  ('max','$2a$12$Iu/Pc9c8noEyK2eIBgTJA.qGFkr9.Wgbx7GPngfGI/OcVWq/TljKu'),
  ('natali','$2a$12$0s1k5xQGOEOw0ftjltMcn.u75G743yzjvIJS71OsSFKPWYSiPGiaO');