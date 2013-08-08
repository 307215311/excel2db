package cn.ecoinfo.excel.entity;

import java.io.Serializable;

public class DBInfo implements Serializable {
	private static final long serialVersionUID = 1L;
	private String driver;
	private String url;
	private String username;
	private String password;
	private String target;
	public String getDriver() {
		return driver;
	}
	public void setDriver(String driver) {
		this.driver = driver;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
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
	public String getTarget() {
		return target;
	}
	public void setTarget(String target) {
		this.target = target;
	}
	public String toString() {
		return "DBInfo [driver=" + driver + ", url=" + url + ", username="
				+ username + ", password=" + password + ", target=" + target
				+ "]";
	}
	
}
