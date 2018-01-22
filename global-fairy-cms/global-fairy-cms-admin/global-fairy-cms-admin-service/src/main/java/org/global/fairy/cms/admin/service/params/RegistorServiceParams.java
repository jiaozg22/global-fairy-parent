package org.global.fairy.cms.admin.service.params;

import java.io.Serializable;

public class RegistorServiceParams implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String username;

	private String password;

	
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public RegistorServiceParams() {
	}

	public RegistorServiceParams(String username, String password) {
		super();
		this.setUsername(username);
		this.password = password;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

}
