package com.example.baithi3;

import java.io.Serializable;

public class HoaDon_NguyenThiNgu implements Serializable {
    private int ID;
    private String Name;
    private int soPhong;
    private int donGia;
    private int soNgay;

    public HoaDon_NguyenThiNgu() {
    }

    public HoaDon_NguyenThiNgu(String name, int soPhong, int donGia, int soNgay) {
        Name = name;
        this.soPhong = soPhong;
        this.donGia = donGia;
        this.soNgay = soNgay;
    }

    public HoaDon_NguyenThiNgu(int ID, String name, int soPhong, int donGia, int soNgay) {
        this.ID = ID;
        Name = name;
        this.soPhong = soPhong;
        this.donGia = donGia;
        this.soNgay = soNgay;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public int getSoPhong() {
        return soPhong;
    }

    public void setSoPhong(int soPhong) {
        this.soPhong = soPhong;
    }

    public int getSoNgay() {
        return soNgay;
    }

    public void setSoNgay(int soNgay) {
        this.soNgay = soNgay;
    }

    public int getDonGia() {
        return donGia;
    }

    public void setDonGia(int donGia) {
        this.donGia = donGia;
    }
    public int tongTien(){
        return this.donGia * this.soNgay;
    }

    @Override
    public String toString() {
        return "ID=" + ID +
                ", Name=" + Name +
                ", soPhong=" + soPhong +
                ", donGia=" + donGia +
                ", soNgay=" + soNgay ;
    }
}
