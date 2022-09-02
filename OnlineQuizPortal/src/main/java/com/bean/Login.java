package com.bean;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Login {
	@Id
	private String email;
	private String password;
	private String usertype;
	
	
	
	public Login() {
		super();
		
	}

	public Login(String email, String password, String usertype) {
		super();
		this.email = email;
		this.password = password;
		this.usertype = usertype;
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
	public String getUsertype() {
		return usertype;
	}
	public void setUsertype(String usertype) {
		this.usertype = usertype;
	}
	@Override
	public String toString() {
		return "User [email=" + email + ", password=" + password + ", usertype=" + usertype + "]";
	}
	
	

}
