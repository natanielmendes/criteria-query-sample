package com.natanielmendes.labs.domain;

import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(Order.class)
public abstract class Order_ {

	public static volatile SingularAttribute<Order, Long> id;
	public static volatile SingularAttribute<Order, Date> createdAt;
	public static volatile SingularAttribute<Order, BigDecimal> value;
	public static volatile SingularAttribute<Order, Date> createSinceLimitHours;
	public static volatile SingularAttribute<Order, Integer> hoursMax;

}

