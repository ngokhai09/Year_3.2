package com.example.ktra_21_01_2022;

public class Person {
    private String Name;
    private String Phone;
    private String Que;
    private String GioiTinh;

    public Person(String name, String phone, String que, String gioiTinh) {
        Name = name;
        Phone = phone;
        Que = que;
        GioiTinh = gioiTinh;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String phone) {
        Phone = phone;
    }

    public String getQue() {
        return Que;
    }

    public void setQue(String que) {
        Que = que;
    }

    public String getGioiTinh() {
        return GioiTinh;
    }

    public void setGioiTinh(String gioiTinh) {
        GioiTinh = gioiTinh;
    }

    @Override
    public String toString() {
        return Name + " - " + GioiTinh + " - " + Phone + " - " + Que;

    }
}
