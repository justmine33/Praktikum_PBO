package com.manajemenantrian.model;

import com.manajemenantrian.interface_.Layanan;

public class LayananCarwash implements Layanan {
    private String namaLayanan;
    private String deskripsi;

    public static final double DISKON_MEMBER_VIP = 15.0;
    
    public LayananCarwash(String namaLayanan, String deskripsi) {
        this.namaLayanan = namaLayanan;
        this.deskripsi = deskripsi;
    }
    
    public String getNamaLayanan() {
        return namaLayanan;
    }
    
    public void setNamaLayanan(String namaLayanan) {
        this.namaLayanan = namaLayanan;
    }
    
    public String getDeskripsi() {
        return deskripsi;
    }
    
    public void setDeskripsi(String deskripsi) {
        this.deskripsi = deskripsi;
    }
    
    public static String[] getDaftarLayanan() {
        return new String[] {
            "Cuci Biasa", 
            "Cuci + Wax", 
            "Cuci + Polish",
            "Detailing Interior",
            "Detailing Eksterior"
        };
    }
    
    @Override
    public int hitungEstimasiWaktu(String jenisLayanan) {
        switch(jenisLayanan.toLowerCase()) {
            case "cuci biasa":
                return 30;
            case "cuci + wax":
                return 60;
            case "cuci + polish":
                return 90;
            case "detailing interior":
                return 120;
            case "detailing eksterior":
                return 150;
            default:
                return 45;
        }
    }
    
    @Override
    public double hitungBiayaLayanan(String jenisLayanan, boolean memberVIP) {
        double hargaDasar = 0;
        
        switch(jenisLayanan.toLowerCase()) {
            case "cuci biasa":
                hargaDasar = 50000;
                break;
            case "cuci + wax":
                hargaDasar = 100000;
                break;
            case "cuci + polish":
                hargaDasar = 150000;
                break;
            case "detailing interior":
                hargaDasar = 250000;
                break;
            case "detailing eksterior":
                hargaDasar = 300000;
                break;
            default:
                hargaDasar = 75000;
        }
        
        if (memberVIP) {
            return hargaDasar - (hargaDasar * DISKON_MEMBER_VIP / 100);
        }
        
        return hargaDasar;
    }
    
    public void tampilkanInfo() {
        System.out.println("Nama Layanan: " + namaLayanan);
        System.out.println("Deskripsi: " + deskripsi);
        System.out.println("Estimasi Waktu: " + hitungEstimasiWaktu(namaLayanan) + " menit");
        System.out.println("Biaya Normal: Rp " + hitungBiayaLayanan(namaLayanan, false));
        System.out.println("Biaya Member VIP: Rp " + hitungBiayaLayanan(namaLayanan, true));
        System.out.println("--------------------------------");
    }
}