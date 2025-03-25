package com.manajemenantrian.model;

public class Admin{
    private int id_admin;
    private String nama;
    private String no_telepon;

    public Admin(int id_admin, String nama, String no_telepon){
        this.id_admin = id_admin;
        this.nama = nama;
        this.no_telepon = no_telepon;
    }

    public int getId_admin(){
        return id_admin;
    }

    public void setId_admin(int id_admin) {
        this.id_admin = id_admin;
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

    public void tampilkanInfo(){
        System.out.println("ID: " + getId_admin());
        System.out.println("Nama: " + getNama());
        System.out.println("No. Telepon: " + getNo_telepon());
        System.out.println("--------------------------------");
    }
}