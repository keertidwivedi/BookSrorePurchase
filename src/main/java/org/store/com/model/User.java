package org.store.com.model;

import java.util.*;

import javax.persistence.*;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "users")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String userName;

	private String email;

	private String password;

	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "user_Id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id"))
	private Set<Role> role = new HashSet<Role>();

	@Override
	public String toString() {
		return "User [id=" + id + ", userName=" + userName + ", email=" + email + ", password=" + password + ", role="
				+ role + "]";
	}

	public User(Long id, String userName, String email, String password, Set<Role> role) {

		this.id = id;
		this.userName = userName;
		this.email = email;
		this.password = password;
		this.role = role;
	}

	public User(Long id, String userName, String email, String password) {
		this.id = id;
		this.userName = userName;
		this.email = email;
		this.password = password;
	}

}
