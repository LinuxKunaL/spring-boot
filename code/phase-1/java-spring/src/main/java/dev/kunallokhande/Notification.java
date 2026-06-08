package dev.kunallokhande;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Notification {
    
    @Autowired
    private EmailService emailService;

    public void notifiyUser(){
        emailService.send();
    }
}
