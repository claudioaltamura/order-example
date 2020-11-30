package de.claudioaltamura.order.example;

import de.claudioaltamura.order.example.entity.Customer;
import de.claudioaltamura.order.example.repository.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class OrderExampleApplication {

	public static void main(String[] args) {
		SpringApplication.run(OrderExampleApplication.class, args);
	}


//	@Bean
//	public CommandLineRunner demo(CustomerRepository repository) {
//		return (args) -> {
//			Customer peter = new Customer();
//			peter.setName("Peter");
//			repository.save(peter);
//		};
//	}
}
