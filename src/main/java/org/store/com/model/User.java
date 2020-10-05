package org.store.com.model;

import java.util.*; 

import javax.persistence.*;




@Entity
@Table(name = "users")
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String username;
	
	private String email;
	
	private String password;

	@ManyToMany(targetEntity = Role.class, cascade = {CascadeType.PERSIST, CascadeType.DETACH,CascadeType.MERGE,CascadeType.REFRESH} )
	@JoinTable(name="user_role",joinColumns = @JoinColumn(name = "user_Id",referencedColumnName = "id"),
	inverseJoinColumns = @JoinColumn (name = "role_id",referencedColumnName = "id") )
	private List<Role> role  ;

	
public User()
{
	
}
	

	public User(Long id, String username, String email, String password, List<Role> role) {
		
		this.id = id;
		this.username = username;
		this.email = email;
		this.password = password;
		this.role = role;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<Role> getRole() {
		return role;
	}


	public void setRole(List role) {
		this.role=role;
		
	}


	

	

	
	

	
	
	
	

}
