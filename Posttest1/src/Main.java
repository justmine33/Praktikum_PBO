import java.util.Scanner;
import java.util.ArrayList;

class Admin{
    int id_admin;
    String nama;
    String no_telepon;

    public Admin(int id_admin, String nama, String no_telepon){
        this.id_admin = id_admin;
        this.nama = nama;
        this.no_telepon = no_telepon;
    }
}

class Customer{
    int id_cust;
    String nama;
    String no_telepon;

    public Customer(int id_cust, String nama, String no_telepon){
        this.id_cust = id_cust;
        this.nama = nama;
        this.no_telepon = no_telepon;
    }
}

class Staff{
    int id_staff;
    String nama;
    String no_telepon;

    public Staff(int id_staff, String nama, String no_telepon){
        this.id_staff = id_staff;
        this.nama = nama;
        this.no_telepon = no_telepon;
    }
}

class Antrian{
    int no_antrian;
    String status_antrian;
    int waktu_proses;

    public Antrian(int no_antrian, String status_antrian, int waktu_proses){
        this.no_antrian = no_antrian;
        this.status_antrian = status_antrian;
        this.waktu_proses = waktu_proses;
    }
}

class Transaksi{
    int kode_transaksi;
    double harga;
    String status_transaksi;

    public Transaksi(int kode_transaksi, double harga, String status_transaksi){
        this.kode_transaksi = kode_transaksi;
        this.harga = harga;
        this.status_transaksi = status_transaksi;
    }
}

class ManajemenAntrian{
    ArrayList<Antrian> DaftarAntrian = new ArrayList<>();

    public void tampilkan_antrian(){
        if (DaftarAntrian.isEmpty()) {
            System.out.println("Tidak ada antrian.");
            return;
        }
        for(Antrian antrian : DaftarAntrian){
            System.out.println("No Antrian: " + antrian.no_antrian);
            System.out.println("Status Antrian: " + antrian.status_antrian);
            System.out.println("Waktu Proses: " + antrian.waktu_proses + " minit");
            System.out.println("===================================");
        }
    }

    public void tambah_antrian(Antrian antrian){
        DaftarAntrian.add(antrian);
        System.out.println("Antrian berhasil ditambahkeun");
    }

    public void hapus_antrian(int noAntrian) {
        for (int i = 0; i < DaftarAntrian.size(); i++) {
            if (DaftarAntrian.get(i).no_antrian == noAntrian) {
                DaftarAntrian.remove(i);
                System.out.println("Antrian berhasil dihapus.");
                return;
            }
        }
        System.out.println("Antrian tidak ditemukan.");
    }

    public void ubah_status_antrian(int noAntrian, String statusBaru) {
        for (Antrian antrian : DaftarAntrian) {
            if (antrian.no_antrian == noAntrian) {
                antrian.status_antrian = statusBaru;
                System.out.println("Status antrian nomor " + noAntrian + " berhasil diubah menjadi: " + statusBaru);
                return;
            }
        }
        System.out.println("Antrian dengan nomor " + noAntrian + " tidak ditemukan.");
    }
    
}

class ManajemenTransaksi{
    ArrayList<Transaksi> DaftarTransaksi = new ArrayList<>();

    public void tambah_transaksi(Transaksi transaksi){
        DaftarTransaksi.add(transaksi);
        System.out.println("Transaksi berhasil ditambahkeun.");
    }

    public void tampilkan_transaksi(){
        if (DaftarTransaksi.isEmpty()){
            System.out.println("Tidak ada transaksi");
            return;
        }

        for(Transaksi transaksi : DaftarTransaksi){
            System.out.println("Kode Pembayaran: " + transaksi.kode_transaksi);
            System.out.println("Total: " + transaksi.harga);
            System.out.println("Status: " + transaksi.status_transaksi);
        }
    }

