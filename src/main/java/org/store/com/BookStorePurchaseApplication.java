package org.store.com;

import java.util.Arrays;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.domain.Persistable;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.store.com.model.Role;
import org.store.com.model.User;
import org.store.com.repo.RoleRepository;
import org.store.com.repo.UserRepository;

@SpringBootApplication()
//@EnableJpaRepositories(basePackageClasses = UserRepository.class)
@ComponentScan("org.store.com")
public class BookStorePurchaseApplication  {
	private static final Logger logger = LoggerFactory.getLogger(BookStorePurchaseApplication.class);


	public static void main(String[] args) {
		SpringApplication.run(BookStorePurchaseApplication.class, args);
		System.out.println("Heloooo");
	}
		
	
	

}
