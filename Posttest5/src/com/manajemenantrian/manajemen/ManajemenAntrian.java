package com.manajemenantrian.manajemen;
import java.util.ArrayList;
import java.util.Scanner;

import com.manajemenantrian.model.Antrian;
import com.manajemenantrian.model.Customer;

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

        if (manajemenCustomer.getDaftarCustomer().isEmpty()) {
            System.out.println("Belum ada customer terdaftar. Silakan tambahkan customer terlebih dahulu.");
            manajemenCustomer.tambah_customer();
        }

        manajemenCustomer.tampilkan_customer();
        System.out.println("Pilih ID Customer: ");
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
            System.out.println("ID Customer tidak ditemukan!");
            return;
        }

        System.out.print("Nomor Antrian: ");
        int noAntrian = scanner.nextInt();
        scanner.nextLine(); 

        for (Antrian antrian : DaftarAntrian) {
            if (antrian.getNo_antrian() == noAntrian) {
                System.out.println("Nomor antrian sudah ada! Silakan masukkan nomor lain.");
                return;
            }
        }

        System.out.println("Plat Mobil: ");
        String idMobil = scanner.nextLine();
        // System.out.print("Status Antrian: ");
        // String statusAntrian = scanner.nextLine();
        System.out.print("Waktu Proses (menit): ");
        int waktuProses = scanner.nextInt();
        scanner.nextLine();

        Antrian antrianBaru = new Antrian(noAntrian, "proses", waktuProses, idMobil);
        DaftarAntrian.add(antrianBaru);
        System.out.println("Antrian berhasil ditambahkan.");
    }

    public void hapus_antrian() {
        tampilkan_antrian();

        System.out.print("Masukkan No. Antrian yang ingin dihapus: ");
        int noAntrian = scanner.nextInt();

        for (int i = 0; i < DaftarAntrian.size(); i++) {
            if (DaftarAntrian.get(i).getNo_antrian() == noAntrian) {
                DaftarAntrian.remove(i);
                System.out.println("\nAntrian berhasil dihapus.");
                return;
            }
        }
        System.out.println("Antrian tidak ditemukan.");
    }

    public void ubah_status_antrian() {
        tampilkan_antrian();
        System.out.print("Masukkan No. Antrian yang ingin diubah statusnya: ");
        int noUbahAntrian = scanner.nextInt();
        scanner.nextLine();

        
        for (Antrian antrian : DaftarAntrian) {
            if (antrian.no_antrian == noUbahAntrian) {
                System.out.print("Masukkan Status Baru: ");
                String statusBaru = scanner.nextLine();
                antrian.status_antrian = statusBaru;
                System.out.println("Status antrian nomor " + noUbahAntrian + " berhasil diubah menjadi: " + statusBaru);
                return;
            }
        }
        System.out.println("Antrian dengan nomor " + noUbahAntrian + " tidak ditemukan.");
    }
}
