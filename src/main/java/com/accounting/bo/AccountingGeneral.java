package com.accounting.bo;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Transient;


@MappedSuperclass
public class AccountingGeneral {

	
	@Column
	Date createdAt;
	
	@Column
	Date updateAt;
	
	@Transient
    int errorCode;
	
	@Transient
    String errorDetail;

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getUpdateAt() {
		return updateAt;
	}

	public void setUpdateAt(Date updateAt) {
		this.updateAt = updateAt;
	}
	

	@PrePersist
	protected void onCreate() {
		  createdAt = new Date();
		  updateAt = new Date();
	}

	@PreUpdate
	protected void onUpdate() {
		  updateAt = new Date();
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
