package com.manajemenantrian.manajemen;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
import com.manajemenantrian.model.LayananCarwash;

public class ManajemenLayanan {
    private ArrayList<LayananCarwash> daftarLayanan = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);

    private static int jumlahLayanan = 0;

    public static int getJumlahLayanan() {
        return jumlahLayanan;
    }
    
    public ArrayList<LayananCarwash> getDaftarLayanan() {
        return daftarLayanan;
    }
    
    public void tampilkanLayanan() {
        if (daftarLayanan.isEmpty()) {
            System.out.println("\n=======================");
            System.out.println("Tidak ada layanan tersedia.");
            System.out.println("=======================");
            return;
        }
        
        System.out.println("\n========Daftar Layanan========");
        for (LayananCarwash layanan : daftarLayanan) {
            layanan.tampilkanInfo();
        }
    }
    
    public void tambahLayanan() {
        System.out.println("\n======== Tambah Layanan ========");
        
        try {
            System.out.print("Nama Layanan: ");
            String namaLayanan = scanner.nextLine();

            for (LayananCarwash layanan : daftarLayanan) {
                if (layanan.getNamaLayanan().equalsIgnoreCase(namaLayanan)) {
                    System.out.println("Layanan dengan nama tersebut sudah ada!");
                    return;
                }
            }
            
            System.out.print("Deskripsi Layanan: ");
            String deskripsi = scanner.nextLine();
            
            LayananCarwash layananBaru = new LayananCarwash(namaLayanan, deskripsi);
            daftarLayanan.add(layananBaru);
            jumlahLayanan++; 
            
            System.out.println("Layanan berhasil ditambahkan.");
            System.out.println("Total layanan saat ini: " + jumlahLayanan);
            
        } catch (InputMismatchException e) {
            System.out.println("Error: Input tidak valid! Harap masukkan data dengan benar.");
            scanner.nextLine();
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
    
    public void hapusLayanan() {
        if (daftarLayanan.isEmpty()) {
            System.out.println("Tidak ada layanan untuk dihapus.");
            return;
        }
        
        System.out.println("\n======== Hapus Layanan ========");
        tampilkanLayanan();
        
        try {
            System.out.print("Masukkan nama layanan yang ingin dihapus: ");
            String namaHapus = scanner.nextLine();
            
            boolean ditemukan = false;
            for (int i = 0; i < daftarLayanan.size(); i++) {
                if (daftarLayanan.get(i).getNamaLayanan().equalsIgnoreCase(namaHapus)) {
                    daftarLayanan.remove(i);
                    jumlahLayanan--; 
                    ditemukan = true;
                    System.out.println("Layanan berhasil dihapus.");
                    System.out.println("Total layanan saat ini: " + jumlahLayanan);
                    break;
                }
            }
            
            if (!ditemukan) {
                System.out.println("Layanan dengan nama '" + namaHapus + "' tidak ditemukan.");
            }
            
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
    
    public LayananCarwash getLayananByName(String namaLayanan) {
        for (LayananCarwash layanan : daftarLayanan) {
            if (layanan.getNamaLayanan().equalsIgnoreCase(namaLayanan)) {
                return layanan;
            }
        }
        return null;
    }
}