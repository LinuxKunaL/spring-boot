# Declaring Beans in Spring — Complete Notes

## What is a Bean?

A **Bean** is an object created and managed by the Spring IoC Container.

Example:

```java id="lmu0ot"
UserService userService = new UserService();
```

If Spring creates and manages this object →

```text id="5wnk06"
UserService = Bean
```

---

# There are 3 Ways to Declare Beans

```text id="hqikah"
1. @Component Scanning
2. @Bean + @Configuration
3. XML Configuration (Legacy)
```

---

# 1. `@Component` Scanning (Automatic)

Most commonly used in modern Spring Boot.

Spring scans packages and automatically creates beans.

---

## Syntax

```java id="c2q1zd"
@Component
public class EmailService {
}
```

Spring automatically creates:

```java id="n9ifvb"
new EmailService();
```

---

## Example

```java id="ifq85u"
@Component
public class UserService {

    public void register() {
        System.out.println("User Registered");
    }
}
```

Spring:

```text id="7vcizn"
Finds class
      ↓
Creates object
      ↓
Stores as Bean
```

---

## Specialized Component Annotations

These are internally `@Component`.

### Service Layer

```java id="x0e8rd"
@Service
public class UserService {
}
```

---

### Repository Layer

```java id="n2a48s"
@Repository
public class UserRepository {
}
```

---

### Controller Layer

```java id="dklh9w"
@RestController
public class UserController {
}
```

---

### Hierarchy

```text id="96b2mo"
@Component
   |
   ├── @Service
   ├── @Repository
   └── @Controller
```

---

## When to Use

Use when:

* Class belongs to your project
* Simple object creation
* Default choice in Spring Boot

---

## Advantages

✔ Less code
✔ Automatic scanning
✔ Easy maintenance

---

## Example Folder

```text id="6x2mvy"
src
 └── main
     └── java
         └── com/example
              └── service
                   └── UserService.java
```

---

# 2. `@Bean` + `@Configuration` (Manual)

Used when you want to manually tell Spring how to create an object.

---

## Syntax

```java id="c7vbbm"
@Configuration
public class AppConfig {

    @Bean
    public EmailService emailService() {
        return new EmailService();
    }
}
```

Spring executes:

```java id="jzc0b8"
emailService();
```

Returned object becomes Bean.

---

## Example

Class:

```java id="j1gy3l"
public class PaymentGateway {
}
```

Configuration:

```java id="dpm7vz"
@Configuration
public class AppConfig {

    @Bean
    public PaymentGateway paymentGateway() {
        return new PaymentGateway();
    }
}
```

Spring creates:

```java id="4l2mha"
new PaymentGateway();
```

---

## Bean Name

Method name becomes Bean name.

```java id="d0wjfe"
@Bean
public PaymentGateway paymentGateway()
```

Bean name:

```text id="svl8aj"
paymentGateway
```

---

## When to Use

Use when:

* Third-party library classes
* Cannot modify class
* Custom initialization needed
* Complex object creation

---

## Advantages

✔ Full control
✔ Configure object creation
✔ Works with external libraries

---

## Example Folder

```text id="s7mj2w"
src
 └── main
     └── java
          └── config
               └── AppConfig.java
```

---

# 3. XML Configuration (Legacy)

Older Spring applications declared beans in XML files.

Spring reads XML and creates objects.

---

## File Location

Usually:

```text id="gk8qlj"
src/main/resources/
```

Example:

```text id="1rpn5e"
src
 └── main
     └── resources
          └── applicationContext.xml
```

---

## Syntax

```xml id="eh3ntj"
<beans>

    <bean id="emailService"
          class="com.example.EmailService"/>

</beans>
```

Spring creates:

```java id="vgsb9c"
new EmailService();
```

---

## Dependency Injection in XML

```xml id="x8y74z"
<bean id="emailService"
      class="com.example.EmailService"/>

<bean id="userService"
      class="com.example.UserService">

    <constructor-arg ref="emailService"/>

</bean>
```

Equivalent Java:

```java id="1i7drg"
new UserService(emailService);
```

---

## Loading XML

```java id="4r0wjx"
ApplicationContext context =
new ClassPathXmlApplicationContext(
        "applicationContext.xml"
);
```

---

## When to Use

Use only:

* Reading old projects
* Maintaining legacy applications

Rare in modern Spring Boot.

---

## Advantages

✔ Centralized configuration
✔ No annotations required

---

## Disadvantages

✘ Verbose
✘ Hard maintenance
✘ Mostly outdated

---

# Comparison

| Feature             | `@Component` | `@Bean`      | XML      |
| ------------------- | ------------ | ------------ | -------- |
| Style               | Automatic    | Manual       | XML      |
| Location            | Class        | Config Class | XML File |
| Common Today        | ✅ Most       | ✅ Common     | ❌ Rare   |
| Third-party Support | ❌            | ✅            | ✅        |
| Custom Creation     | ❌            | ✅            | ✅        |

---

# Internal Working

### `@Component`

```text id="y4vc6u"
Spring scans class
       ↓
Creates object
       ↓
Stores Bean
```

---

### `@Bean`

```text id="scwqki"
Spring calls method
       ↓
Method returns object
       ↓
Stores Bean
```

---

### XML

```text id="ahh70k"
Spring reads XML
       ↓
Creates object
       ↓
Stores Bean
```

---

# Memory Trick

```text id="ic0c0v"
@Component → Spring finds class

@Bean → Spring calls method

XML → Spring reads file
```

---

# Interview Summary

### `@Component`

```java id="7fcr1o"
@Service
public class UserService {
}
```

Automatic bean registration.

---

### `@Bean`

```java id="jy2exb"
@Bean
public UserService userService()
```

Manual bean registration.

---

### XML

```xml id="9lzqyy"
<bean id="userService"/>
```

Legacy bean registration.
