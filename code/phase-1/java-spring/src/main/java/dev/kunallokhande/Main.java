package dev.kunallokhande;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext("dev.kunallokhande");
        
        EmailService emailService = applicationContext.getBean(EmailService.class);

        emailService.send();
    }
}