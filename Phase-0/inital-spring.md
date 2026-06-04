# Spring Basics

## What is Spring?

Spring is a Java framework used to build enterprise applications.

Main goals:

- Reduce boilerplate code
- Manage objects automatically
- Support Dependency Injection (DI)
- Build web applications easily

---

## How to start ?

- select the spring package from [mvnrepository](https://mvnrepository.com/search?q=spring)
- type : core, context, bean, web, and more
- add this in your `pom.xml`
- Dependency Code :

  ```xml
  <dependency>
      <groupId>org.springframework</groupId>
      <artifactId>spring-context</artifactId>
      <version>7.0.7</version>
      <scope>compile</scope>
  </dependency>
  ```
 - Download Dependencies & Compile : `mvn clean compile`
 - For run the project : `java -cp target/classes com.example.Main`
    - but you can add maven exce plugin for compile and run in **one go**.
    ```xml
    <plugin>
        <groupId>org.codehaus.mojo</groupId>
        <artifactId>exec-maven-plugin<artifactId>
        <version>3.5.0</version>
        <configuration>
            <mainClass>com.example.Main</mainClass>
        </configuration>
    </plugin>
    ```
    - then run `mvn exec:java`


## Basic syntax 
- Define the Main method path : `dev.kunallokhande.Main`
- Create Applicaion Context
    ```xml
    AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext("dev.kunallokhande");
    ```
- Run Application 
    - Compile: `mvn clean compile`
    - Run: `mvn exec:java -Dexec.mainClass="dev.kunallokhande.Main"`
