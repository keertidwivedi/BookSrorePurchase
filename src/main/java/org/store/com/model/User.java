package org.store.com.model;

import java.util.*;

import javax.persistence.*;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "users")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name =  "id")
	private Long userId;

	private String userName;

	private String email;

	private String password;

	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "user_Id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id"))
	private Set<Role> role = new HashSet<Role>();

	@Override
	public String toString() {
		return "User [id=" + userId + ", userName=" + userName + ", email=" + email + ", password=" + password + ", role="
				+ role + "]";
	}


	public User(Long userId, String userName, String email, String password) {
		this.userId = userId;
		this.userName = userName;
		this.email = email;
		this.password = password;
	}

}
