package hr.ivlahek.learning.dbunit;

import hr.ivlahek.learning.dbunit.persistance.PersistenceConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;

/**
 * @author ivlahek
 */

@Import(value = {PersistenceConfig.class})
@ComponentScan
@EnableAutoConfiguration
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);

    }

}
