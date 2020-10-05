
package org.store.com.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.swing.event.ListSelectionEvent;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.store.com.model.Role;
import org.store.com.model.User;
import org.store.com.repo.RoleRepository;
import org.store.com.repo.UserRepository;

@Service
public class UserService {
	private UserRepository userRepository;
	//private RoleRepository roleRepository;
	@PersistenceContext
	EntityManager entityManager;

	public UserService(UserRepository userRepository, RoleRepository roleRepository) {
      this.userRepository = userRepository;
      
  }

	
	
	
	
	

  public ResponseEntity<Object> createUser(User model) {
	  
	  
	  
	 List<String> roleNames = new ArrayList<>();
	 roleNames.add("admin");
	  
      User user = new User();
      if (userRepository.findByEmail(model.getEmail()).isPresent()) {
          return ResponseEntity.badRequest().body("the email  already present");
      } else {
          user.setEmail(model.getEmail());
         user.setPassword(model.getPassword());
         user.setId(model.getId());
         user.setUsername(model.getUsername());
         //user.setRole(model.getRole());
       List<Role> roles1 = new ArrayList<>();
       entityManager.getTransaction().begin();
     for(String roleName : roleNames)
     {
    	
		List<Role> found = (List<Role>) entityManager.createQuery("select r from Role e where r.name=roleName",Role.class)
				.setParameter("name", roleName).getResultList();
		if(found.isEmpty())
		{
			Role role = new Role(roleName);
			entityManager.persist(role);
			roles1.add(role);
		}else {
			roles1.addAll(found);
		}
		user.setRole(roles1);
		entityManager.persist(user);
		entityManager.getTransaction().commit();
	
     }
         
    		   
          User savedUser = userRepository.save(user);
          
          
          if (userRepository.findById(savedUser.getId()).isPresent())
              return ResponseEntity.ok("User Created Successfully");
          else return ResponseEntity.unprocessableEntity().body("Failed Creating User as Specified");
      }
  }
}