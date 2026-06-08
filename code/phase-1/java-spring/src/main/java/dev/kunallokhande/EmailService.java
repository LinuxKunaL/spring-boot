package dev.kunallokhande;

import org.springframework.stereotype.Component;

@Component
public class EmailService {

    public void send(){
        System.out.println("Email Send");
    }
    
}