package com.manajemenantrian.manajemen;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
import com.manajemenantrian.model.Transaksi;
import com.manajemenantrian.model.Customer;
import com.manajemenantrian.model.LayananCarwash;


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

        try{
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
            String kodePembayaran = scanner.nextLine();
            scanner.nextLine();
            
            for (Transaksi transaksi : DaftarTransaksi) {
                if (transaksi.getKode_transaksi() == kodePembayaran) {
                    System.out.println("Kode transaksi telah digunakan!");
                    return;
                }
            }
    
            System.out.println("\nDaftar Layanan yang Tersedia:");
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
                
                System.out.print("Apakah customer member VIP? (y/n): ");
                String isMember = scanner.nextLine();
                boolean memberVIP = isMember.equalsIgnoreCase("y");
                
                LayananCarwash layanan = new LayananCarwash(jenisLayanan, "");
            
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
    
            System.out.println("Estimasi biaya: Rp " + layanan.hitungBiayaLayanan(jenisLayanan, memberVIP));
        }catch (InputMismatchException e) {
            System.out.println("Error: Format input tidak valid!");
            scanner.nextLine(); 
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        
    }


    public void ubah_status_transaksi() {
        tampilkan_transaksi();

        try{
            System.out.println("Masukkan Kode Transaksi yang ingin diubah: ");
            String kodeUbahTransaksi = scanner.nextLine();
            scanner.nextLine();

            boolean transaksiDitemukan = false;
            for(Transaksi transaksi : DaftarTransaksi){
                if(transaksi.kode_transaksi == kodeUbahTransaksi){
                    System.out.println("Status Transaksi saat ini: " + transaksi.status_transaksi);
                    System.out.println("Status Baru:");
                    System.out.println("1. Pending");
                    System.out.println("2. Proses");
                    System.out.println("3. Selesai");
                    System.out.println("Pilih (1-3): ");

                    int pilihan = scanner.nextInt();
                    scanner.nextLine();

                    String statusBaru;
                    switch(pilihan) {
                        case 1:
                            statusBaru = "Pending";
                            break;
                        case 2:
                            statusBaru = "Proses";
                            break;
                        case 3:
                            statusBaru = "Selesai";
                            break;
                        default:
                            throw new Exception("Pilihan tidak valid!");
                    }

                    transaksi.status_transaksi = statusBaru;
                    transaksiDitemukan = true;
                    System.out.println("Status Transaksi dengan kode " + kodeUbahTransaksi + "berhasil diubah menjadi:" + statusBaru);
                    break;
                }
            }

            if(!transaksiDitemukan){
                throw new Exception("Antrian dengan nomor: " + kodeUbahTransaksi + "tidak ditemukan!");
            }

            
        }catch (InputMismatchException e){
            System.out.println("Error: Format input tidak valid!");
        }catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        
    }  
    
    public void hapus_transaksi() {
        tampilkan_transaksi();
        System.out.println("Masukkan kode transaksi yang ingin dihapus");
        String noHapusTransaksi = scanner.nextLine();
        for (int i = 0; i < DaftarTransaksi.size(); i++) {
            if (DaftarTransaksi.get(i).getKode_transaksi().equals(noHapusTransaksi)) {
                DaftarTransaksi.remove(i);
                System.out.println("Transaksi berhasil dihapus.");
                return;
            }
        }
        System.out.println("Antrian tidak ditemukan.");
    }

}
