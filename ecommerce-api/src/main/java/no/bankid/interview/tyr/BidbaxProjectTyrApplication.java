package no.bankid.interview.tyr;

import org.springframework.core.env.AbstractEnvironment;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BidbaxProjectTyrApplication {

	public static void main(String[] args) {
		System.setProperty(AbstractEnvironment.ACTIVE_PROFILES_PROPERTY_NAME, "local");
		SpringApplication.run(BidbaxProjectTyrApplication.class, args);
	}

}
