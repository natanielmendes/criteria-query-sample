package com.natanielmendes.labs.domain;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "DOCUMENT_TYPE")

public class DocumentType implements Serializable {

    public static final int DOCUMENT_TYPE_CPF = 4; // necessario para o carregamento no master
    public static final int DOCUMENT_TYPE_RG = 5; // necessario para o carregamento no master

    public static final class Queries {
        public static final String DOCUMENT_TYPE_BY_COUNTRY = "DOCUMENT_TYPE_BY_COUNTRY";
    }

    //Attributes
    @Id
    @Column(name = "DOCUMENT_TYPE_ID")
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "COUNTRY_ID", insertable = false, updatable = false)
    private Country country;

    @Column(name = "DOCUMENT_TYPE_NAME")
    private String name;

    @Column(name = "DOCUMENT_TYPE_DESC")
    private String desc;

    @Column(name = "DOCUMENT_TYPE_DESCRIPTION")
    private String description;

    //Constructors
    public DocumentType() {
    }


    //Methods
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Country getCountryId() {
        return country;
    }

    public void setCountryId(Country countryId) {
        this.country = countryId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}