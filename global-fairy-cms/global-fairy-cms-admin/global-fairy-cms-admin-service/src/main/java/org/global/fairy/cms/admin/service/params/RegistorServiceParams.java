package org.global.fairy.cms.admin.service.params;

import java.io.Serializable;

public class RegistorServiceParams implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String username;

	private String password;

	public String getName() {
		return username;
	}

	public void setName(String name) {
		this.username = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public RegistorServiceParams() {
	}

	public RegistorServiceParams(String name, String password) {
		super();
		this.username = name;
		this.password = password;
	}

}
