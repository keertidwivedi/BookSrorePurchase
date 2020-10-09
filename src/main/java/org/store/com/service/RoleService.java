/*
 * package org.store.com.service;
 * 
 * import java.util.ArrayList; import java.util.HashSet; import java.util.List;
 * import java.util.Set;
 * 
 * import javax.transaction.Transactional;
 * 
 * import org.springframework.beans.factory.annotation.Autowired; import
 * org.springframework.http.ResponseEntity; import
 * org.springframework.stereotype.Service; import org.store.com.model.Role;
 * import org.store.com.model.User; import org.store.com.repo.RoleRepository;
 * import org.store.com.repo.UserRepository;
 * 
 * @Service public class RoleService { private RoleRepository roleRepository;
 * private UserRepository userRepository;
 * 
 * public RoleService(RoleRepository roleRepository, UserRepository
 * userRepository) { this.roleRepository = roleRepository; this.userRepository =
 * userRepository; }
 * 
 *//** Create a new role *//*
							 * 
							 * @Transactional public ResponseEntity<Object> addRole(Role role) {
							 * 
							 * Role newRole = new Role(); newRole.setName(role.getName()); Set roleList =
							 * new HashSet(); roleList.add(newRole); for (int i = 0; i <
							 * role.getUsers().size(); i++) { if
							 * (!userRepository.findByEmail(role.getUsers().get(i).getEmail()).isPresent())
							 * { User newUser = role.getUsers().get(i); newUser.setRole(roleList); User
							 * savedUser = userRepository.save(newUser); if
							 * (!userRepository.findById(savedUser.getId()).isPresent()) return
							 * ResponseEntity.unprocessableEntity().body("Role Creation Failed"); } else
							 * return ResponseEntity.unprocessableEntity().
							 * body("User with email Id is already Present"); }
							 * 
							 * return ResponseEntity.ok("Successfully created Role"); }
							 * 
							 * }
							 */