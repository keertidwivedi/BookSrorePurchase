package org.store.com;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.store.com.repo.UserRepository;

@SpringBootApplication()
@EnableJpaRepositories(basePackageClasses = UserRepository.class)
@ComponentScan("org.store.com")
public class BookStorePurchaseApplication  {
	private static final Logger logger = LoggerFactory.getLogger(BookStorePurchaseApplication.class);


	public static void main(String[] args) {
		SpringApplication.run(BookStorePurchaseApplication.class, args);
		System.out.println("Heloooo");
	}
		
	
	

}
