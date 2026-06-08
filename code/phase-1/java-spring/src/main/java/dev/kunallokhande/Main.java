package dev.kunallokhande;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext("dev.kunallokhande");
        
        // 1) ————— Send mail via normal direct `bean call`.
        EmailService emailService = applicationContext.getBean(EmailService.class);
        emailService.send();

        // 2) ————— Send mail via `Setter Injection`
        UserService userService = applicationContext.getBean(UserService.class);
        userService.emailService.send();

        // 3) ————— Send mail via `Field Injection`
        Notification notification = applicationContext.getBean(Notification.class);
        notification.notifiyUser();
    }
}