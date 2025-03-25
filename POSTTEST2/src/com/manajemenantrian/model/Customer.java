package com.manajemenantrian.model;

public class Customer{
    private int id_cust;
    private String nama;
    private String no_telepon;
    private String email;

    public Customer(int id_cust, String nama, String no_telepon){
        this.id_cust = id_cust;
        this.nama = nama;
        this.no_telepon = no_telepon;
    }

    public int getId_cust() {
        return id_cust;
    }
    
    public void setId_cust(int id_cust) {
        this.id_cust = id_cust;
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
    
    public String getEmail() {
        return email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }

    public void tampilkanInfo(){
        System.out.println("ID: " + getId_cust());
        System.out.println("Nama: " + getNama());
        System.out.println("No. Telepon: " + getNo_telepon());
        System.out.println("Email: " + getEmail());
        System.out.println("--------------------------------");
    }
}