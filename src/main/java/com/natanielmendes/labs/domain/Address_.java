package com.natanielmendes.labs.domain;

import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(Address.class)
public abstract class Address_ {

	public static volatile SingularAttribute<Address, Long> id;
	public static volatile SingularAttribute<Address, String> location;
	public static volatile SingularAttribute<Address, String> country;

}

