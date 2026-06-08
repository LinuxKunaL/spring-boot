package dev.kunallokhande;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext("dev.kunallokhande");
        
        Car car = applicationContext.getBean(Car.class);

        car.drive();
    }
}