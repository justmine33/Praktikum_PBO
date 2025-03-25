package com.manajemenantrian.model;

public class Staff{
    private int id_staff;
    private String nama;
    private String no_telepon;

    public Staff(int id_staff, String nama, String no_telepon){
        this.id_staff = id_staff;
        this.nama = nama;
        this.no_telepon = no_telepon;
    }

    public int getId_staff() {
        return id_staff;
    }
    
    public void setId_staff(int id_staff) {
        this.id_staff = id_staff;
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
        System.out.println("ID: " + getId_staff());
        System.out.println("Nama: " + getNama());
        System.out.println("No. Telepon: " + getNo_telepon());
        System.out.println("--------------------------------");
    }
}