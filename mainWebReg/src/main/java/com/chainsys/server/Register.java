package com.chainsys.server;

public class Register {
	int id;
	String name;
	String email;
	long mobile;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
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
	public long getMobile() {
		return mobile;
	}
	public void setMobile(long mobile) {
		this.mobile = mobile;
	}
	public Register(String name, String email, long mobile) {
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
