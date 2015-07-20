package com.edufabricio.labs.domain;

import javax.persistence.*;

@Entity
@Table(name="ADDRESS")
public class Address {

    @Id
    @Column(name = "ADDRESS_ID")
    private Long id;

    @Column(name = "LOCATION")
    private String location;

    @Column(name = "COUNTRY")
    private String country;

    @OneToOne(mappedBy = "address", fetch = FetchType.LAZY)
    private Person person;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }
}
