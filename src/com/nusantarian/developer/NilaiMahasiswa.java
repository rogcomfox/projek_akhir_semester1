package com.nusantarian.developer;

import java.util.*;

public class NilaiMahasiswa {
    private static Scanner in = new Scanner(System.in);
    private static String[] Nama = new String [30];
    private static int[][] angka = new int[30][2];
    private static boolean jalan = true;

    private static void showMenu(){
        System.out.println("Program Nilai Mahasiswa");
        System.out.println("---------------------------------------");
        do{
            System.out.println("1. Masukkan Nilai Mahasiswa");
            System.out.println("2. Ubah Nilai Mahasiswa");
            System.out.println("3. Lihat Nilai Mahasiswa");

        }while(jalan);
    }
}
