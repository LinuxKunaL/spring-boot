# Constructor vs Setter vs Field Injection

These are **3 ways to inject dependencies** into a Spring Bean.

Assume:

```java
public class EmailService {
}
```

and `UserService` needs `EmailService`.

---

# 1. Constructor Injection ✅ (Recommended)

Dependency is provided through the constructor.

```java
@Service
public class UserService {

    private final EmailService emailService;

    public UserService(EmailService emailService) {
        this.emailService = emailService;
    }
}
```

Spring does:

```java
EmailService emailService = new EmailService();

UserService userService =
        new UserService(emailService);
```

---

## Advantages

### Required Dependencies Guaranteed

```java
new UserService(null);
```

is immediately obvious as a problem.

The object cannot be properly created without its dependencies.

---

### Supports Immutability

```java
private final EmailService emailService;
```

Dependency cannot change after construction.

---

### Easier Unit Testing

```java
EmailService fake = new FakeEmailService();

UserService userService =
        new UserService(fake);
```

No Spring needed.

---

### Prevents Partially Initialized Objects

Object is fully ready after construction.

---

## Why Preferred?

Because:

```text
Required Dependency
      +
Immutability
      +
Testability
      +
Safer Design
```

---

# 2. Setter Injection

Dependency is provided through a setter method.

```java
@Service
public class UserService {

    private EmailService emailService;

    @Autowired
    public void setEmailService(
            EmailService emailService) {

        this.emailService = emailService;
    }
}
```

Spring:

```java
UserService userService =
        new UserService();

userService.setEmailService(
        emailService);
```

---

## Advantages

Useful for **optional dependencies**.

```java
if (notificationService != null) {
    notificationService.send();
}
```

---

## Disadvantages

Object can exist without dependency.

```java
UserService userService =
        new UserService();
```

At this moment:

```java
emailService == null
```

Possible runtime errors.

---

# 3. Field Injection

Dependency injected directly into field.

```java
@Service
public class UserService {

    @Autowired
    private EmailService emailService;
}
```

Spring injects the value using reflection.

---

## Advantages

Less code.

---

## Disadvantages

### Hidden Dependencies

Looking at constructor:

```java
public UserService() {
}
```

You cannot tell what dependencies are required.

---

### Harder Testing

Without Spring:

```java
UserService service =
        new UserService();
```

`emailService` remains null.

Need reflection or Spring test support.

---

### Cannot Use `final`

```java
private final EmailService emailService;
```

doesn't work with field injection.

---

### Breaks Immutability

Dependencies can be modified.

---

# Comparison

| Feature               | Constructor | Setter    | Field |
| --------------------- | ----------- | --------- | ----- |
| Required Dependencies | ✅           | ❌         | ❌     |
| Supports `final`      | ✅           | ❌         | ❌     |
| Easy Testing          | ✅           | ⚠️        | ❌     |
| Immutability          | ✅           | ❌         | ❌     |
| Optional Dependencies | ❌           | ✅         | ⚠️    |
| Recommended           | ✅           | Sometimes | ❌     |

---

# When to Use What?

### Constructor Injection

Use for **required dependencies**.

```java
@Service
public class UserService {

    private final EmailService emailService;

    public UserService(
            EmailService emailService) {
        this.emailService = emailService;
    }
}
```

**Default choice in modern Spring.**

---

### Setter Injection

Use for **optional dependencies**.

```java
@Autowired
public void setNotificationService(
        NotificationService service) {
}
```

---

### Field Injection

```java
@Autowired
private EmailService emailService;
```

Avoid in production code.

Mostly seen in:

* Old projects
* Tutorials
* Quick demos

---

# Interview Answer

**Why is Constructor Injection preferred?**

1. Makes dependencies mandatory.
2. Supports `final` fields.
3. Creates immutable objects.
4. Easier unit testing.
5. Prevents partially initialized beans.
6. Makes dependencies visible and explicit.

### Memory Trick

```text
Constructor = Required ✅ (Preferred)

Setter = Optional ⚠️

Field = Hidden ❌
```
