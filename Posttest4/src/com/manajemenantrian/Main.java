    package com.manajemenantrian;

import com.manajemenantrian.manajemen.ManajemenCustomer;
import com.manajemenantrian.manajemen.ManajemenAntrian;
import com.manajemenantrian.manajemen.ManajemenTransaksi;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        ManajemenCustomer manajemenCustomer = new ManajemenCustomer();
        ManajemenAntrian manajemenAntri = new ManajemenAntrian(manajemenCustomer);
        ManajemenTransaksi manajemenTransaksi = new ManajemenTransaksi(manajemenCustomer);

        int pilihan;
        do {
            System.out.println("\n=== MENU UTAMA ===");
            System.out.println("1. Admin");
            System.out.println("2. Customer");
            System.out.println("3. Staff");
            System.out.println("0. Keluar");
            System.out.print("Pilih menu: ");
            pilihan = input.nextInt();

            switch (pilihan) {
                case 1:
                    menuAdmin(input, manajemenAntri, manajemenTransaksi, manajemenCustomer);
                    break;
                case 2:
                    menuCustomer(input, manajemenAntri);
                    break;
                case 3:
                    menuStaff(input, manajemenAntri);
                    break;
                case 0:
                    System.out.println("Keluar dari program.");
                    break;
                default:
                    System.out.println("Pilihan tidak valid!");
            }
        } while (pilihan != 0);
        input.close();
    }

    public static void menuAdmin(Scanner input, ManajemenAntrian manajemenAntrian, ManajemenTransaksi manajemenTransaksi, ManajemenCustomer manajemenCustomer) {
        int pilihan;
        do {
            System.out.println("\n=== MENU ADMIN ===");
            System.out.println("1. Tambah Antrian");
            System.out.println("2. Tampilkan Antrian");
            System.out.println("3. Hapus Antrian");
            System.out.println("4. Tambah Transaksi");
            System.out.println("5. Lihat Daftar Transaksi");
            System.out.println("6. Ubah Status Transaksi");
            System.out.println("7. Hapus Transaksi");
            System.out.println("8. Tambah Customer");
            System.out.println("9. Tampilkan daftar Customer");
            System.out.println("10. Hapus Data Customer");
            System.out.println("0. Kembali");
            System.out.print("Pilih menu: ");
            pilihan = input.nextInt();
            input.nextLine();

            switch (pilihan) {
                case 1:
                    manajemenAntrian.tambah_antrian();
                    break;
                case 2:
                    manajemenAntrian.tampilkan_antrian();
                    break;
                case 3:
                    manajemenAntrian.hapus_antrian();
                    break;
                case 4:
                    manajemenTransaksi.tambah_transaksi();
                    break;
                case 5:
                    manajemenTransaksi.tampilkan_transaksi();
                    break;
                case 6:
                    manajemenTransaksi.ubah_status_transaksi();
                    break;
                case 7:
                    manajemenTransaksi.hapus_transaksi();
                    break;
                case 8:
                    manajemenCustomer.tambah_customer();
                    break;
                case 9:
                    manajemenCustomer.tampilkan_customer();
                    break;
                case 10:
                    manajemenCustomer.hapus_customer();
                    break;
                case 0:
                    System.out.println("Kembali ke menu utama.");
                    break;
                default:
                    System.out.println("Pilihan tidak valid!");
            }
        } while (pilihan != 0);
    }

    public static void menuCustomer(Scanner input, ManajemenAntrian manajemenAntri) {
        int pilihan;
        do {
            System.out.println("\n=== MENU CUSTOMER ===");
            System.out.println("1. Lihat Antrian");
            System.out.println("0. Kembali");
            System.out.print("Pilih menu: ");
            pilihan = input.nextInt();

            switch (pilihan) {
                case 1:
                    manajemenAntri.tampilkan_antrian();
                    break;
                case 0:
                    System.out.println("Kembali ke menu utama.");
                    break;
                default:
                    System.out.println("Pilihan tidak valid!");
            }
        } while (pilihan != 0);
    }

    public static void menuStaff(Scanner input, ManajemenAntrian manajemenAntri) {
        int pilihan;
        do {
            System.out.println("\n=== MENU STAFF ===");
            System.out.println("1. Lihat Antrian");
            System.out.println("2. Ubah Status Antrian");
            System.out.println("0. Kembali");
            System.out.print("Pilih menu: ");
            pilihan = input.nextInt();

            switch (pilihan) {
                case 1:
                    manajemenAntri.tampilkan_antrian();
                    break;
                case 2:
                    manajemenAntri.ubah_status_antrian();
                    break;
                case 0:
                    System.out.println("Kembali ke menu utama.");
                    break;
                default:
                    System.out.println("Pilihan tidak valid!");
            }
        } while (pilihan != 0);
    }
}