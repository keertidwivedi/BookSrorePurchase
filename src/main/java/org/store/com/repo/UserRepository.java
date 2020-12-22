package org.store.com.repo;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.store.com.ResponseDto.UserResponseDto;
import org.store.com.model.Role;
import org.store.com.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

	ArrayList<User> findByRole(Optional<Role> adminRole);

	Optional<User> findByEmail(String email);

	User findById(long id);

	User deleteById(long userId);

	List<User> findAll();

	User findByUserName(String userName);

	User save(UserResponseDto updateUser);

}
