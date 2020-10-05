/*
 * package org.store.com.service;
 * 
 * 
 * import org.springframework.beans.factory.annotation.Autowired; import
 * org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder; import
 * org.springframework.stereotype.Service; import org.store.com.model.Role;
 * import org.store.com.model.User; import org.store.com.repo.RoleRepository;
 * import org.store.com.repo.UserRepository;
 * 
 * import java.util.HashSet;
 * 
 * 
 * public class UserServiceImpl implements UserService {
 * 
 * @Autowired private UserRepository userRepository;
 * 
 * @Autowired private RoleRepository roleRepository;
 * 
 * @Autowired private BCryptPasswordEncoder bCryptPasswordEncoder;
 * 
 * 
 * 
 * 
 * 
 * 
 * @Override public void save(User user) {
 * user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
 * user.setRole( roleRepository.findAll()); userRepository.save(user); }
 * 
 * @Override public User findByUsername(String username) { return
 * userRepository.findByUsername(username); } }
 */