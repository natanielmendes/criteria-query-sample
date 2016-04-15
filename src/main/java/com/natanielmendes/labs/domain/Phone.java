package com.natanielmendes.labs.domain;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;

@Entity
@Table(name = "PHONE")

public class Phone implements java.io.Serializable {

	public static final class Queries {
		public static final String FIND_ALL_PHONE_BY_ENTITY = "FIND_ALL_PHONE_BY_ENTITY";
		public static final String FIND_MOBILE_PHONE_BY_ENTITY = "FIND_MOBILE_PHONE_BY_ENTITY";
		public static final String FIND_DDI_BY_COUNTRY = "FIND_DDI_BY_COUNTRY";
	}

	public static final int RESIDENCIAL = 1;
	public static final int COMERCIAL = 2;
	public static final int CELULAR	= 3;
	public static final int FAX	= 4;
	public static final int PORTAL = 5;
	public static final int FIXO = 6;
	
	@Id
    @GeneratedValue(generator="triggerGenerator")
    @GenericGenerator(name="triggerGenerator", strategy="com.natanielmendes.labs.TriggerAssignedIdentityGenerator")
    @Column(name = "PHONE_ID")
    private Long id;
	
	@Column(name = "PHONE_NUMBER")
	@Length(max=16)
	private String phoneNumber;

	@Column(name = "ENTITY_ID")
	private Long entityId;

	@Column(name = "PHONE_DDI")
	private String phoneDDI;
	
	@Column(name = "PHONE_DDD")
	private String phoneDDD;
	
	@Column(name = "PHONE_TYPE_ID")
	private Integer type; 
	
	public Long getId() {
        return this.id;
    }

	public void setId(Long id) {
        this.id = id;
    }
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ENTITY_ID", updatable = false, insertable = false)
	private UserEntity entity;

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		if (getPhoneDDI() != null) {
			sb.append("+").append(getPhoneDDI());
		}
		if (getPhoneDDD() != null) {
			sb.append(" ").append(getPhoneDDD());
		}
		if (getPhoneNumber() != null) {
			if (getPhoneDDI() != null || getPhoneDDD() != null) {
				sb.append(" ");
			}
			sb.append(getPhoneNumber());
		}
		return sb.toString();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		Phone other = (Phone) obj;
		if (getId() == null) {
			if (other.getId() != null)
				return false;
		} else if (!getId().equals(other.getId()))
			return false;
		return true;
	}

	public String getPhoneNumber() {
        return this.phoneNumber;
    }

	public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

	public String getPhoneDDI() {
        return this.phoneDDI;
    }

	public void setPhoneDDI(String phoneDDI) {
        this.phoneDDI = phoneDDI;
    }

	public String getPhoneDDD() {
        return this.phoneDDD;
    }

	public void setPhoneDDD(String phoneDDD) {
        this.phoneDDD = phoneDDD;
    }

	public Integer getType() {
        return this.type;
    }

	public void setType(Integer type) {
        this.type = type;
    }

	public UserEntity getEntity() {
        return this.entity;
    }

	public void setEntity(UserEntity entity) {
        this.entity = entity;
    }

	public Long getEntityId() {
		return entityId;
	}

	public void setEntityId(Long entityId) {
		this.entityId = entityId;
	}


}
