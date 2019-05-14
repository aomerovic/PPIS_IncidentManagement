package com.incidentmng.incidentmng.model;


import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "service")
public class Services {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = javax.persistence.GenerationType.IDENTITY,generator = "service_seq" )
    @SequenceGenerator(name = "service_seq", sequenceName = "service_seq", allocationSize = 1)
    private long id;

    @Column(name = "service")
    @NotNull
    private String service;

    @Column(name = "price")
    @NotNull
    private double service_price;


    public Services() {
    }


    public Services(@NotNull String service, @NotNull double service_price) {
        this.service = service;
        this.service_price = service_price;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getService() {
        return service;
    }

    public void setService(String service) {
        this.service = service;
    }

    public double getService_price() {
        return service_price;
    }

    public void setService_price(double service_price) {
        this.service_price = service_price;
    }
}
