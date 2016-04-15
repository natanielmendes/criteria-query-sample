package com.natanielmendes.labs.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

//Queries
@Entity
@Table(name = "COUNTRY")

public class Country implements Serializable {

    public static final int BRASIL = 1;

    public static final class Queries {
        public static final String AVAILABLE_COUNTRY_DOCUMENTS = "AVAILABLE_COUNTRY_DOCUMENTS";
        public static final String ALL_COUNTRIES = "ALL_COUNTRIES";
    }

    //Attributes
    @Id
    @Column(name = "EREF_COUNTRY_CODE")
    private Integer id;

    @Column(name = "EREF_COUNTRY_NAME")
    private String name;

    @Column(name = "DDI")
    private Integer ddi;

    @Column(name = "ISO3166_ALPHA_2")
    private String sigla;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "country")
    private List<DocumentType> documentType = new ArrayList<DocumentType>(0);


    //Methods
    public int getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDdi() {
        return ddi;
    }

    public void setDdi(Integer ddi) {
        this.ddi = ddi;
    }

    public String getSigla() {
        return sigla;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
    }
}