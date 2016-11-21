package ua.org.fits;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
@ComponentScan(basePackages = "ua.org.fits")
public class Application {
    public static void main(String[] args) {

        ApplicationContext ctx = SpringApplication.run(Application.class, args);

    }
}
