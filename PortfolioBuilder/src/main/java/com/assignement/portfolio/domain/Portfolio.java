package com.assignement.portfolio.domain;

import org.apache.commons.lang.builder.ToStringBuilder;

public class Portfolio {

	private String firstName;
	private String lastName;
	private String portfolioName;

	public Portfolio() {}
	public Portfolio(String firstName, String lastName, String portfolioName) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.portfolioName = portfolioName;
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

	public String getPortfolioName() {
		return portfolioName;
	}

	public void setPortfolioName(String portfolioName) {
		this.portfolioName = portfolioName;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}

}
