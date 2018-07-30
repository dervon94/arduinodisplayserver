package hu.miskolc.uni.iit.arduinodisplayserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@SpringBootApplication
@ComponentScan("hu.miskolc.uni.iit.arduinodisplayserver")
public class ArduinodisplayserverApplication {

    public static void main(final String[] args) {
        SpringApplication.run(ArduinodisplayserverApplication.class, args);
    }
}
