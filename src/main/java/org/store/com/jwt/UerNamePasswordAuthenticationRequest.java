
package org.store.com.jwt;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UerNamePasswordAuthenticationRequest {

	private String userName;

	private String password;

	public UerNamePasswordAuthenticationRequest() {

	}

	
}
