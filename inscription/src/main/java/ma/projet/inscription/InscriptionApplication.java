package ma.projet.inscription;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan(basePackages = "ma.projet.entities")
@ComponentScan(basePackages = {"ma.projet.controllers","ma.projet.services"})
@EnableJpaRepositories(basePackages = "ma.projet.repository")
public class InscriptionApplication {

	public static void main(String[] args) {
		SpringApplication.run(InscriptionApplication.class, args);
	}

}
