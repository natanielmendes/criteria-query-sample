package com.edufabricio.labs.domain;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Account.class)
public abstract class Account_ {

	public static volatile SingularAttribute<Account, Long> id;
	public static volatile SingularAttribute<Account, Person> person;
	public static volatile SingularAttribute<Account, Integer> type;

}

