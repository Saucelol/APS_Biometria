package aps.biometria;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

//COISAS DO FRAMEWORK
//NÃO MEXER
@SpringBootApplication
@EnableJpaRepositories(basePackages = "aps.biometria.dao")
public class ApsApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApsApplication.class, args);
	}

}
