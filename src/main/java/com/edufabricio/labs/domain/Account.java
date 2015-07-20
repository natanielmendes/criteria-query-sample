package com.edufabricio.labs.domain;

import javax.persistence.*;

@Entity
@Table(name="ACCOUNT")
public class Account {

    @Id
    @Column(name = "ACCOUNT_ID")
    private Long id;

    @Column(name = "ACCOUNT_TYPE")
    private Integer type;

    @OneToOne(mappedBy = "account", fetch = FetchType.LAZY)
    private Person person;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }
}
