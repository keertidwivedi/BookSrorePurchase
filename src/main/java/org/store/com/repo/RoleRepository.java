package org.store.com.repo;

import java.util.Optional;
import org.springframework.stereotype.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.store.com.model.Role;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository  extends JpaRepository<Role, Long>{

	 Optional<Role> findByName(String name);

	
}
