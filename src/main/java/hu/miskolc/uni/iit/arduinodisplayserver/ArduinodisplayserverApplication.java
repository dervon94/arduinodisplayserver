package hu.miskolc.uni.iit.arduinodisplayserver;


import hu.miskolc.uni.iit.arduinodisplayserver.DAO.Imp.MeasurementSpringDataDAO;
import hu.miskolc.uni.iit.arduinodisplayserver.DAO.MeasurementDAO;
import hu.miskolc.uni.iit.arduinodisplayserver.service.DisplayService;
import hu.miskolc.uni.iit.arduinodisplayserver.service.Impl.DisplayServiceImplementation;
import org.springframework.beans.factory.annotation.Autowire;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;


@Configuration
@SpringBootApplication
@ComponentScan("hu.miskolc.uni.iit.arduinodisplayserver")
@EntityScan(basePackages = "hu.miskolc.uni.iit.model")
public class ArduinodisplayserverApplication {

    public static void main(final String[] args) {
        SpringApplication.run(ArduinodisplayserverApplication.class, args);
    }

    @Bean(autowire = Autowire.BY_NAME)
    public MeasurementDAO measurementDAO() {
        return new MeasurementSpringDataDAO();
    }

    @Bean(autowire = Autowire.BY_NAME)
    public DisplayService displayService() {
        return new DisplayServiceImplementation();
    }


}
