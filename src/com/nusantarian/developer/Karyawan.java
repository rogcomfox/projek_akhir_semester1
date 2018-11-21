package com.nusantarian.developer;

import java.util.*;

public class Karyawan {
    private static Scanner in = new Scanner(System.in);
    private static ArrayList Nama = new ArrayList();
    private static ArrayList ID = new ArrayList();
    private static ArrayList Email = new ArrayList();
    private static ArrayList Telpon = new ArrayList();
    private static ArrayList Alamat = new ArrayList();
    private static boolean jalan = true;
    private static int telepon;
    private static String pil, email, nama,id,alamat;

    private static void showMenu(){
        System.out.println("Database Karyawan");
        System.out.println("-------------------------------");
        do{
            System.out.println("1. Menambahkan Karyawan Baru");
            System.out.println("2. Menampilkan Semua Karyawan");
            System.out.println("3. Mengedit Data Karyawan");
            System.out.println("4. Menghapus Data Karyawan");
            System.out.println("5. Mencari Data Karyawan");
            System.out.println("6. Keluar");
            System.out.print("Masukkan Pilihan = ");
            pil = in.next();
            switch (pil){
                case "1":tambahdata();break;
                case "6":System.out.println("Terimakasih Telah Menggunakan Program Kami");jalan = false;break;
                default:System.out.println("Masukkan Salah");break;
            }
        }while (jalan);
    }
    private static void tambahdata(){
        System.out.print("Masukkan Nama   = ");
        in.nextLine();
        nama = in.nextLine();
        System.out.print("Masukkan ID     = ");
        id = in.next();
        System.out.print("Masukkan Alamat = ");
        alamat = in.next();
        System.out.print("Masukkan Email  = ");
        email = in.next();
        System.out.print("Masukkan Telpon = ");
        telepon = in.nextInt();
    }
}
