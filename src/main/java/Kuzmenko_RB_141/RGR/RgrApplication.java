package Kuzmenko_RB_141.RGR;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan
@EnableJpaRepositories(basePackages = {"Kuzmenko_RB_141.RGR"})
public class RgrApplication {

	public static void main(String[] args) {
		SpringApplication.run(RgrApplication.class, args);
	}
}
