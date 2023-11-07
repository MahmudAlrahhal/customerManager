package mdalcode;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class StudentConfig {
	
	@Bean
	CommandLineRunner commandLineRunner(CustomerRepository repository) {
		return agrs -> {
			/*Customer customer = new Customer(1, "Mahmud", "alrahhal24@gmail.com",
					LocalDate.of(1997, Month.AUGUST, 4));
			Customer customer1 = new Customer(2, "Yasmin", "Yasmin@gmail.com",
					LocalDate.of(1999, Month.DECEMBER, 15));
			repository.saveAll(List.of(customer, customer1));*/
		};
	}
}
