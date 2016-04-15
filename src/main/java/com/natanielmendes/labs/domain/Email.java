package com.natanielmendes.labs.domain;

import org.hibernate.annotations.Formula;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.io.Serializable;


@SuppressWarnings("serial")
@Entity
@Table(name = "EMAIL")

public class Email implements Serializable {

	public static final int PESSOAL = 1;
	public static final int COMERCIAL = 2;
	public static final int PORTAL = 3;
	public static final int VENDA = 4;
	public static final int COMPRA = 5;

//	public static final class Queries {
//		public static final String FIND_EMAIL = "FIND_EMAIL";
//		public static final String FIND_EMAIL_REGISTRATION_COMPLETED = "FIND_EMAIL_REGISTRATION_COMPLETED";
//	}

	@Id
//	@GeneratedValue(generator="triggerGenerator")
//	@GenericGenerator(name="triggerGenerator", strategy="TriggerAssignedIdentityGenerator")
	@GeneratedValue
    @Column(name = "EMAIL_ID")
    private Long id;

	@Column(name= "EMAIL_TYPE_ID")
	private Integer typeId;
    
    @Column(name = "EMAIL_PREFIX")
    private String prefix;
    
    @Column(name = "EMAIL_PROVIDER")
    private String provider;
    
    @Formula(value="EMAIL_PREFIX || '@' || EMAIL_PROVIDER")
    private String email;
    
    @Column(name = "EMAIL_MASTER")
	@Type(type = "com.natanielmendes.labs.usertype.TrueFalseCharType")
    private Boolean master;
    
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ENTITY_ID", insertable = false, updatable = false)
	private UserEntity entity;

	@Column(name = "ENTITY_ID")
	private Long entityId;
		
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPrefix() {
		return prefix;
	}

	public void setPrefix(String prefix) {
		this.prefix = prefix;
	}

	public String getProvider() {
		return provider;
	}

	public void setProvider(String provider) {
		this.provider = provider;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Boolean getMaster() {
		return master;
	}

	public void setMaster(Boolean master) {
		this.master = master;
	}

	public UserEntity getEntity() {
		return entity;
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

	public Integer getTypeId() {
		return typeId;
	}

	public void setTypeId(Integer typeId) {
		this.typeId = typeId;
	}
}
