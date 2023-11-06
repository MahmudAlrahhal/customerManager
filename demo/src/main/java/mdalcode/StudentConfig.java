package mdalcode;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class StudentConfig {
	
	@Bean
	CommandLineRunner commandLineRunner(CustomerRepository repository) {
		return agrs -> {
			Customer customer = new Customer(1, "Mahmud", "alrahhal24@gmail.com", 26);
			Customer customer1 = new Customer(2, "Yasmin", "Yasmin@gmail.com", 30);
			repository.saveAll(List.of(customer, customer1));
		};
	}
}
