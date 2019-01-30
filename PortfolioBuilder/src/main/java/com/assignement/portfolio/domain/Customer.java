/**
 * 
 */
package com.assignement.portfolio.domain;

import java.math.BigDecimal;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.joda.time.LocalDate;

public class Customer {

	private String firstName;
	private String lastName;
	private LocalDate dob;
	private BigDecimal asset;

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

	public LocalDate getDob() {
		return dob;
	}

	public void setDob(LocalDate dob) {
		this.dob = dob;
	}

	public BigDecimal getAsset() {
		return asset;
	}

	public void setAsset(BigDecimal asset) {
		this.asset = asset;
	}

	public Customer() {}
	
	public Customer(String firstName, String lastName, LocalDate dob, BigDecimal asset) {
		super();
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
