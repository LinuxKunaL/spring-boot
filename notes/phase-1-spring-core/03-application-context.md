# What is ApplicationContext 
Normally in Java:

```java
UserService userService = new UserService();
```

You create and manage objects yourself.

With Spring:

```java
@Service <-- This can create object
public class UserService {

}
```

Spring creates the object for you and stores it inside a container.

That container is called the **Spring IoC Container**.

The most commonly used implementation of that container is:

```java
ApplicationContext
```

---

### Definition

ApplicationContext is Spring's IoC container that creates, stores, configures, injects, and manages application objects (Beans).

---

# What is a Bean?

A Bean is simply:

> An object created and managed by Spring.

Example:

```java
@Service
public class UserService {
}
```

Spring creates:

```java
UserService userService = new UserService();
```

internally.

This object becomes a Bean.

---

# Responsibilities of ApplicationContext

## 1. Create Beans

Spring scans classes.

```java
@Service
public class UserService {
}
```

Creates:

```java
new UserService();
```

---

## 2. Store Beans

Spring keeps them inside the container.

```text
ApplicationContext
    |
    ├── UserService
    ├── ProductService
    └── OrderService
```

---

## 3. Inject Dependencies

Example:

```java
@Service
public class UserService {

    private final EmailService emailService;

    public UserService(EmailService emailService) {
        this.emailService = emailService;
    }
}
```

Spring automatically:

```java
EmailService emailService = new EmailService();

UserService userService =
        new UserService(emailService);
```

---

## 4. Manage Lifecycle

Spring controls:

* Creation
* Initialization
* Usage
* Destruction

of beans.

---

# Bean Lifecycle

## Step 1: Spring Starts

```java
SpringApplication.run(...)
```

ApplicationContext is created.

```text
Application Starts
        |
        v
ApplicationContext Created
```

---

## Step 2: Bean Instantiation

Spring creates bean objects.

```java
new UserService();
```

```text
Bean Created
```

---

## Step 3: Dependency Injection

Dependencies are injected.

```java
new UserService(emailService);
```

```text
Dependencies Injected
```

---

## Step 4: Initialization

Spring performs initialization.

Example:

```java
@PostConstruct
public void init() {
    System.out.println("Initialized");
}
```

Runs after dependencies are injected.

```text
Bean Initialized
```

---

## Step 5: Bean Ready

Bean is now usable.

```text
Application Running
```

---

## Step 6: Destruction

When application stops:

```java
@PreDestroy
public void cleanup() {
    System.out.println("Cleanup");
}
```

Spring destroys beans.

```text
Bean Destroyed
```

---

# Lifecycle Diagram

```text
Application Starts
        |
        v
ApplicationContext Created
        |
        v
Bean Instantiated
        |
        v
Dependencies Injected
        |
        v
@PostConstruct
        |
        v
Bean Ready
        |
        v
Application Running
        |
        v
@PreDestroy
        |
        v
Bean Destroyed
```

---

# Example

```java
@Service
public class UserService {

    public UserService() {
        System.out.println("Constructor");
    }

    @PostConstruct
    public void init() {
        System.out.println("Init");
    }

    @PreDestroy
    public void destroy() {
        System.out.println("Destroy");
    }
}
```

Output:

```text
Constructor
Init

(Application Running)

Destroy
```

---

# Getting a Bean from ApplicationContext

You can ask Spring:

```java
ApplicationContext context;
```

Give me:

```java
UserService
```

Example:

```java
UserService service =
        context.getBean(UserService.class);
```

Spring returns the managed bean.

---

# Bean Scope (Important)

By default:

```java
@Service
public class UserService {
}
```

Scope:

```text
Singleton
```

Meaning:

```text
One Bean
Entire Application
```
Spring creates it once and reuses it.

