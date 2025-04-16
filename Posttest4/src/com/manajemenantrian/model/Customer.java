package com.manajemenantrian.model;

public class Customer extends User {
    private int id_cust;
    private String email;

    public Customer(int id_cust, String nama, String no_telepon) {
        super(nama, no_telepon);
        this.id_cust = id_cust;
    }

    public int getId_cust() {
        return id_cust;
    }

    public void setId_cust(int id_cust) {
        this.id_cust = id_cust;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public void tampilkanInfo() {
        System.out.println("ID Customer: " + id_cust);
        super.tampilkanInfo();
        System.out.println("Email: " + email);
        System.out.println("--------------------------------");
    }
}