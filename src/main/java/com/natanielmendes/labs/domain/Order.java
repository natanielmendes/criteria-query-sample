package com.natanielmendes.labs.domain;

import org.hibernate.annotations.Formula;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name="ORDER_ITEM")
public class Order {

    @Id
    @Column(name = "ORDER_ID")
    private Long id;

    @Column(name = "ORDER_VALUE")
    private BigDecimal value;

    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(style = "M-")
    @Column(name = "CREATED_AT", columnDefinition = "date")
    private Date createdAt;

    @Column(name = "HOURS_MAX")
    private Integer hoursMax = 24;

    @Formula("DATEADD('HOUR',HOURS_MAX *(-1), CURRENT_DATE())")
    private Date createSinceLimitHours;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BigDecimal getValue() {
        return value;
    }

    public void setValue(BigDecimal value) {
        this.value = value;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Integer getHoursMax() {
        return hoursMax;
    }

    public void setHoursMax(Integer hoursMax) {
        this.hoursMax = hoursMax;
    }

    public Date getCreateSinceLimitHours() {
        return createSinceLimitHours;
    }

    public void setCreateSinceLimitHours(Date createSinceLimitHours) {
        this.createSinceLimitHours = createSinceLimitHours;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", value=" + value +
                ", createdAt=" + createdAt +
                ", hoursMax=" + hoursMax +
                ", createSinceLimitHours=" + createSinceLimitHours +
                '}';
    }
}