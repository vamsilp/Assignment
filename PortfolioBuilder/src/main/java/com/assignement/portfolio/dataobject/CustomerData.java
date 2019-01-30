package com.assignement.portfolio.dataobject;

import org.apache.commons.lang.builder.ToStringBuilder;

public class CustomerData {

	private String firstName;
	private String lastName;
	private String dob;
	private String asset;
	private String rowText;

	public String getRowText() {
		return rowText;
	}

	public void setRowText(String rowText) {
		this.rowText = rowText;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public String getAsset() {
		return asset;
	}

	public void setAsset(String asset) {
		this.asset = asset;
	}

	public CustomerData() {}
	
	public CustomerData(String firstName, String lastName, String dob, String asset) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.dob = dob;
		this.asset = asset;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}

}
