package com.manajemenantrian.model;

public final class Transaksi{
    public int kode_transaksi;
    private int id_cust;
    private double harga, diskon;
    public String status_transaksi;

    public Transaksi(int kode_transaksi, int id_cust, double harga, double diskon, String status_transaksi){
        this.kode_transaksi = kode_transaksi;
        this.id_cust = id_cust;
        this.harga = harga;
        this.diskon = diskon;
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

    // public void setHarga(double harga){
    //     this.harga = harga;
    // }

    public double getDiskon() {
        return diskon;
    }
    
    public void setDiskon(double diskon) {
        this.diskon = diskon;
    }

    public String getStatus_transaksi(){
        return status_transaksi;
    }

    public void setStatus_transaksi(String status_transaksi){
        this.status_transaksi = status_transaksi;
    }

    public void tampilkanInfo(){
        System.out.println("Kode Transaksi: " + kode_transaksi);
        System.out.println("ID Customer: " + id_cust);
        System.out.println("Harga Awal: Rp " + harga);
        System.out.println("Diskon: " + diskon + "%");
        double hargaDiskon = harga - (harga * diskon / 100);
        System.out.println("Harga Setelah Diskon: Rp " + hargaDiskon);
        System.out.println("Status: " + status_transaksi);
    }    

    public double hitungTotal() {
        return this.harga;
    }

    public double hitungTotal(double diskon) {
        double total = hitungTotal(); 
        total = total - (total * diskon / 100); 
        return total;
    }
}
