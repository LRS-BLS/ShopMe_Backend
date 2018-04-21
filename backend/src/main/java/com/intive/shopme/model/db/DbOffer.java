package com.intive.shopme.model.db;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;

@Entity
@Table(name = "OFFER")
@Data
@EqualsAndHashCode(callSuper = true)
public class DbOffer extends DbIdentifiable {

    @Temporal(TemporalType.TIMESTAMP)
    private Date date;
    private String title;
    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private DbCategory category;
    private String baseDescription;
    private Float basePrice;
    private String extendedDescription;
    private Float extendedPrice;
    private String extraDescription;
    private Float extraPrice;
    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private DbOwner owner;
}