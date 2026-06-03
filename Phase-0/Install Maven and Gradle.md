# Install Maven and Gradle; understand the difference 
### Maven
 Maven is a build automation and dependency/package management tool for java projects.

**build automation means :**

maven can automatically: 
- compile code
- run tests
- run the application

**Dependency Management means**

Maven automatically downloads and manages external libraries required by your project.

Example:
``` xml
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-web</artifactId>
</dependency>
```
Maven downloads Spring Boot and everything it needs.

commands

```bash
mvn clean
mvn compile
mvn test
mvn package
mvn spring-boot:run
```
**pom.xml** is the main Maven configuration file of a Java project.

pom -> Project Object Model

Example : 

```xml 
<project>

    <parent>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-parent</artifactId>
        <version>3.5.0</version>
    </parent>

    <groupId>com.example</groupId>
    <artifactId>demo</artifactId>
    <version>1.0</version>

    <properties>
        <java.version>21</java.version>
    </properties>

    <dependencies>

        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-web</artifactId>
        </dependency>

    </dependencies>

</project>
```



---
### Gradle

Gradle is a build automation and dependency management tool that uses a script-based configuration approach.

it performs the same job as maven.

Example:
```java
dependencies {
    implementation 'org.springframework.boot:spring-boot-starter-web'
}
```
commands:

```bash 
gradle build
gradle test
gradle bootRun
```