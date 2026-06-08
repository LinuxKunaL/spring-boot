package dev.kunallokhande;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {

        ApplicationContext applicationContext = new AnnotationConfigApplicationContext("dev.kunallokhande");

        // 1) ————— using bean you don't have to create new object, it is done by IoC container.
        Notification notification = applicationContext.getBean(Notification.class);
        notification.send();

        // 2) ————— this bean call by `configuration method`.
        ConfigMethod appConfig = applicationContext.getBean(ConfigMethod.class);
        System.out.println(appConfig.mongoDbURL);
        System.out.println(appConfig.mongoDbUrl());

        // 3) ————— this method is called `XML Configuration`
        ApplicationContext applicationContextViaXML = new ClassPathXmlApplicationContext("beans.xml");
        EmailService emailService = applicationContextViaXML.getBean(EmailService.class);
        emailService.send();

    }
}