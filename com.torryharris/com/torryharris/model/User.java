package com.torryharris.model;

public class User {
private String userId,fName,password,phoneNo,eMail;


public User(String userId, String fName, String password, String phoneNo, String eMail) {
	
	this.userId = userId;
	this.fName = fName;
	this.password = password;
	this.phoneNo = phoneNo;
	this.eMail = eMail;
}

public String getUserId() {
	return userId;
}

public void setUserId(String userId) {
	this.userId = userId;
}

public String getfName() {
	return fName;
}

public void setfName(String fName) {
	this.fName = fName;
}

public String getPassword() {
	return password;
}

public void setPassword(String password) {
	this.password = password;
}

public String getPhoneNo() {
	return phoneNo;
}

public void setPhoneNo(String phoneNo) {
	this.phoneNo = phoneNo;
}

public String geteMail() {
	return eMail;
}

public void seteMail(String eMail) {
	this.eMail = eMail;
}

}
