package com.manajemenantrian.manajemen;
import java.util.ArrayList;
import java.util.Scanner;
import com.manajemenantrian.model.Transaksi;
import com.manajemenantrian.model.Customer;


public class ManajemenTransaksi{
    ArrayList<Transaksi> DaftarTransaksi = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);
    private ManajemenCustomer manajemenCustomer;

    public ManajemenTransaksi(ManajemenCustomer manajemenCustomer) {
        this.manajemenCustomer = manajemenCustomer;
    }
    
    public void tampilkan_transaksi(){
        if (DaftarTransaksi.isEmpty()){
            System.out.println("\n=======================");
            System.out.println("Tidak ada transaksi");
            System.out.println("=======================");
            return;
        }

        for(Transaksi transaksi : DaftarTransaksi){
            System.out.println("\n========Daftar Transaksi========");
            transaksi.tampilkanInfo();
        }
    }


    // public void tambah_transaksi() {
    //     System.out.println("\n======== Tambah Transaksi ========");

    //     manajemenCustomer.tampilkan_customer();
        
    //     System.out.print("Pilih ID Customer: ");
    //     int idCustomer = scanner.nextInt();
    //     scanner.nextLine();
        
    //     boolean customerDitemukan = false;
    //     for (Customer customer : manajemenCustomer.getDaftarCustomer()) {
    //         if (customer.getId_cust() == idCustomer) {
    //             customerDitemukan = true;
    //             break;
    //         }
    //     }
        
    //     if (!customerDitemukan) {
    //         System.out.println("ID Customer tidak ditemukan!");
    //         return;
    //     }

    //     System.out.print("Kode Transaksi: ");
    //     int kodePembayaran = scanner.nextInt();
    //     scanner.nextLine();

    //     for (Transaksi transaksi : DaftarTransaksi) {
    //         if (transaksi.getKode_transaksi() == kodePembayaran) {
    //             System.out.println("Kode transaksi telah digunakan!");
    //             return;
    //         }
    //     }

    //     System.out.print("Harga: ");
    //     double harga = scanner.nextDouble();

    //     System.out.print("Diskon (%): ");
    //     double diskon = scanner.nextDouble();
    //     scanner.nextLine();

    //     double hargaAkhir = harga - (harga * diskon / 100);

    //     Transaksi transaksiBaru = new Transaksi(kodePembayaran, idCustomer, harga, diskon, "Pending");
    //     DaftarTransaksi.add(transaksiBaru);
    //     System.out.println("Transaksi berhasil ditambahkan.");
    //     System.out.println("Harga setelah diskon: Rp " + hargaAkhir);
    // }

    public void tambah_transaksi() {
        System.out.println("\n======== Tambah Transaksi ========");
        
        if (manajemenCustomer.getDaftarCustomer().isEmpty()) {
            System.out.println("Belum ada customer terdaftar. Silakan tambahkan customer terlebih dahulu.");
            manajemenCustomer.tambah_customer();
        }
        
        manajemenCustomer.tampilkan_customer();
        System.out.print("Pilih ID Customer: ");
        int idCustomer = scanner.nextInt();
        scanner.nextLine();
        
        boolean customerDitemukan = false;
        for (Customer customer : manajemenCustomer.getDaftarCustomer()) {
            if (customer.getId_cust() == idCustomer) {
                customerDitemukan = true;
                break;
            }
        }
        
        if (!customerDitemukan) {
            System.out.println("ID Customer tidak ditemukan!");
            return;
        }
        
        System.out.print("Kode Transaksi: ");
        int kodePembayaran = scanner.nextInt();
        scanner.nextLine();
        
        for (Transaksi transaksi : DaftarTransaksi) {
            if (transaksi.getKode_transaksi() == kodePembayaran) {
                System.out.println("Kode transaksi telah digunakan!");
                return;
            }
        }
        
        System.out.print("Harga: ");
        double harga = scanner.nextDouble();
        
        System.out.print("Diskon (%): ");
        double diskon = scanner.nextDouble();
        scanner.nextLine();
        
        Transaksi transaksiBaru = new Transaksi(kodePembayaran, idCustomer, harga, diskon, "Pending");
        DaftarTransaksi.add(transaksiBaru);
        
        double hargaAkhir = transaksiBaru.hitungTotal(diskon);
        
        System.out.println("Transaksi berhasil ditambahkan.");
        System.out.println("Harga setelah diskon: Rp " + hargaAkhir);
    }


    public void ubah_status_transaksi() {
        tampilkan_transaksi();
        System.out.println("Masukkan Kode Transaksi yang ingin diubah: ");
        int kodeUbahTransaksi = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Masukkan Status Baru: ");
        String statusBaru = scanner.nextLine();

        for (Transaksi transaksi : DaftarTransaksi) {
            if (transaksi.kode_transaksi == kodeUbahTransaksi) {
                transaksi.status_transaksi = statusBaru;
                System.out.println("Status transaksi dengan kode " + kodeUbahTransaksi + " berhasil diubah menjadi: " + statusBaru);
                return;
            }
        }
        System.out.println("Transaksi dengan kode " + kodeUbahTransaksi + " tidak ditemukan.");
    }  
    
    public void hapus_transaksi() {
        tampilkan_transaksi();
        System.out.println("Masukkan kode transaksi yang ingin dihapus");
        int noHapusTransaksi = scanner.nextInt();
        for (int i = 0; i < DaftarTransaksi.size(); i++) {
            if (DaftarTransaksi.get(i).kode_transaksi == noHapusTransaksi) {
                DaftarTransaksi.remove(i);
                System.out.println("Antrian berhasil dihapus.");
                return;
            }
        }
        System.out.println("Antrian tidak ditemukan.");
    }

}
