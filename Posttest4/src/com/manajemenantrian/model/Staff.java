package com.manajemenantrian.model;

public class Staff extends User {
    private int id_staff;

    public Staff(int id_staff, String nama, String no_telepon) {
        super(nama, no_telepon);
        this.id_staff = id_staff;
    }

    public int getId_staff() {
        return id_staff;
    }

    public void setId_staff(int id_staff) {
        this.id_staff = id_staff;
    }

    @Override
    public void tampilkanInfo() {
        System.out.println("ID Staff: " + id_staff);
        super.tampilkanInfo();
        System.out.println("--------------------------------");
    }
}