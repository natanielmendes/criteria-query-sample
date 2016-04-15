package com.natanielmendes.labs.usertype;

import java.io.Serializable;

import org.hibernate.dialect.Dialect;
import org.hibernate.type.AbstractSingleColumnStandardBasicType;
import org.hibernate.type.DiscriminatorType;
import org.hibernate.type.PrimitiveType;
import org.hibernate.type.StringType;
import org.hibernate.type.TrueFalseType;
import org.hibernate.type.descriptor.java.BooleanTypeDescriptor;
import org.hibernate.type.descriptor.sql.VarcharTypeDescriptor;

@SuppressWarnings("serial")
public class SimNaoVarcharType extends
		AbstractSingleColumnStandardBasicType<Boolean> implements
		PrimitiveType<Boolean>, DiscriminatorType<Boolean> {


	public static final TrueFalseType INSTANCE = new TrueFalseType();

	public SimNaoVarcharType() {
		super(VarcharTypeDescriptor.INSTANCE, new BooleanTypeDescriptor('S', 'N'));
	}

	public String getName() {
		return "true_false";
	}

	@SuppressWarnings("rawtypes")
	public Class getPrimitiveClass() {
		return boolean.class;
	}

	public Boolean stringToObject(String xml) throws Exception {
		return fromString(xml);
	}

	public Serializable getDefaultValue() {
		return Boolean.FALSE;
	}
	
	public String objectToSQLString(Boolean value, Dialect dialect)
			throws Exception {
		return StringType.INSTANCE.objectToSQLString(value.booleanValue() ? "S"
				: "N", dialect);
	}
}
