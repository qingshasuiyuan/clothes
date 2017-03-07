package com.clothes.model;

/**
 * Master entity. @author MyEclipse Persistence Tools
 */

public class Master implements java.io.Serializable {

	// Fields

	private Integer masterid;
	private String name;
	private String password;

	// Constructors

	/** default constructor */
	public Master() {
	}

	/** full constructor */
	public Master(String name, String password) {
		this.name = name;
		this.password = password;
	}

	// Property accessors

	public Integer getMasterid() {
		return this.masterid;
	}

	public void setMasterid(Integer masterid) {
		this.masterid = masterid;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}