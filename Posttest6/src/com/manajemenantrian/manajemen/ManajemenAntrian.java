package com.manajemenantrian.manajemen;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import com.manajemenantrian.model.Antrian;
import com.manajemenantrian.model.Customer;
import com.manajemenantrian.model.LayananCarwash;

public class ManajemenAntrian{
    ArrayList<Antrian> DaftarAntrian = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);
    private ManajemenCustomer manajemenCustomer;
    
    
    public ManajemenAntrian(ManajemenCustomer manajemenCustomer) {
        this.manajemenCustomer = manajemenCustomer;

    }

    public void tampilkan_antrian(){
        if (DaftarAntrian.isEmpty()) {
            System.out.println("\n=======================");
            System.out.println("Tidak ada antrian.");
            System.out.println("=======================");
            return;
        }

        for(int i = 0; i< DaftarAntrian.size(); i++){
            System.out.println("=========Daftar Antrian========");
            DaftarAntrian.get(i).tampilkanInfo();
        }
    }

    public void tambah_antrian() {
        System.out.println("\n======== Tambah Antrian ========");

        try {
            if (manajemenCustomer.getDaftarCustomer().isEmpty()) {
                System.out.println("Belum ada customer terdaftar. Silakan tambahkan customer terlebih dahulu.");
                manajemenCustomer.tambah_customer();
            }

            manajemenCustomer.tampilkan_customer();
            System.out.print("Pilih ID Customer: ");
            int idCustomer = scanner.nextInt();
            scanner.nextLine();

            boolean customerDitemukan = false;
            for(Customer customer : manajemenCustomer.getDaftarCustomer()){
                if(customer.getId_cust() == idCustomer){
                    customerDitemukan = true;
                    break;
                }
            }

            if(!customerDitemukan){
                throw new Exception("ID Customer tidak ditemukan!");
            }

            System.out.print("Nomor Antrian: ");
            int noAntrian = scanner.nextInt();
            scanner.nextLine(); 

            for (Antrian antrian : DaftarAntrian) {
                if (antrian.getNo_antrian() == noAntrian) {
                    throw new Exception("Nomor antrian sudah ada! Silakan masukkan nomor lain.");
                }
            }

            System.out.print("Plat Mobil: ");
            String idMobil = scanner.nextLine();
            
            String[] daftarLayanan = LayananCarwash.getDaftarLayanan();
            for (int i = 0; i < daftarLayanan.length; i++) {
                System.out.println((i+1) + ". " + daftarLayanan[i]);
            }
            
            System.out.print("\nPilih Layanan (1-" + daftarLayanan.length + "): ");
            int pilihan = scanner.nextInt();
            scanner.nextLine();
            
            if (pilihan < 1 || pilihan > daftarLayanan.length) {
                throw new Exception("Pilihan layanan tidak valid!");
            }
            
            String jenisLayanan = daftarLayanan[pilihan-1];

            LayananCarwash layanan = new LayananCarwash(jenisLayanan, "");
            int waktuProses = layanan.hitungEstimasiWaktu(jenisLayanan);

            Antrian antrianBaru = new Antrian(noAntrian, "proses", waktuProses, idMobil);
            DaftarAntrian.add(antrianBaru);
            System.out.println("Antrian berhasil ditambahkan.");
            System.out.println("Estimasi waktu proses: " + waktuProses + " menit");
        } catch (InputMismatchException e) {
            System.out.println("Error: Format input tidak valid!");
            scanner.nextLine(); 
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public void hapus_antrian() {
        tampilkan_antrian();

        try {
            if (DaftarAntrian.isEmpty()) {
                System.out.println("Tidak ada antrian untuk dihapus.");
                return;
            }
            
            System.out.print("Masukkan No. Antrian yang ingin dihapus: ");
            int noAntrian = scanner.nextInt();

            boolean antrianDitemukan = false;
            for (int i = 0; i < DaftarAntrian.size(); i++) {
                if (DaftarAntrian.get(i).getNo_antrian() == noAntrian) {
                    DaftarAntrian.remove(i);
                    antrianDitemukan = true;
                    System.out.println("\nAntrian berhasil dihapus.");
                    break;
                }
            }
            
            if (!antrianDitemukan) {
                throw new Exception("Antrian dengan nomor " + noAntrian + " tidak ditemukan.");
            }
        } catch (InputMismatchException e) {
            System.out.println("Error: Harap masukkan nomor antrian dengan benar!");
            scanner.nextLine();
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public void ubah_status_antrian() {
        tampilkan_antrian();
        
        try {
            if (DaftarAntrian.isEmpty()) {
                System.out.println("Tidak ada antrian untuk diubah.");
                return;
            }
            
            System.out.print("Masukkan No. Antrian yang ingin diubah statusnya: ");
            int noUbahAntrian = scanner.nextInt();
            scanner.nextLine();

            boolean antrianDitemukan = false;
            for (Antrian antrian : DaftarAntrian) {
                if (antrian.no_antrian == noUbahAntrian) {
                    System.out.println("Status saat ini: " + antrian.status_antrian);
                    System.out.println("Pilih status baru:");
                    System.out.println("1. Menunggu");
                    System.out.println("2. Proses");
                    System.out.println("3. Selesai");
                    System.out.print("Pilihan (1-3): ");
                    
                    int pilihan = scanner.nextInt();
                    scanner.nextLine();
                    
                    String statusBaru;
                    switch(pilihan) {
                        case 1:
                            statusBaru = "menunggu";
                            break;
                        case 2:
                            statusBaru = "proses";
                            break;
                        case 3:
                            statusBaru = "selesai";
                            break;
                        default:
                            throw new Exception("Pilihan tidak valid!");
                    }
                    
                    antrian.status_antrian = statusBaru;
                    antrianDitemukan = true;
                    System.out.println("Status antrian nomor " + noUbahAntrian + " berhasil diubah menjadi: " + statusBaru);
                    break;
                }
            }
            
            if (!antrianDitemukan) {
                throw new Exception("Antrian dengan nomor " + noUbahAntrian + " tidak ditemukan.");
            }
        } catch (InputMismatchException e) {
            System.out.println("Error: Format input tidak valid!");
            scanner.nextLine();
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}