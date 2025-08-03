package com.fruitprice.fruit_month_price_service;


import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;

@Entity
@Table(name = "fruit_month")
public class FruitPrice {
    @Id
    private Long id;
    @Column(name = "fruit")
    private String fruit;
    @Column(name = "mon")
    private String month;
    @JsonSerialize(using = TwoDecSerializer.class)
    @Column(name = "fmp")
    private Double fmp;
    @Transient
    private int port;

    public FruitPrice() {
    }

    public FruitPrice(Long id, String fruit, String month, Double fmp) {
        this.id = id;
        this.fruit = fruit;
        this.month = month;
        this.fmp = fmp;
    }
    
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getfruit() {
        return fruit;
    }
    public void setfruit(String fruit) {
        this.fruit = fruit;
    }
    public String getMonth() {
        return month;
    }
    public void setMonth(String month) {
        this.month = month;
    }
    public Double getFmp() {
        return fmp;
    }

    public void setFmp(Double fmp) {
        this.fmp = fmp;
    }
    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }
}
