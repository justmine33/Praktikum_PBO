package com.manajemenantrian.model;

public final class Antrian{
    public final int no_antrian;
    private String id_mobil;
    public String status_antrian;
    private int waktu_proses;

    public Antrian(int no_antrian, String status_antrian, int waktu_proses, String id_mobil){
        this.no_antrian = no_antrian;
        this.id_mobil = id_mobil;
        this.status_antrian = status_antrian;
        this.waktu_proses = waktu_proses;
    }

    public int getNo_antrian(){
        return no_antrian;
    }

    // public void setNo_antrian(int no_antrian){
    //     this.no_antrian = no_antrian;
    // }
    
    public String getId_mobil(){
        return id_mobil;
    }

    public void setId_mobil(String id_mobil){
        this.id_mobil = id_mobil;
    }

    public String getStatus_antrian(){
        return status_antrian;
    }

    public void setStatus_antrian(String status_antrian){
        this.status_antrian = status_antrian;
    }
    
    public int getWaktu_proses(){
        return waktu_proses;
    }

    public void setWaktu_proses(int waktu_proses){
        this.waktu_proses = waktu_proses;
    }


    public final void tampilkanInfo(){
        System.out.println("No Antrian: " + no_antrian);
        System.out.println("Plat Mobil: " + id_mobil);
        System.out.println("Status Antrian: " + status_antrian);
        System.out.println("Waktu Proses: " + waktu_proses + " minit");
        System.out.println("===================================");
    }
}
