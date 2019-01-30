package com.assignement.portfolio.builder;

//D- object from which Object O will be build
public interface ObjectBuiler<D,O> {

	public O build(D d);

}
