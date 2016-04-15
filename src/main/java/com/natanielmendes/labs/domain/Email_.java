package com.natanielmendes.labs.domain;

import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(Email.class)
public abstract class Email_ {

	public static volatile SingularAttribute<Email, Long> id;
	public static volatile SingularAttribute<Email, String> email;
	public static volatile SingularAttribute<Email, UserEntity> entity;
	public static volatile SingularAttribute<Email, String> prefix;
	public static volatile SingularAttribute<Email, Long> entityId;
	public static volatile SingularAttribute<Email, String> provider;
	public static volatile SingularAttribute<Email, Integer> typeId;
	public static volatile SingularAttribute<Email, Boolean> master;

}

