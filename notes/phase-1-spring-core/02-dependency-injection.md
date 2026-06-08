# Dependency Injection (DI)

**Dependency Injection (DI)** is a technique where an object's dependencies are provided from outside instead of the object creating them itself.

### Without DI

```java
class Car {
    Engine engine = new Engine();
}
```

`Car` creates its own `Engine`.

---

### With DI

```java
class Car {

    private Engine engine;

    public Car(Engine engine) {
        this.engine = engine;
    }
}
```

External code:

```java
Engine engine = new Engine();
Car car = new Car(engine);
```

`Engine` is **injected** into `Car`.
