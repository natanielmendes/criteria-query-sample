package com.natanielmendes.labs.domain;

import org.hibernate.annotations.Type;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@SuppressWarnings("serial")
@Entity
@Table(name = "ENTITY")

public class UserEntity implements Serializable {

	public static final String  TYPE_PJ = "J";
	public static final String  TYPE_PF = "F";
	public static final String  TYPE_ADM = "A";

	@Id
//	@GeneratedValue(generator="triggerGenerator")
//	@GenericGenerator(name="triggerGenerator", strategy="TriggerAssignedIdentityGenerator")
	@GeneratedValue
	@Column(name = "ENTITY_ID")
	private Long id;

	@OneToMany(mappedBy = "entity", fetch = FetchType.LAZY)
	private Set<Email> emails;

	@OneToMany(mappedBy = "entity", fetch = FetchType.LAZY)
	private Set<Phone> phones;

	@OneToMany(mappedBy = "entity", fetch = FetchType.LAZY)
	private Set<Perfil> perfil;

	@OneToMany(mappedBy = "entity", fetch = FetchType.LAZY)
	private Set<Document> documents;

	
	@OneToMany(mappedBy = "entity", fetch = FetchType.LAZY)
	private Set<Perfil> perfils;

	@Column(name = "ENTITY_NAME")
	private String name;

	@OneToOne(mappedBy = "entity", fetch = FetchType.LAZY)
	private Login login;

	@OneToOne(mappedBy = "entity", fetch = FetchType.LAZY)
	private Company company;
	
	@Column(name = "ENTITY_TYPE")
	private String type;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ENTITY_STATUS_ID", insertable = false, updatable = false)
	private EntityStatus entityStatus;

	@Column(name = "COUNTRY_CODE")
	private Integer countryId;

	@Column(name = "ENTITY_STATUS_ID")
	private Integer entityStatusCode;

	@Column(name = "ENTITY_PARENT")
	@Type(type = "true_false")
	private Boolean entityParent;

	@Column(name = "ENTITY_DATE_REGISTRATION")
	@Temporal(TemporalType.TIMESTAMP)
	@DateTimeFormat(style = "M-")
	private Date registrationDate;

	@Column(name = "FOREIGN_REGISTER")
	@Type(type = "true_false")
	private Boolean foreignRegister;

	@Column(name = "ENTITY_DATE_APPROVER")
	@Temporal(TemporalType.TIMESTAMP)
	@DateTimeFormat(style = "M-")
	private Date approvalDate;

	@Column(name = "ENTITY_APPROVER")
	private String entityApprover;

	@Column(name = "ENTITY_CIF")
	private String cif;

	@Column(name = "ENTITY_RECEIVE_INFO_EMAIL")
	@Type(type = "true_false")
	private Boolean receiveInfoEmail;

	@Column(name = "MARKETING_TYPE_ID")
	private Long marketingTypeId;

	@Column(name = "MARKETING_TYPE_DESC")
	private String marketingTypeDesc;

	@Column(name = "ENTITY_DATE_CONFIRM")
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(style = "M-")
	private Date confirmationDate;

	@Column(name = "ENTITY_PORTAL_REGISTRATION")
	private Integer portalId;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ENTITY_PORTAL_REGISTRATION", insertable = false, updatable = false)
	private Portal portal;

	@Column(name = "ENTITY_LAST_UPDATE")
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(style = "M-")
	private Date lastUpdateDate;

    @OneToMany(mappedBy = "entity")
    private Set<Company> companies = new HashSet<Company>(0);

	@Column(name = "VERSAO_CADASTRO", nullable = true, insertable = true, updatable = true, precision = 0)
	private String versaoCadastro;


	public Integer getCountryId() {
		return countryId;
	}

	public void setCountryId(Integer countryId) {
		this.countryId = countryId;
	}

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Set<Email> getEmails() {
		return emails;
	}

	@Transient
	public Email getEmailMaster() {
		for(Email email:getEmails()){
			if(email.getMaster() == true){
				return email;
			}
		}
		return null;
	}

