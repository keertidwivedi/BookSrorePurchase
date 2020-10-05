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
import org.springframework.data.domain.Persistable;
import org.store.com.model.Role;
import org.store.com.model.User;
import org.store.com.repo.RoleRepository;
import org.store.com.repo.UserRepository;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class } )
public class BookStorePurchaseApplication  {
	private static final Logger logger = LoggerFactory.getLogger(BookStorePurchaseApplication.class);

	@Autowired
	private RoleRepository repository;
	@Autowired
	private UserRepository userRepository;

	public static void main(String[] args) {
		SpringApplication.run(BookStorePurchaseApplication.class, args);
		System.out.println("Heloooo");
	}
		
		/*
		 * SessionFactory factory = new Configuration() .configure("hibernate.cfg.xml")
		 * .addAnnotatedClass(User.class) .addAnnotatedClass(Role.class)
		 * .buildSessionFactory();
		 * 
		 * 
		 * Session session = factory.getCurrentSession();
		 * 
		 * session.beginTransaction();
		 * 
		 * Role role = null;
		 * 
		 * Role roles = new Role(role.getId(),role.getName());
		 * 
		 * session.save(roles);
		 * 
		 * session.getTransaction().commit();
		 * 
		 * System.out.println("Done");
		 */
		/*
		 * @Override
		 * 
		 * { Role role1 = new Role(1,"Admin"); Role role2 = new Role(1,"Admin");
		 * 
		 * User users = new User((long)
		 * 1,"k@keerti","keerti","keerti",Arrays.asList(role1));
		 * userRepository.save(users); System.out.println(users);
		 * System.out.println("hiiii"); }
		 */
		 
		
	

}
