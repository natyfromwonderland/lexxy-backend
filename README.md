<img alt="project logo" src="https://github.com/natyfromwonderland/lexxy-backend/blob/master/cover-01.png">

<br />

  <p align="center">
    Learning app created by:
    <br />
    <a href="https://github.com/natyfromwonderland"><strong>Natalia Shilyaeva</strong></a>
    
  </p>
  
  
  Project Requirements
  ===========================
  
  The project will have at least these sections:
  - Include a microservices Java/Spring Boot back-end and an Angular frontend.
  - Include at least 2 SQL database tables.
  - Include at least 4 services plus at least 1 edge service.
  - Include at least 1 GET, POST, PUT/PATCH, and DELETE route.
  - Include adequate and complete documentation.
  
  Project Architecture
  ===========================
  
  The project architecture was originally agreed to be the following, althought it evolved a bit following the evolving complexity:
  
  Front end
  ===========================
  
  Can be found @ https://github.com/natyfromwonderland/lexxy-frontend (please, follow the instructions to start).
  
  
  Database Setup
  ===========================
  
  ```
  create database lexxy;
  
  use lexxy;
  
  CREATE USER 'ironhacker'@'localhost' IDENTIFIED BY '1r0nH@ck3r';

  GRANT ALL PRIVILEGES ON *.* TO 'ironhacker'@'localhost';

  FLUSH PRIVILEGES;
  ```
  
  
  You might also wish to populate the following after running the microservices, so the front end has got some data to play with:
  
  
  ```
 INSERT INTO language ( name) VALUES
('French'),
('Spanish');

INSERT INTO lesson ( lang_id, name, points) VALUES
(1, 'Salut', 5),
(1, 'Vetements', 10),
(1, 'Questions 1', 10);

INSERT INTO learning ( lang_id, pupil_id) VALUES
(1, 2);

INSERT INTO avatar_update_item ( name, price) VALUES
('To infinity and beyond', 10),
('Music lover', 5),
('Simply cute', 5);
```


