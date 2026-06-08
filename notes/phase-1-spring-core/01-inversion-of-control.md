# Inversion of Control

Inversion of Control (IoC) is a design principle where the creation and management of objects is delegated to an external container instead of being handled by the objects themselves.

---
### Traditional Approach

The class controls everything itself.

```java
public class UserController {

    private EmailService emailService = new EmailService();

    public void registerUser() {
        emailService.sendEmail("Welcome");
    }
}
```

Here:

* `UserController` creates `EmailService`
* `UserController` decides which implementation to use
* `UserController` manages dependency lifecycle

The class is in control.

---

## Problem with Traditional Approach

### Tight Coupling

```java
private EmailService emailService = new EmailService();
```

`UserController` is directly dependent on `EmailService`.

If the implementation changes:

```java
EmailService → SmsService
```

the code must be modified.

---

### Difficult Testing

Suppose:

```java
EmailService
```

sends real emails.

During testing, you may want:

```java
FakeEmailService
```

or

```java
MockEmailService
```

But because the dependency is created internally:

```java
new EmailService();
```

it cannot be easily replaced.

---

## Core Idea of IoC

Instead of creating dependencies inside a class:

```java
new Dependency();
```

the dependency is provided from outside.

The class only uses the dependency.

---

## Example

### Step 1: Create an Abstraction

```java
public interface MessageService {
    void send(String message);
}
```

---

### Step 2: Create Implementation

```java
public class EmailService implements MessageService {

    @Override
    public void send(String message) {
        System.out.println("Email: " + message);
    }
}
```

---

### Step 3: Receive Dependency

```java
public class UserController {

    private MessageService messageService;

    public UserController(MessageService messageService) {
        this.messageService = messageService;
    }

    public void registerUser() {
        messageService.send("Welcome");
    }
}
```

Notice:

```java
new EmailService();
```

does not exist inside `UserController`.

---

### Step 4: External Code Creates Objects

```java
MessageService service = new EmailService();

UserController controller =
        new UserController(service);
```

Now:

* Dependency creation happens outside
* Dependency management happens outside
* `UserController` only uses the dependency

This is IoC.

---

# Why the Name "Inversion of Control"?

## Before IoC

```text
UserController
      |
      └── creates EmailService
```

The class controls dependency creation.

---

## After IoC

```text
External Code
      |
      ├── creates EmailService
      |
      └── provides EmailService
              |
              v
       UserController
```

Control has been moved away from the class.

The direction of control is inverted.

Hence:

**Inversion of Control**
