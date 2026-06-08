package dev.kunallokhande;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConfigMethod {
 
    public String mongoDbURL = "db url";

    @Bean
    public String mongoDbUrl (){
        return mongoDbURL;
    }

    
}
