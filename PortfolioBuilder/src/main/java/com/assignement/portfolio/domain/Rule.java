package com.assignement.portfolio.domain;

import java.math.BigDecimal;

import org.apache.commons.lang.builder.ToStringBuilder;

public class Rule {

	private String modelName;
	private BigDecimal pctEquityFunds;
	private BigDecimal pctBondFunds;
	private BigDecimal pctCashFunds;
	private Integer startAge;
	private Integer endAge;

	public Rule() {}
	public Rule(String modelName, BigDecimal pctEquityFunds, BigDecimal pctBondFunds, BigDecimal pctCashFunds,
			Integer startAge, Integer endAge) {
		super();
		this.modelName = modelName;
		this.pctEquityFunds = pctEquityFunds;
		this.pctBondFunds = pctBondFunds;
		this.pctCashFunds = pctCashFunds;
		this.startAge = startAge;
		this.endAge = endAge;
	}

	public String getModelName() {
		return modelName;
	}

	public void setModelName(String modelName) {
		this.modelName = modelName;
	}

	public BigDecimal getPctEquityFunds() {
		return pctEquityFunds;
	}

	public void setPctEquityFunds(BigDecimal pctEquityFunds) {
		this.pctEquityFunds = pctEquityFunds;
	}

	public BigDecimal getPctBondFunds() {
		return pctBondFunds;
	}

	public void setPctBondFunds(BigDecimal pctBondFunds) {
		this.pctBondFunds = pctBondFunds;
	}

	public BigDecimal getPctCashFunds() {
		return pctCashFunds;
	}

	public void setPctCashFunds(BigDecimal pctCashFunds) {
		this.pctCashFunds = pctCashFunds;
	}

	public Integer getStartAge() {
		return startAge;
	}

	public void setStartAge(Integer startAge) {
		this.startAge = startAge;
	}

	public Integer getEndAge() {
		return endAge;
	}

	public void setEndAge(Integer endAge) {
		this.endAge = endAge;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}

}
