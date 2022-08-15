package com.example.taxi;

import java.io.Serializable;

public class Taxi implements Serializable, Comparable<Taxi> {
    private int id;
    private String number;
    private float road;
    private float price;
    private float discount;

    public Taxi(int id, String number, float road, float price, float discount) {
        this.id = id;
        this.number = number;
        this.road = road;
        this.price = price;
        this.discount = discount;
    }

    public Taxi(String number, float road, float price, float discount) {
        this.number = number;
        this.road = road;
        this.price = price;
        this.discount = discount;
    }

    public Taxi() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public float getRoad() {
        return road;
    }

    public void setRoad(float road) {
        this.road = road;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public float getDiscount() {
        return discount;
    }

    public void setDiscount(float discount) {
        this.discount = discount;
    }

    public float getTotal() {
        return price * road * (100 - discount) / 100;
    }

    @Override
    public int compareTo(Taxi o) {
        return this.getNumber().compareTo(o.getNumber());
    }
}
