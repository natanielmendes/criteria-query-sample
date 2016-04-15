package com.natanielmendes.labs.domain;

import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(Document.class)
public abstract class Document_ {

	public static volatile SingularAttribute<Document, Long> id;
	public static volatile SingularAttribute<Document, DocumentType> documentType;
	public static volatile SingularAttribute<Document, Integer> documentTypeId;
	public static volatile SingularAttribute<Document, UserEntity> entity;
	public static volatile SingularAttribute<Document, Long> entityId;
	public static volatile SingularAttribute<Document, String> documentNumber;

}

