/*
 * package org.store.com.service;
 * 
 * import java.util.HashSet; import java.util.Set;
 * 
 * import org.springframework.beans.factory.annotation.Autowired; import
 * org.springframework.security.core.authority.SimpleGrantedAuthority; import
 * org.springframework.security.core.userdetails.UserDetails; import
 * org.springframework.security.core.userdetails.UserDetailsService; import
 * org.springframework.security.core.userdetails.UsernameNotFoundException;
 * import org.store.com.model.Role; import org.store.com.model.User; import
 * org.store.com.repo.UserRepository; import
 * org.springframework.transaction.annotation.Transactional; public class
 * UserDetailsServiceImp implements UserDetailsService {
 * 
 * @Autowired private UserRepository userRepository;
 * 
 * @Override
 * 
 * @Transactional(readOnly = true) public UserDetails loadUserByUsername(String
 * username) throws UsernameNotFoundException {
 * 
 * User user = userRepository.findByUsername(username); if (user == null) throw
 * new UsernameNotFoundException(username);
 * 
 * Set grantedAuthorities = new HashSet<>(); for(Role role : user.getRole()) {
 * grantedAuthorities.add(new SimpleGrantedAuthority(role.getName())); }
 * 
 * return new
 * org.springframework.security.core.userdetails.User(user.getUsername()
 * ,user.getPassword(), grantedAuthorities); }
 * 
 * 
 * 
 * 
 * }
 */