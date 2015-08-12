package com.edufabricio.labs.domain;

import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(Account.class)
public abstract class Account_ {

	public static volatile SingularAttribute<Account, Long> id;
	public static volatile SingularAttribute<Account, Person> person;
	public static volatile SingularAttribute<Account, Integer> type;

}

