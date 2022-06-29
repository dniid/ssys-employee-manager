# 📱 SSYS Employee Manager App 👨🏻‍💼
<font size="3">**A Simple CRUD API to manage employees**</font> 

Welcome to the SSYS Employee Manager repository.
This document is meant to solve a technical challenge made by SSYS.

## 🔨 Usage

#### Clone
Clone the repository to your desktop.
```
$ git clone https://github.com/dniid/ssys-employee-manager.git
```

### Run
Run the project using maven.
```
$ mvn spring-boot:run
```

### Done!
Now you may access the API with your preferred method (such as [Postman], for example).

## 📞 API Requests

#### Employees CRUD:
* GET: /employees/ (employee list)
* POST: /employees/ (employee create)
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
