package uk.gov.justice.digital.hmpps.dps;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;

@SpringBootApplication
@ConfigurationProperties(prefix = "dps")
public class DpsWelcomeApplication {

    public static void main(final String[] args) {
        SpringApplication.run(DpsWelcomeApplication.class, args);
    }
}
