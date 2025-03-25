package com.manajemenantrian.model;

public class Transaksi{
    public int kode_transaksi;
    private int id_cust;
    private double harga;
    public String status_transaksi;

    public Transaksi(int kode_transaksi, int id_cust, double harga, String status_transaksi){
        this.kode_transaksi = kode_transaksi;
        this.id_cust = id_cust;
        this.harga = harga;
        this.status_transaksi = status_transaksi;
    }

    public int getKode_transaksi(){
        return kode_transaksi;
    }

    public void setKode_transaksi(int kode_transaksi){
        this.kode_transaksi = kode_transaksi;
    }

    public double getHarga(){
        return harga;
    }

    public void setHarga(double harga){
        this.harga = harga;
    }

    public String getStatus_transaksi(){
        return status_transaksi;
    }

    public void setStatus_transaksi(String status_transaksi){
        this.status_transaksi = status_transaksi;
    }

    public void tampilkanInfo(){
        System.out.println("Kode Transaksi: " + kode_transaksi);
        System.out.println("Id Cust: " + id_cust);
        System.out.println("Total: " + harga);
        System.out.println("Status: " + status_transaksi);
    }
}
