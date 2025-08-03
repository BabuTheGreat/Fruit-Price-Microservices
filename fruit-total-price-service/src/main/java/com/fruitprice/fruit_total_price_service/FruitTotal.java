package com.fruitprice.fruit_total_price_service;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

public class FruitTotal {
    private Long id;

    private String fruit;
    private String month;
    @JsonSerialize(using = DecStringSerializer.class)
    private double fmp;
    private int quantity;
    @JsonSerialize(using = DecStringSerializer.class)
    private double total;
    private int port;
    public FruitTotal() {
    }

    public FruitTotal(Long id, String fruit, String month, double fmp, int quantity, double total, int port) {
        this.id = id;
        this.fruit = fruit;
        this.month = month;
        this.fmp = fmp;
        this.quantity = quantity;
        this.total = total;
        this.port = port;
    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFruit() {
        return fruit;
    }

    public void setFruit(String fruit) {
        this.fruit = fruit;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public double getFmp() {
        return fmp;
    }

    public void setFmp(double fmp) {
        this.fmp = fmp;
    }
    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }
}