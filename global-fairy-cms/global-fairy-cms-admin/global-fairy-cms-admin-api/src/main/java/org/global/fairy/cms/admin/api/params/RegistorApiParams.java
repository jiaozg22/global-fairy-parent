package org.global.fairy.cms.admin.api.params;

public class RegistorApiParams {

	private String username;

	private String password;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public RegistorApiParams() {
	}

	public RegistorApiParams(String username, String password) {
		this.username = username;
		this.password = password;
	}
}
