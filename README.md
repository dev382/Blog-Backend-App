# Blog App Backend

Backend of a blog application built with Java and the Spring Boot framework and deployed on AWS connected to a MySQL database. This app has full CRUD capabilities, allowing users to create blog posts and comment on blog posts created by other users. The app allows administrators to assign roles to users which will give them different capabilities within the application depending on their role. 

## Images

> #### Blog App

![blogapp](https://user-images.githubusercontent.com/75185644/143805035-03e16fc8-0dcf-4ca8-97ac-6dc8d0b5283f.PNG)

> #### Postman GET Request 

![postman-get all posts req](https://user-images.githubusercontent.com/75185644/143805039-4cd4f5f9-8caf-4b01-aa61-8646c1824e72.PNG)

> #### MySQL Database

![mysql-users](https://user-images.githubusercontent.com/75185644/143805046-3cf111f6-3378-4aaa-806f-6ac7959943d8.PNG)

> #### API Endpoints Generated by Swagger UI

![swaggerui endpoints 1](https://user-images.githubusercontent.com/75185644/143805067-176fb23b-14a6-48d7-9e68-26f885b8c681.PNG)

![swaggerui endpoints 2](https://user-images.githubusercontent.com/75185644/143805076-81231712-71bf-4481-b716-07d0d4dc156f.PNG)

> #### AWS Deployment and RDS Database

![EBS](https://user-images.githubusercontent.com/75185644/143964242-6bcbede3-2535-4b1b-a641-baddb7abeee4.PNG)

![RDS](https://user-images.githubusercontent.com/75185644/143964232-0d932d19-312e-4ced-b1a9-7423a8f3ab2e.PNG)

## Functionalities

- Users who are not authenticated have access to the registration and login routes. They also have access to the posts and comments routes, where they can view blog posts and comments created by registered users.

- Users will also have pagination and sorting capabilities in the posts route, where they are able to choose the number of posts per page, the page number, a category to sort by, and whether they want to sort in descending or ascending order.

- The app will allow the application's administrators to assign either a role of 'USER' or 'ADMIN' to all registered users. 

- In addition to having access to all the routes that non-authenticated users have access to, authenticated users with an 'USER' role will have the ability to create, update or delete comments but will not be able to create, update or delete  posts. 

- In addition to having all the capabilities of authenticated users, users with an 'ADMIN' role will also be able to create, update and delete posts.

## Technologies Used

### Backend

- Java
- Spring Boot Framework
- Spring Data JPA (Hibernate)
- Spring MVC
- Spring Security
- MySQL Database
- Apache Tomcat
- Amazon Web Services (AWS)
- JWT (JSON Web Token)
- IntelliJ IDEA
- Postman (API Testing)
- Swagger UI (API Documentation)
- Maven (Build Tool)

## Getting Started

This Spring Boot application contains secret keys, database urls, and passwords stored within the 'application.properties' file which has been hidden by .gitignore for security purposes, so the app cannot be run with all of its features on your local machine without this file and variables. However, feel free to clone this repository, and configure your 'application.properties' file with the following settings and your own secrets, database urls and passwords:

```
logging.level.org.springframework.security = DEBUG

# JWT properties
app.jwt-secret = ""
app.jwt-expiration-milliseconds = 604800000

# Change MVC's path matching strategy from the default 'PathPattern-based matching' to 'Ant-based-path matching'
# This will allow the 'springfox-boot-starter' dependency to work correctly with Spring Boot 2.6.0
spring.mvc.pathmatch.matching-strategy = ant_path_matcher

# Database credentials
spring.datasource.url = ""
spring.datasource.username = ""
spring.datasource.password = ""

# Hibernate properties
spring.jpa.properties.hibernate.dialect = org.hibernate.dialect.MySQL5InnoDBDialect

# Hibernate ddl auto (create, create-drop, validate, update)
spring.jpa.hibernate.ddl-auto = update

```

### Clone or download this repository

```sh
git clone https://github.com/dev382/Blog-App-Backend.git
```

### Dependencies

Dependencies can be found in the pom.xml file and will be downloaded and installed by IntelliJ IDEA. You may choose any IDE with support for the Spring Boot Framework.


### Run the app from your IDE

-Before running the app for the first time, go to the main java class called 'SpringbootBlogRestApiApplication' and follow the steps described in the comments.

-Within IntelliJ IDEA make sure 'SpringbootBlogRestApiApplication' is selected and click 'Run'. This may work differently with other IDEs.


### View and test the API endpoints with Swagger UI

-To view all the API endpoints navigate to 'http://localhost:8080/swagger-ui/#/'.

-Go to the 'signup' endpoint and register a new user. 

-By default all users are registered with a role of 'USER'. To be able to use the POST, PUT, and DELETE endpoints for the posts' controller, you will need to register a user with the role 'ADMIN'. To do this, open the java class called 'AuthController', look for the method called 'registeredUser' and change the parameter of the 'findByName' method within the variable called 'roles' from "ROLE_USER" to "ROLE_ADMIN".

-After registering a user, use the signin endpoint to log in and copy the JWT token from the body of the response.

-To be able to use the POST, PUT, and DELETE endpoints you will also need to click the lock or 'Authorize' button within Swagger UI and enter the JWT token you received after signing in. The token has to be entered in the following format:

'Bearer token'

For example: 

If your token = 'xyxyxyxyxyx', then enter 'Bearer xyxyxyxyxyx' without the quotes

-You should now have full CRUD capabilities when using an 'ADMIN' token.




