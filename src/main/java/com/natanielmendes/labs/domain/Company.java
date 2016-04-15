package com.natanielmendes.labs.domain;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.Table;

@SuppressWarnings("serial")
@javax.persistence.Entity
@Table(name = "COMPANY")
@NamedQueries({
	
})
public class Company implements java.io.Serializable {

	public static final class Queries {
	}

	@Id
	@Column(name = "ENTITY_ID", unique = true, nullable = false)
	private Long id;

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ENTITY_ID", unique = true, nullable = false, insertable = false, updatable = false)
	private UserEntity entity;

	@Column(name = "COMPANY_FANTASY_NAME", length = 100)
	private String companyFantasyName;

	@Column(name = "COMPANY_ANNUAL_INCOME", precision = 9, scale = 0)
	private Integer companyAnnualIncome;

	@Column(name = "COMPANY_QTD_EMPLOYEE", precision = 9, scale = 0)
	private Integer companyQtdEmployee;

	@Column(name = "COMPANY_URL", length = 120)
	private String companyUrl;

	@Column(name = "ACTIVITY_BRANCH_ID", precision = 9, scale = 0)
	private Integer activityBranchId;

	@Column(name = "COMPANY_CONTACT", length = 105)
	private String companyContact;

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		Company other = (Company) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	public UserEntity getEntity() {
		return entity;
	}

	public void setEntity(UserEntity entity) {
		this.entity = entity;
	}

	public String getCompanyFantasyName() {
		return companyFantasyName;
	}

	public void setCompanyFantasyName(String companyFantasyName) {
		this.companyFantasyName = companyFantasyName;
	}

	public Integer getCompanyAnnualIncome() {
		return companyAnnualIncome;
	}

	public void setCompanyAnnualIncome(Integer companyAnnualIncome) {
		this.companyAnnualIncome = companyAnnualIncome;
	}

	public Integer getCompanyQtdEmployee() {
		return companyQtdEmployee;
	}

	public void setCompanyQtdEmployee(Integer companyQtdEmployee) {
		this.companyQtdEmployee = companyQtdEmployee;
	}

	public String getCompanyUrl() {
		return companyUrl;
	}

	public void setCompanyUrl(String companyUrl) {
		this.companyUrl = companyUrl;
	}

	public Integer getActivityBranchId() {
		return activityBranchId;
	}

	public void setActivityBranchId(Integer activityBranchId) {
		this.activityBranchId = activityBranchId;
	}

	public String getCompanyContact() {
		return companyContact;
	}

	public void setCompanyContact(String companyContact) {
		this.companyContact = companyContact;
	}

	
}