    public void ubah_status_transaksi(int kodeTransaksi, String statusBaru) {
        for (Transaksi transaksi : DaftarTransaksi) {
            if (transaksi.kode_transaksi == kodeTransaksi) {
                transaksi.status_transaksi = statusBaru;
                System.out.println("Status transaksi dengan kode " + kodeTransaksi + " berhasil diubah menjadi: " + statusBaru);
                return;
            }
        }
        System.out.println("Transaksi dengan kode " + kodeTransaksi + " tidak ditemukan.");
    }  
    
    public void hapus_transaksi(int noTransaksi) {
        for (int i = 0; i < DaftarTransaksi.size(); i++) {
            if (DaftarTransaksi.get(i).kode_transaksi == noTransaksi) {
                DaftarTransaksi.remove(i);
                System.out.println("Antrian berhasil dihapus.");
                return;
            }
        }
        System.out.println("Antrian tidak ditemukan.");
    }

}

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        ManajemenAntrian manajemenAntri = new ManajemenAntrian();
        ManajemenTransaksi manajemenTransaksi = new ManajemenTransaksi();

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
                    menuAdmin(input, manajemenAntri, manajemenTransaksi);
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

    public static void menuAdmin(Scanner input, ManajemenAntrian manajemenAntrian, ManajemenTransaksi manajemenTransaksi) {
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
            System.out.println("0. Kembali");
            System.out.print("Pilih menu: ");
            pilihan = input.nextInt();
            input.nextLine();

            switch (pilihan) {
                case 1:
                    System.out.print("No. Antrian: ");
                    int noAntrian = input.nextInt();
                    input.nextLine(); 
                    System.out.print("Status Antrian: ");
                    String statusAntrian = input.nextLine();
                    System.out.print("Waktu Proses (menit): ");
                    int waktuProses = input.nextInt();
                    input.nextLine(); 
                    manajemenAntrian.tambah_antrian(new Antrian(noAntrian, statusAntrian, waktuProses));
                    break;
                case 2:
                    manajemenAntrian.tampilkan_antrian();
                    break;
                case 3:
                    manajemenAntrian.tampilkan_antrian();
                    System.out.print("Masukkan No. Antrian yang ingin dihapus: ");
                    int hapusNoAntrian = input.nextInt();
                    manajemenAntrian.hapus_antrian(hapusNoAntrian);
                    break;
                case 4:
                    System.out.print("Kode Transaksi: ");
                    int kodeTransaksi = input.nextInt();
                    input.nextLine(); 
                    System.out.print("Harga: ");
                    double harga = input.nextDouble();
                    input.nextLine(); 
                    System.out.print("Status Transaksi: ");
                    String statusTransaksi = input.nextLine();
                    manajemenTransaksi.tambah_transaksi(new Transaksi(kodeTransaksi, harga, statusTransaksi));
                    break;
                case 5:
                    manajemenTransaksi.tampilkan_transaksi();
                    break;
                case 6:
                    manajemenTransaksi.tampilkan_transaksi();
                    System.out.print("Masukkan Kode Transaksi yang ingin diubah statusnya: ");
                    int kodeUbahTransaksi = input.nextInt();
                    input.nextLine(); 
                    System.out.print("Masukkan Status Baru: ");
                    String statusBaru = input.nextLine();
                    manajemenTransaksi.ubah_status_transaksi(kodeUbahTransaksi, statusBaru);
                    break;
                case 7:
                    manajemenTransaksi.tampilkan_transaksi();
                    System.out.println("Masukkan kode transaksi yang ingin dihapus");
                    int hapusNoTransaksi = input.nextInt();
                    manajemenTransaksi.hapus_transaksi(hapusNoTransaksi);
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
                    manajemenAntri.tampilkan_antrian();
                    System.out.print("Masukkan No. Antrian yang ingin diubah statusnya: ");
                    int noUbahAntrian = input.nextInt();
                    input.nextLine();
                    System.out.print("Masukkan Status Baru: ");
                    String statusBaru = input.nextLine();
                    manajemenAntri.ubah_status_antrian(noUbahAntrian, statusBaru);
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