	public void setEmails(Set<Email> emails) {
		this.emails = emails;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public EntityStatus getEntityStatus() {
		return entityStatus;
	}

	public void setEntityStatus(EntityStatus entityStatus) {
		this.entityStatus = entityStatus;
	}

	public Integer getEntityStatusCode() {
		return entityStatusCode;
	}

	public void setEntityStatusCode(Integer entityStatusCode) {
		this.entityStatusCode = entityStatusCode;
	}

	public Boolean getEntityParent() {
		return entityParent;
	}

	public void setEntityParent(Boolean entityParent) {
		this.entityParent = entityParent;
	}

	public Date getRegistrationDate() {
		return registrationDate;
	}

	public void setRegistrationDate(Date registrationDate) {
		this.registrationDate = registrationDate;
	}

	public Date getApprovalDate() {
		return approvalDate;
	}

	public void setApprovalDate(Date approvalDate) {
		this.approvalDate = approvalDate;
	}

	public String getEntityApprover() {
		return entityApprover;
	}

	public void setEntityApprover(String entityApprover) {
		this.entityApprover = entityApprover;
	}

	public String getCif() {
		return cif;
	}

	public void setCif(String cif) {
		this.cif = cif;
	}

	public Boolean getReceiveInfoEmail() {
		return receiveInfoEmail;
	}

	public void setReceiveInfoEmail(Boolean receiveInfoEmail) {
		this.receiveInfoEmail = receiveInfoEmail;
	}

	public Long getMarketingTypeId() {
		return marketingTypeId;
	}

	public String getMarketingTypeDesc() {
		return marketingTypeDesc;
	}

	public void setMarketingTypeDesc(String marketingTypeDesc) {
		this.marketingTypeDesc = marketingTypeDesc;
	}

	public void setMarketingTypeId(Long marketingTypeId) {
		this.marketingTypeId = marketingTypeId;
	}

	public Date getConfirmationDate() {
		return confirmationDate;
	}

	public void setConfirmationDate(Date confirmationDate) {
		this.confirmationDate = confirmationDate;
	}

	public Integer getPortalId() {
		return portalId;
	}

	public void setPortalId(Integer portalId) {
		this.portalId = portalId;
	}

	public Date getLastUpdateDate() {
		return lastUpdateDate;
	}

	public void setLastUpdateDate(Date lastUpdateDate) {
		this.lastUpdateDate = lastUpdateDate;
	}

	public Set<Company> getCompanies() {
		return companies;
	}

	public void setCompanies(Set<Company> companies) {
		this.companies = companies;
	}

	public Set<Phone> getPhones() {
		return phones;
	}

	public void setPhones(Set<Phone> phones) {
		this.phones = phones;
	}

	public Set<Document> getDocuments() {
		return documents;
	}

	public void setDocuments(Set<Document> documents) {
		this.documents = documents;
	}

	@Transient
	public String getDisplayName() {
		String displayName = getName();		
		if (getCompanies() != null && !getCompanies().isEmpty()) {
			Company company = getCompanies().iterator().next();
			if (company.getCompanyFantasyName() != null) {
				displayName = company.getCompanyFantasyName(); 
			}
		}
		return displayName;
	}

	public Portal getPortal() {
		return portal;
	}

	public void setPortal(Portal portal) {
		this.portal = portal;
	}

	public Set<Perfil> getPerfils() {
		return perfils;
	}

	public void setPerfils(Set<Perfil> perfils) {
		this.perfils = perfils;
	}

	public Login getLogin() {
		return login;
	}

	public void setLogin(Login login) {
		this.login = login;
	}

	public String getVersaoCadastro() {
		return versaoCadastro;
	}

	public void setVersaoCadastro(String versaoCadastro) {
		this.versaoCadastro = versaoCadastro;
	}

	public Boolean getForeignRegister() {
		return foreignRegister;
	}

	public void setForeignRegister(Boolean foreignRegister) {
		this.foreignRegister = foreignRegister;
	}

	public Set<Perfil> getPerfil() {
		return perfil;
	}

	public void setPerfil(Set<Perfil> perfil) {
		this.perfil = perfil;
	}

	@Override
	public String toString() {
		return "UserEntity{" +
				"id=" + id +
				", emails=" + emails +
				", phones=" + phones +
				", perfil=" + perfil +
				", documents=" + documents +
				", perfils=" + perfils +
				", name='" + name + '\'' +
				", login=" + login +
				", company=" + company +
				", type='" + type + '\'' +
				", entityStatus=" + entityStatus +
				", countryId=" + countryId +
				", entityStatusCode=" + entityStatusCode +
				", entityParent=" + entityParent +
				", registrationDate=" + registrationDate +
				", foreignRegister=" + foreignRegister +
				", approvalDate=" + approvalDate +
				", entityApprover='" + entityApprover + '\'' +
				", cif='" + cif + '\'' +
				", receiveInfoEmail=" + receiveInfoEmail +
				", marketingTypeId=" + marketingTypeId +
				", marketingTypeDesc='" + marketingTypeDesc + '\'' +
				", confirmationDate=" + confirmationDate +
				", portalId=" + portalId +
				", portal=" + portal +
				", lastUpdateDate=" + lastUpdateDate +
				", companies=" + companies +
				", versaoCadastro='" + versaoCadastro + '\'' +
				'}';
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		UserEntity entity = (UserEntity) o;

		if (id != null ? !id.equals(entity.id) : entity.id != null) return false;
		if (emails != null ? !emails.equals(entity.emails) : entity.emails != null) return false;
		if (phones != null ? !phones.equals(entity.phones) : entity.phones != null) return false;
		if (perfil != null ? !perfil.equals(entity.perfil) : entity.perfil != null) return false;
		if (documents != null ? !documents.equals(entity.documents) : entity.documents != null) return false;
		if (perfils != null ? !perfils.equals(entity.perfils) : entity.perfils != null) return false;
		if (name != null ? !name.equals(entity.name) : entity.name != null) return false;
		if (login != null ? !login.equals(entity.login) : entity.login != null) return false;
		if (company != null ? !company.equals(entity.company) : entity.company != null) return false;
		if (type != null ? !type.equals(entity.type) : entity.type != null) return false;
		if (entityStatus != null ? !entityStatus.equals(entity.entityStatus) : entity.entityStatus != null)
			return false;
		if (countryId != null ? !countryId.equals(entity.countryId) : entity.countryId != null) return false;
		if (entityStatusCode != null ? !entityStatusCode.equals(entity.entityStatusCode) : entity.entityStatusCode != null)
			return false;
		if (entityParent != null ? !entityParent.equals(entity.entityParent) : entity.entityParent != null)
			return false;
		if (registrationDate != null ? !registrationDate.equals(entity.registrationDate) : entity.registrationDate != null)
			return false;
		if (foreignRegister != null ? !foreignRegister.equals(entity.foreignRegister) : entity.foreignRegister != null)
			return false;
		if (approvalDate != null ? !approvalDate.equals(entity.approvalDate) : entity.approvalDate != null)
			return false;
		if (entityApprover != null ? !entityApprover.equals(entity.entityApprover) : entity.entityApprover != null)
			return false;
		if (cif != null ? !cif.equals(entity.cif) : entity.cif != null) return false;
		if (receiveInfoEmail != null ? !receiveInfoEmail.equals(entity.receiveInfoEmail) : entity.receiveInfoEmail != null)
			return false;
		if (marketingTypeId != null ? !marketingTypeId.equals(entity.marketingTypeId) : entity.marketingTypeId != null)
			return false;
		if (marketingTypeDesc != null ? !marketingTypeDesc.equals(entity.marketingTypeDesc) : entity.marketingTypeDesc != null)
			return false;
		if (confirmationDate != null ? !confirmationDate.equals(entity.confirmationDate) : entity.confirmationDate != null)
			return false;
		if (portalId != null ? !portalId.equals(entity.portalId) : entity.portalId != null) return false;
		if (portal != null ? !portal.equals(entity.portal) : entity.portal != null) return false;
		if (lastUpdateDate != null ? !lastUpdateDate.equals(entity.lastUpdateDate) : entity.lastUpdateDate != null)
			return false;
		if (companies != null ? !companies.equals(entity.companies) : entity.companies != null) return false;
		if (versaoCadastro != null ? !versaoCadastro.equals(entity.versaoCadastro) : entity.versaoCadastro != null)
			return false;

		return true;
	}

	@Override
	public int hashCode() {
		int result = id != null ? id.hashCode() : 0;
		result = 31 * result + (emails != null ? emails.hashCode() : 0);
		result = 31 * result + (phones != null ? phones.hashCode() : 0);
		result = 31 * result + (perfil != null ? perfil.hashCode() : 0);
		result = 31 * result + (documents != null ? documents.hashCode() : 0);
		result = 31 * result + (perfils != null ? perfils.hashCode() : 0);
		result = 31 * result + (name != null ? name.hashCode() : 0);
		result = 31 * result + (login != null ? login.hashCode() : 0);
		result = 31 * result + (company != null ? company.hashCode() : 0);
		result = 31 * result + (type != null ? type.hashCode() : 0);
		result = 31 * result + (entityStatus != null ? entityStatus.hashCode() : 0);
		result = 31 * result + (countryId != null ? countryId.hashCode() : 0);
		result = 31 * result + (entityStatusCode != null ? entityStatusCode.hashCode() : 0);
		result = 31 * result + (entityParent != null ? entityParent.hashCode() : 0);
		result = 31 * result + (registrationDate != null ? registrationDate.hashCode() : 0);
		result = 31 * result + (foreignRegister != null ? foreignRegister.hashCode() : 0);
		result = 31 * result + (approvalDate != null ? approvalDate.hashCode() : 0);
		result = 31 * result + (entityApprover != null ? entityApprover.hashCode() : 0);
		result = 31 * result + (cif != null ? cif.hashCode() : 0);
		result = 31 * result + (receiveInfoEmail != null ? receiveInfoEmail.hashCode() : 0);
		result = 31 * result + (marketingTypeId != null ? marketingTypeId.hashCode() : 0);
		result = 31 * result + (marketingTypeDesc != null ? marketingTypeDesc.hashCode() : 0);
		result = 31 * result + (confirmationDate != null ? confirmationDate.hashCode() : 0);
		result = 31 * result + (portalId != null ? portalId.hashCode() : 0);
		result = 31 * result + (portal != null ? portal.hashCode() : 0);
		result = 31 * result + (lastUpdateDate != null ? lastUpdateDate.hashCode() : 0);
		result = 31 * result + (companies != null ? companies.hashCode() : 0);
		result = 31 * result + (versaoCadastro != null ? versaoCadastro.hashCode() : 0);
		return result;
	}
}
