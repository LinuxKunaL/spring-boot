# Spring & Spring Boot Learning Roadmap (Java/OOP → Production)

A phased, task-based path. Each phase ends with a **build task** — don't move on until you've actually shipped it. Use latest stable Spring Boot 3.x (needs Java 17+).

---

## Phase 0 — Setup & Prerequisites
- [✅] Install JDK 17+ (or 21 LTS), verify `java -version`
- [✅] Install Maven and Gradle; understand the difference (you'll mostly use Maven early on)
- [✅] Set up IntelliJ IDEA (Community is fine) with Spring/Lombok plugins
- [✅] Bookmark [start.spring.io](https://start.spring.io) and generate a throwaway project to see the structure
- [✅] Refresh: generics, lambdas, streams, `Optional`, functional interfaces (Spring leans on all of these)

---

## Phase 1 — Spring Core (the part most people skip and regret)
The whole framework rests on this. Learn it *before* Spring Boot hides it from you.
- [✅] Understand Inversion of Control (IoC) and Dependency Injection (DI) conceptually

- [✅] The `ApplicationContext` / Bean container — what it is and its lifecycle

- [✅] Declare beans 3 ways: `@Component` scanning, `@Bean` in `@Configuration`, and (briefly) XML so you recognize legacy code

- [ ] Constructor vs setter vs field injection — and why constructor injection is preferred

- [ ] `@Autowired`, `@Qualifier`, `@Primary`, `@Value`

- [ ] Bean scopes: singleton vs prototype (and web scopes later)

- [ ] Bean lifecycle hooks: `@PostConstruct`, `@PreDestroy`

- [ ] `@Profile` and environment-specific beans

- [ ] **Build task:** A plain Spring (no Boot) console app wiring 3–4 beans together via constructor injection

---

## Phase 2 — Spring Framework Essentials
- [ ] AOP basics: aspects, advice, pointcuts, `@Aspect` — implement a simple logging or timing aspect
- [ ] `@Transactional` at a high level (you'll go deeper in Phase 5)
- [ ] Spring Expression Language (SpEL) — enough to read it
- [ ] Application events: `ApplicationEventPublisher` + `@EventListener`
- [ ] Externalized configuration concepts (sets up Boot properties)
- [ ] **Build task:** Add an AOP aspect to your Phase 1 app that logs method entry/exit and execution time

---

## Phase 3 — Spring Boot Fundamentals
Now let Boot do the heavy lifting.
- [ ] What auto-configuration actually does (`@SpringBootApplication` decomposed: `@Configuration` + `@EnableAutoConfiguration` + `@ComponentScan`)
- [ ] Starters — what `spring-boot-starter-*` dependencies pull in
- [ ] `application.properties` vs `application.yml`; profiles via `application-{profile}.yml`
- [ ] `@ConfigurationProperties` for type-safe config binding
- [ ] The embedded server (Tomcat) and how to change the port/context path
- [ ] Spring Boot DevTools for hot reload
- [ ] Reading auto-config reports (`--debug` flag, `/actuator/conditions` later)
- [ ] **Build task:** A "Hello API" Boot app with a `/health` endpoint and one configurable property bound via `@ConfigurationProperties`

---

## Phase 4 — Web Layer & REST APIs
- [ ] Spring MVC request flow (DispatcherServlet → controller → response)
- [ ] `@RestController`, `@RequestMapping`, `@GetMapping`/`@PostMapping`/etc.
- [ ] `@PathVariable`, `@RequestParam`, `@RequestBody`, `@ResponseBody`
- [ ] DTOs vs entities — never expose entities directly
- [ ] Bean Validation: `@Valid`, `@NotNull`, `@Size`, custom validators
- [ ] Centralized error handling: `@ControllerAdvice` + `@ExceptionHandler`, consistent error response shape
- [ ] Proper HTTP status codes and `ResponseEntity`
- [ ] Content negotiation (JSON via Jackson), custom serialization
- [ ] API documentation with springdoc-openapi (Swagger UI)
- [ ] **Build task:** A full CRUD REST API for one resource (e.g. `Task` or `Product`) with validation, DTOs, and global error handling — data in-memory for now

---

## Phase 5 — Data Persistence
- [ ] JDBC basics and why Spring abstracts it
- [ ] Spring Data JPA: `@Entity`, `@Id`, `@GeneratedValue`, relationships (`@OneToMany`, `@ManyToOne`, `@ManyToMany`)
- [ ] `JpaRepository` and derived query methods
- [ ] Custom queries with `@Query` (JPQL and native)
- [ ] Pagination and sorting (`Pageable`, `Page`)
- [ ] Transactions: `@Transactional`, propagation, rollback rules, read-only
- [ ] N+1 problem, fetch types (LAZY vs EAGER), `JOIN FETCH`
- [ ] Database migrations with Flyway or Liquibase (do NOT ship `ddl-auto=update`)
- [ ] Connection pooling (HikariCP) basics
- [ ] **Build task:** Wire your CRUD API to a real database (PostgreSQL via Docker), with Flyway migrations and pagination

---

## Phase 6 — Security
- [ ] Spring Security architecture: filter chain, `SecurityFilterChain` bean
- [ ] Authentication vs authorization
- [ ] Password hashing with `BCryptPasswordEncoder`
- [ ] Form login vs stateless API security
- [ ] JWT-based auth: issuing and validating tokens
- [ ] Method-level security: `@PreAuthorize`, roles vs authorities
- [ ] CORS and CSRF — when each matters
- [ ] (Stretch) OAuth2 / OpenID Connect with an external provider
- [ ] **Build task:** Add JWT auth to your API — register/login endpoints, protected routes, role-based access

---

## Phase 7 — Testing
- [ ] Unit tests with JUnit 5 + Mockito (mock the repository, test the service)
- [ ] `@WebMvcTest` for controller slice tests with `MockMvc`
- [ ] `@DataJpaTest` for repository tests
- [ ] `@SpringBootTest` for full integration tests
- [ ] Testcontainers — integration tests against a real DB in Docker
- [ ] Test coverage mindset (cover behavior, not lines)
- [ ] **Build task:** Get meaningful test coverage on your API — at least service unit tests, one controller slice test, and one Testcontainers integration test

---

## Phase 8 — Production Readiness
This is the gap between "works on my machine" and "production-ready."
- [ ] Spring Boot Actuator: health, info, metrics endpoints
- [ ] Exposing/securing actuator endpoints properly
- [ ] Structured logging (Logback config, JSON logs, correlation IDs)
- [ ] Observability: Micrometer metrics → Prometheus, distributed tracing concepts
- [ ] Configuration management: environment variables, profiles, secrets (never commit secrets)
- [ ] Graceful shutdown, readiness vs liveness probes
- [ ] Caching with `@Cacheable` (Caffeine or Redis)
- [ ] Async (`@Async`) and scheduled tasks (`@Scheduled`)
- [ ] Resilience: timeouts, retries, circuit breakers (Resilience4j)
- [ ] Performance: connection pool tuning, query optimization
- [ ] **Build task:** Add actuator, structured logging, metrics, and a caching layer to your API

---

## Phase 9 — Deployment & DevOps
- [ ] Build a runnable JAR; understand the layered fat-JAR
- [ ] Dockerize the app (multi-stage build, jib or buildpacks as alternatives)
- [ ] `docker-compose` for app + database locally
- [ ] Environment-based config in containers
- [ ] CI/CD pipeline (GitHub Actions): build → test → containerize
- [ ] Deploy somewhere real (Railway, Render, Fly.io, or a cloud free tier)
- [ ] (Stretch) Kubernetes basics — deployments, services, config maps
- [ ] **Build task:** Containerize the full app and deploy it publicly with a working CI pipeline

---

## Phase 10 — Capstone Project
- [ ] Pick a non-trivial domain (e.g. expense tracker, booking system, mini e-commerce)
- [ ] Apply *everything*: layered architecture, JWT security, JPA + migrations, validation, global error handling, tests, actuator, Docker, CI/CD, deployment
- [ ] Write a real README (setup, architecture, API docs)
- [ ] (Stretch) Add async messaging with RabbitMQ or Kafka, or split into 2 services
- [ ] **Ship it** and put it on your portfolio/GitHub

---

## Notes
- **Don't skip Phase 1.** Most people jump to Boot and never understand the container underneath — it shows the moment something breaks.
- **Build, don't just read.** Every phase has a build task on purpose. Reading without building doesn't stick.
- **Carry one project through.** The CRUD API from Phase 4 should grow through Phases 5–9 rather than starting fresh each time.
- Suggested pace: ~1–2 weeks per phase part-time, roughly 3–4 months total to production-ready.
