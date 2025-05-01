package com.manajemenantrian.interface_;

public interface Layanan {
    int hitungEstimasiWaktu(String jenisLayanan);

    double hitungBiayaLayanan(String jenisLayanan, boolean memberVIP);
}