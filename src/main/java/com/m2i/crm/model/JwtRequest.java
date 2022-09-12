package com.m2i.crm.model;

/**
 *
 * @author Victor
 */
import java.io.Serializable;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class JwtRequest implements Serializable {

	private static final long serialVersionUID = 5926468583005150707L;
	
	private String username;
	private String password;
	
	public JwtRequest(String username, String password) {
		this.setUsername(username);
		this.setPassword(password);
	}

}