package hu.flowacademy.vatera;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories
@SpringBootApplication
public class VateraApplication {

	public static void main(String[] args) {
		SpringApplication.run(VateraApplication.class, args);
	}

}
