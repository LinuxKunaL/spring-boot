# Phase 1 — Spring Core

The whole framework rests on this — IoC, DI, the container, and beans. Learn it
*before* Spring Boot hides it.

## Notes in this phase

1. [01-inversion-of-control.md](01-inversion-of-control.md)
2. [02-dependency-injection.md](02-dependency-injection.md)
3. [03-application-context.md](03-application-context.md)
4. [04-declaring-beans.md](04-declaring-beans.md)
5. [05-constructor-setter-fieldinjection.md](05-constructor-setter-fieldinjection.md)

## Example code

- [`code/phase-1/java-spring`](../../code/phase-1/java-spring)
   - Constructor vs Setter va Field Injection at [Line 11](../../code/phase-1/java-spring/src/main/java/dev/kunallokhande/Main.java#L11).
- [`code/phase-1/declaring-beans`](../../code/phase-1/declaring-beans)
   - Using bean at [Line 6](../../code/phase-1/declaring-beans/src/main/java/dev/kunallokhande/Notification.java#L6).
   - Configuration method at [File](../../code/phase-1/declaring-beans/src/main/java/dev/kunallokhande/ConfigMethod.java).
   - XML Configuration at [XML File](../../code/phase-1/declaring-beans/src/main/resources/beams.xml).

## Checklist

- Understand Inversion of Control (IoC) and Dependency Injection (DI)  

- The `ApplicationContext` / Bean container — what it is and its lifecycle

- Declare beans 3 ways: `@Component` scanning, `@Bean` in `@Configuration`, and (briefly) XML so you recognize legacy code


- Constructor vs setter vs field injection — and why constructor injection is preferred


- `@Autowired`, `@Qualifier`, `@Primary`, `@Value`

- Bean scopes: singleton vs prototype (and web scopes later)
- Bean lifecycle hooks: `@PostConstruct`, `@PreDestroy`
- `@Profile` and environment-specific beans
- **Build task:** A plain Spring (no Boot) console app wiring 3–4 beans together via constructor injection

### Rules 

### Java Package/Folder Naming Rules

```text
1. Use lowercase only ✅
   com.example.blog

2. No spaces ❌
   user management

3. No hyphens ❌
   user-management

4. Prefer single lowercase word ✅
   usermanagement
   paymentservice

5. Follow package structure
   com/example/blog/service

6. Class names use CamelCase
   UserService
   PaymentController
```

**Remember:**
👉 Package/Folder = `lowercase`
👉 Class = `CamelCase`
