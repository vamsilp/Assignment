package com.assignement.portfolio.validator;

public interface Validator<T> {

	public boolean validate(T t) throws Exception;
}
