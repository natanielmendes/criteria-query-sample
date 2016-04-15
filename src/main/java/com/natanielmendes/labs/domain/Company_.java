package com.natanielmendes.labs.domain;

import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(Company.class)
public abstract class Company_ {

	public static volatile SingularAttribute<Company, Long> id;
	public static volatile SingularAttribute<Company, String> companyContact;
	public static volatile SingularAttribute<Company, Integer> companyAnnualIncome;
	public static volatile SingularAttribute<Company, UserEntity> entity;
	public static volatile SingularAttribute<Company, Integer> companyQtdEmployee;
	public static volatile SingularAttribute<Company, Integer> activityBranchId;
	public static volatile SingularAttribute<Company, String> companyFantasyName;
	public static volatile SingularAttribute<Company, String> companyUrl;

}

