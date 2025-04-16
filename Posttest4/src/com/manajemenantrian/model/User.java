package com.manajemenantrian.model;

public class User {
    protected String nama;
    protected String no_telepon;

    public User(String nama, String no_telepon) {
        this.nama = nama;
        this.no_telepon = no_telepon;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getNo_telepon() {
        return no_telepon;
    }

    public void setNo_telepon(String no_telepon) {
        this.no_telepon = no_telepon;
    }

    public void tampilkanInfo() {
        System.out.println("Nama: " + nama);
        System.out.println("No. Telepon: " + no_telepon);
    }
}
