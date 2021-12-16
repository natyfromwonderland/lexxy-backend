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
  
  
  Database Setup
  ===========================
  
  create database lexxy;
  
  use lexxy;
  
  CREATE USER 'ironhacker'@'localhost' IDENTIFIED BY '1r0nH@ck3r';

  GRANT ALL PRIVILEGES ON \*.\* TO 'ironhacker'@'localhost';

  FLUSH PRIVILEGES;
