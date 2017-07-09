package org.global.fairy.cms.admin.dao.beans;

import java.io.Serializable;


//@Entity
//@Table(name = "user_info")
public class UserInfoBean implements Serializable{
	
	
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	//	@Id
//	@GeneratedValue(generator = "uuid")
//	@GenericGenerator(name = "uuid", strategy = "uuid")
	private int id;

//	@Column(name = "code_id")
	//private String codeId;

	private String username;

	private String password;

//	@Column(name = "role_id")
	private int roleId;

	private String regtime;

	private String lastlogtime;

	private int logcounts;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

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

	public String getRegtime() {
		return regtime;
	}

	public void setRegtime(String regtime) {
		this.regtime = regtime;
	}

	public String getLastlogtime() {
		return lastlogtime;
	}

	public void setLastlogtime(String lastlogtime) {
		this.lastlogtime = lastlogtime;
	}

	public int getLogcounts() {
		return logcounts;
	}

	public void setLogcounts(int logcounts) {
		this.logcounts = logcounts;
	}

	public int getRoleId() {
		return roleId;
	}

	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}

}
