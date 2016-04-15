package com.natanielmendes.labs.domain;

import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(DocumentType.class)
public abstract class DocumentType_ {

	public static volatile SingularAttribute<DocumentType, Integer> id;
	public static volatile SingularAttribute<DocumentType, String> desc;
	public static volatile SingularAttribute<DocumentType, String> description;
	public static volatile SingularAttribute<DocumentType, String> name;
	public static volatile SingularAttribute<DocumentType, Country> country;

}

