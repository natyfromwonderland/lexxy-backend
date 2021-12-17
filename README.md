<img alt="project logo" src="https://github.com/natyfromwonderland/lexxy-backend/blob/master/cover-01.png">

<br />

  <p align="center">
    Learning app concept created by:
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
  
  <img alt="uml diagram" src="https://github.com/natyfromwonderland/lexxy-backend/blob/master/uml.png">
  
  
  Project Tech
  ===========================
  
  Software used: IntelliJ, VS code, Figma, Adobe Illustrator, MySQL Workbench.
  
  Programmed using Java, SQL, Typescript, HTML and CSS.
  
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

It is recommended to run microservices starting with the discovery-service to avoid disappointment and random errors. Please, consider invalidating cache in IntelliJ if you still encounter errors.

Security
===========================

The project implements auth0 security, which is set up on the front end and all data bearing services. Up to you if you want to verify the password (pretty cool though!)

 <img alt="login page screen" src="https://github.com/natyfromwonderland/lexxy-backend/blob/master/login.png">
 

App Screens
===========================

The look and feel is presented below. 

As this is a learning app, mock content has been created for the demonstration purposes.


 <img alt="welcome page" src="https://github.com/natyfromwonderland/lexxy-backend/blob/master/hero.png">
 
 <img alt="lesson page" src="https://github.com/natyfromwonderland/lexxy-backend/blob/master/lesson.png">
 
 <img alt="shop page" src="https://github.com/natyfromwonderland/lexxy-backend/blob/master/shop.png">
 
Thank you!
===========================


Copyright notice
===========================
 
All illustration in the app including the logo (apart from icons and fonts) is my own illustration and is, therefore, subject to copyright. Whilst feedback and contribution is very welcome, should you wish to use any of the illustrations outside this project, please, contact me to discuss.
