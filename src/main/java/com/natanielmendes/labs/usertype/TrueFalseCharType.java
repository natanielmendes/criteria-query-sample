package com.natanielmendes.labs.usertype;
import org.hibernate.dialect.Dialect;
import org.hibernate.type.*;
import org.hibernate.type.descriptor.java.BooleanTypeDescriptor;
import org.hibernate.type.descriptor.sql.CharTypeDescriptor;

import java.io.Serializable;

@SuppressWarnings("serial")
public class TrueFalseCharType extends
		AbstractSingleColumnStandardBasicType<Boolean> implements
		PrimitiveType<Boolean>, DiscriminatorType<Boolean> {

	public static final TrueFalseType INSTANCE = new TrueFalseType();

	public TrueFalseCharType() {
		super(CharTypeDescriptor.INSTANCE, new BooleanTypeDescriptor('T', 'F'));
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
		return StringType.INSTANCE.objectToSQLString(value.booleanValue() ? "T"
				: "F", dialect);
	}

}
