/*
 * package org.store.com.session;
 * 
 * import javax.persistence.EntityManager; import
 * javax.persistence.EntityManagerFactory; import javax.persistence.Persistence;
 * 
 * import org.hibernate.Session; import org.hibernate.SessionFactory; import
 * org.hibernate.cfg.Configuration; import org.slf4j.Logger; import
 * org.slf4j.LoggerFactory; import
 * org.springframework.beans.factory.annotation.Autowired; import
 * org.springframework.boot.CommandLineRunner; import
 * org.springframework.boot.autoconfigure.SpringBootApplication; import
 * org.store.com.model.Role; import org.store.com.model.User; import
 * org.store.com.repo.RoleRepository; import org.store.com.repo.UserRepository;
 * 
 * @SpringBootApplication public class UserRole implements CommandLineRunner {
 * 
 * 
 * 
 * 
 * public static void main(String[] args) {
 * 
 * 
 * 
 * EntityManagerFactory emf = Persistence.createEntityManagerFactory("DONE");
 * EntityManager em = emf.createEntityManager(); em.getTransaction().begin();
 * 
 * User user = null;
 * 
 * User users = new
 * User(user.getId(),user.getEmail(),user.getPassword(),user.getUsername(),user.
 * getRole());
 * 
 * em.persist(users);
 * 
 * 
 * Role role1 = new Role(1,"ADMIN"); Role role2 = new Role(2,"USER");
 * 
 * 
 * }
 * 
 * 
 * }
 */
