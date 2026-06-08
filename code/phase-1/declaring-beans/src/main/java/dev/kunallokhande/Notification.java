package dev.kunallokhande;

import org.springframework.stereotype.Component;

// this method is component scanning.
@Component
public class Notification {
    
    public void send(){
        System.out.println("hey you got new notification");
    }

}
