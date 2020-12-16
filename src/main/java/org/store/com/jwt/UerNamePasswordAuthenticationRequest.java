
package org.store.com.jwt;

public class UerNamePasswordAuthenticationRequest {

	private String userName;

	private String password;

	public UerNamePasswordAuthenticationRequest() {

	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
