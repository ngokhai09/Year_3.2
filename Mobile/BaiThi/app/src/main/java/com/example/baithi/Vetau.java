package com.example.baithi;

import java.io.Serializable;

public class Vetau implements Serializable, Comparable<Vetau> {
    private int id;
    private String start;
    private String finish;
    private float price;
    private boolean revert;

    public Vetau(int id, String start, String finish, float price, boolean revert) {
        this.id = id;
        this.start = start;
        this.finish = finish;
        this.price = price;
        this.revert = revert;
    }

    public Vetau(String start, String finish, float price, boolean revert) {
        this.start = start;
        this.finish = finish;
        this.price = price;
        this.revert = revert;
    }

    public Vetau() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStart() {
        return start;
    }

    public void setStart(String start) {
        this.start = start;
    }

    public String getFinish() {
        return finish;
    }

    public void setFinish(String finish) {
        this.finish = finish;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public boolean isRevert() {
        return revert;
    }

    public void setRevert(boolean revert) {
        this.revert = revert;
    }
    public float getTotal(){
        if(revert){
            float a = price * 2f * 0.95f;
            return Math.round(a * 1000f) / 1000f;

        }
        return Math.round(price * 10000f) / 10000f;
    }

    @Override
    public int compareTo(Vetau o) {
        return Float.compare(o.getTotal(), this.getTotal());
    }
}
