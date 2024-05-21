package com.chainsys.server;

public class Register {
	String name;
	String email;
	int mobile;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getMobile() {
		return mobile;
	}
	public void setMobile(int mobile) {
		this.mobile = mobile;
	}
	public Register(String name, String email, int mobile) {
		super();
		this.name = name;
		this.email = email;
		this.mobile = mobile;
	}
	
	public Register() {
		super();
	}
	@Override
	public String toString() {
		return "Register1 [name=" + name + ", email=" + email + ", mobile=" + mobile + "]";
	}
}
