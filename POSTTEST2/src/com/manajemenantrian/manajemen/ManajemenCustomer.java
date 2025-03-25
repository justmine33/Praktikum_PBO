package com.manajemenantrian.manajemen;
import java.util.ArrayList;
import java.util.Scanner;
import com.manajemenantrian.model.Customer;

public class ManajemenCustomer {
    private ArrayList<Customer> DaftarCustomer = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);

    public ArrayList<Customer> getDaftarCustomer() {
        return DaftarCustomer;
    }


    public void tampilkan_customer() {
        if (DaftarCustomer.isEmpty()) {
            System.out.println("Tidak ada customer yang terdaftar.");
            return;
        }

        for (Customer customer : DaftarCustomer) {
            System.out.println("========Daftar Customer========");
            customer.tampilkanInfo();
        }
    }

    public void tambah_customer() {
        System.out.println("\n======== Tambah Customer ========");
        System.out.print("ID Customer: ");
        int idCust = scanner.nextInt();
        scanner.nextLine();

        for (Customer customer : DaftarCustomer) {
            if (customer.getId_cust() == idCust) {
                System.out.println("ID customer sudah ada! Silakan masukkan ID lain.");
                return;
            }
        }

        System.out.print("Nama: ");
        String nama = scanner.nextLine();
        System.out.print("No. Telepon: ");
        String noTelepon = scanner.nextLine();
        System.out.print("Email: ");
        String email = scanner.nextLine();

        Customer customerBaru = new Customer(idCust, nama, noTelepon);
        customerBaru.setEmail(email);
        DaftarCustomer.add(customerBaru);
        System.out.println("Customer berhasil ditambahkan.");
    }

    public void hapus_customer() {
        if (DaftarCustomer.isEmpty()) {
            System.out.println("Tidak ada customer untuk dihapus.");
            return;
        }

        System.out.println("\n======== Hapus Customer ========");
        System.out.print("Masukkan ID Customer yang ingin dihapus: ");
        int idHapus = scanner.nextInt();

        for (int i = 0; i < DaftarCustomer.size(); i++) {
            if (DaftarCustomer.get(i).getId_cust() == idHapus) {
                DaftarCustomer.remove(i);
                System.out.println("Customer berhasil dihapus.");
                return;
            }
        }
        System.out.println("Customer dengan ID " + idHapus + " tidak ditemukan.");
    }
}