package com.accounting.bo;

import java.util.Map;

public class FacebookProfile {
	
	private String id;
	private String name;
	private String access_token;
	private String email;
	private Map<String,Object> picture;
	
	private int errorCode;
	private String errorDetail;
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAccess_token() {
		return access_token;
	}
	public void setAccess_token(String access_token) {
		this.access_token = access_token;
	}
	public Map<String, Object> getPicture() {
		return picture;
	}
	public void setPicture(Map<String, Object> picture) {
		this.picture = picture;
	}
	public int getErrorCode() {
		return errorCode;
	}
	public void setErrorCode(int errorCode) {
		this.errorCode = errorCode;
	}
	public String getErrorDetail() {
		return errorDetail;
	}
	public void setErrorDetail(String errorDetail) {
		this.errorDetail = errorDetail;
	}
}
