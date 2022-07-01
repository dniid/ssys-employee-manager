# 📱 SSYS Employee Manager App 👨🏻‍💼
<font size="3">**A Simple CRUD API to manage employees**</font> 

Welcome to the SSYS Employee Manager repository.  
This project is meant to solve a technical challenge made by SSYS.

## 🔨 Usage

### 1. Using [Maven]

#### Clone
Clone the repository to your desktop.
```
$ git clone https://github.com/dniid/ssys-employee-manager.git
```

#### Run
Run the springboot project through *mvn run*.
```
$ mvn spring-boot:run
```
#### Done!
Now you may access the API with your preferred method (such as [Postman], for example).

<br><br>
### 2. Using [Docker]

#### Clone
Clone the repository to your desktop.
```
$ git clone https://github.com/dniid/ssys-employee-manager.git
```

#### Dockerize
Through Docker compose, build the mysql and springboot containers.
```
$ docker-compose up
```

#### Done!
Now you may access the API with your preferred method (such as [Postman], for example).

<br><br><br>
<font size="4">**Obs:** To get access to the API requests you need to specify the authorization token "AUTH_API_KEY" as "ssys" in the header. </font>
<br>
*Authorization Key demonstration in Postman*
<br>
![Authorization Key demonstration in Postman](https://cdn.discordapp.com/attachments/531312380559491075/992211499290464346/unknown.png "Authorization Key demonstration in Postman")
<br>
## 📞 API Requests

#### Employees CRUD:
* GET /employees/ (employee list)
* POST /employees/ (employee create)
* UPDATE /employees/ID/ (employee update)
* DELETE /employees/ID/ (employee delete)
* GET /employees/ID/ (employee detail)

#### Reports:
* GET /reports/employees/salary/ (salary report)
* GET /reports/employees/age/ (age report)

## 🧰 Tools

* [IntelliJ IDEA]
* [Spring Boot]
* [Spring Initializr]
* [Maven]
* [Postman]
* [Docker Desktop]

## 🛠 Dependencies

* [Spring Web]
* [Spring Data JPA]
* [MySQL Database]
* [Lombok]
* [Spring Security]

[IntelliJ IDEA]: https://www.jetbrains.com/idea/
[Spring Boot]: https://spring.io/projects/spring-boot
[Spring Initializr]: https://start.spring.io
[Maven]: https://maven.apache.org
[Postman]: https://www.postman.com
[Spring Web]: https://spring.io/projects/spring-ws
[Spring Data JPA]: https://spring.io/projects/spring-data-jpa
[MySQL Database]: https://www.mysql.com
[Lombok]: https://projectlombok.org
[Spring Security]: https://spring.io/projects/spring-security
[Docker Desktop]: https://www.docker.com/products/docker-desktop/
[Docker]: https://www.docker.com
