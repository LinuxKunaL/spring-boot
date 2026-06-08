# Spring Core Terms

> Intro to Spring and how to start a project lives in [01-what-is-spring.md](01-what-is-spring.md).

## Bean

A Bean is an object created and managed by Spring.

Example:

```java
@Service
public class UserService {
}
```

`UserService` becomes a Spring Bean.

---

## Dependency Injection (DI)

DI means Spring automatically provides required objects (dependencies) to another object.

Example:

```java
@Service
public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }
}
```

Spring injects `UserService` into `UserController`.

---

## ApplicationContext

ApplicationContext is the Spring Container.

Responsibilities:
- Create Beans
- Store Beans
- Inject Dependencies
- Manage Bean Lifecycle

Example:

```java
ApplicationContext context =
    new AnnotationConfigApplicationContext(AppConfig.class);
```

Getting a Bean:

```java
UserService service =
    context.getBean(UserService.class);
```

---

## Relationship

```text
ApplicationContext
       │
       ▼
 Creates Beans
       │
       ▼
 Performs DI
       │
       ▼
 Manages Application
```

---

## Spring Modules

### Spring Core
- Provides IoC and DI foundation.

### Spring Beans
- Creates and manages Beans.

### Spring Context
- Provides ApplicationContext.
- Advanced Bean management.

### Spring Web
- Provides HTTP and Web support.

### Spring MVC
- Provides Controllers, Routing, REST APIs.

---

## Quick Summary

Bean = Object managed by Spring

DI = Process of injecting dependencies

ApplicationContext = Container that manages Beans and DI

Spring MVC = Web framework built on Spring