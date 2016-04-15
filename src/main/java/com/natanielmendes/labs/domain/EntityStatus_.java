package com.natanielmendes.labs.domain;

import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(EntityStatus.class)
public abstract class EntityStatus_ {

	public static volatile SingularAttribute<EntityStatus, Integer> statusCode;
	public static volatile SingularAttribute<EntityStatus, String> statusName;

}

