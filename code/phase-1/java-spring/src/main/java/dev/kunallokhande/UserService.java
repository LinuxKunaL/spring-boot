package dev.kunallokhande;

import org.springframework.stereotype.Service;

@Service
public class UserService {

    final EmailService emailService;

    public UserService(EmailService emailService) {
        this.emailService = emailService;
    }

}
