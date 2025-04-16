package com.manajemenantrian.model;

public class Admin extends User{
    private int id_admin;

    public Admin(int id_admin, String nama, String no_telepon) {
        super(nama, no_telepon);
        this.id_admin = id_admin;
    }

    public int getId_admin() {
        return id_admin;
    }

    public void setId_admin(int id_admin) {
        this.id_admin = id_admin;
    }

    @Override
    public void tampilkanInfo() {
        System.out.println("ID Admin: " + id_admin);
        super.tampilkanInfo();
        System.out.println("--------------------------------");
    }
}