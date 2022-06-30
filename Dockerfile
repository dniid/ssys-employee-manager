FROM openjdk:11

ADD target/employeemgmt-0.0.1-SNAPSHOT.jar employeemgmt-0.0.1-SNAPSHOT.jar

EXPOSE 8000

ENTRYPOINT ["java", "-jar", "employeemgmt-0.0.1-SNAPSHOT.jar"]