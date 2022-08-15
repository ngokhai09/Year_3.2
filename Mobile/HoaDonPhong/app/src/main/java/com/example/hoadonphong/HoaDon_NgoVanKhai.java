package com.example.hoadonphong;

import java.io.Serializable;

public class HoaDon_NgoVanKhai implements Serializable, Comparable<HoaDon_NgoVanKhai> {
    private int id;
    private String name;
    private int room;
    private int price;
    private int day;

    public HoaDon_NgoVanKhai(int id, String name, int room, int price, int day) {
        this.id = id;
        this.name = name;
        this.room = room;
        this.price = price;
        this.day = day;
    }

    public HoaDon_NgoVanKhai(String name, int room, int price, int day) {
        this.name = name;
        this.room = room;
        this.price = price;
        this.day = day;
    }

    public HoaDon_NgoVanKhai() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String iame) {
        this.name = iame;
    }

    public int getRoom() {
        return room;
    }

    public void setRoom(int room) {
        this.room = room;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public int getTotal(){
        return this.day * this.price;
    }

    @Override
    public int compareTo(HoaDon_NgoVanKhai o) {
        return Integer.compare(this.getTotal(), o.getTotal());
    }
}
