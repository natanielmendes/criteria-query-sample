package com.natanielmendes.labs.domain;

import java.util.Date;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(UserEntity.class)
public abstract class UserEntity_ {

	public static volatile SingularAttribute<UserEntity, Integer> portalId;
	public static volatile SingularAttribute<UserEntity, String> type;
	public static volatile SingularAttribute<UserEntity, String> entityApprover;
	public static volatile SetAttribute<UserEntity, Phone> phones;
	public static volatile SingularAttribute<UserEntity, Long> id;
	public static volatile SingularAttribute<UserEntity, Boolean> foreignRegister;
	public static volatile SingularAttribute<UserEntity, Date> registrationDate;
	public static volatile SingularAttribute<UserEntity, String> cif;
	public static volatile SetAttribute<UserEntity, Perfil> perfils;
	public static volatile SingularAttribute<UserEntity, Integer> entityStatusCode;
	public static volatile SingularAttribute<UserEntity, String> name;
	public static volatile SetAttribute<UserEntity, Perfil> perfil;
	public static volatile SingularAttribute<UserEntity, EntityStatus> entityStatus;
	public static volatile SingularAttribute<UserEntity, Login> login;
	public static volatile SingularAttribute<UserEntity, String> versaoCadastro;
	public static volatile SingularAttribute<UserEntity, Integer> countryId;
	public static volatile SetAttribute<UserEntity, Document> documents;
	public static volatile SingularAttribute<UserEntity, Portal> portal;
	public static volatile SingularAttribute<UserEntity, Long> marketingTypeId;
	public static volatile SingularAttribute<UserEntity, Date> confirmationDate;
	public static volatile SetAttribute<UserEntity, Company> companies;
	public static volatile SetAttribute<UserEntity, Email> emails;
	public static volatile SingularAttribute<UserEntity, Date> lastUpdateDate;
	public static volatile SingularAttribute<UserEntity, Boolean> receiveInfoEmail;
	public static volatile SingularAttribute<UserEntity, Company> company;
	public static volatile SingularAttribute<UserEntity, Date> approvalDate;
	public static volatile SingularAttribute<UserEntity, Boolean> entityParent;
	public static volatile SingularAttribute<UserEntity, String> marketingTypeDesc;

}

