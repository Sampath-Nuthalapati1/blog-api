
# Blog API

An application used to expose protected enpoints and allows users to post, edit, save and view their blog posts, built with Java, Spring Boot, Maven, Spring Security, Spring Data JPA (Hibernate), and MySQL.

## Tech Stack

[![Tech_Stack](https://skillicons.dev/icons?i=java,spring,maven,hibernate,mysql,postman,git,github&theme=light)](https://skillicons.dev)

## Installation and Setup Instructions

Clone down this repository. You will need `jdk` installed globally on your machine along with an IDE (STS or intelliJ IDEA) and MySQL Workbench installed.

Make sure to update your application.properties with the schema and credentials from your MySQL.
##### application.properties
```
spring.datasource.url=jdbc:mysql://localhost:3306/<schema_name>
spring.datasource.username=
spring.datasource.password=
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQL8Dialect
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
```

Run the application

After the build is successful, make sure the tables are generated in the MySQL Workbench.

Then to visit the App:

`localhost:8080/`  

Then to visit Swagger UI:

`localhost:8080//swagger-ui/index.html`  
