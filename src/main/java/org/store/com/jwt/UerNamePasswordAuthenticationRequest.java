
package org.store.com.jwt;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class UerNamePasswordAuthenticationRequest {

	private String userName;

	private String password;

}
