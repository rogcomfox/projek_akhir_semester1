package com.nusantarian.developer;

import java.util.*;

public class Tiket {
    private static Scanner in = new Scanner(System.in);
    private static boolean jalan = true;
    private static String tanya,pil;
    private static String [][] TiketPesawat = {
            {""},
            {""},
    };
    private static String [][] TiketKereta = {
            {""},
            {""},
    };
    private static ArrayList username = new ArrayList();
    private static ArrayList password = new ArrayList();

    /*private static void showMenu(){
        System.out.println("Program Tiket Transportasi");
        System.out.println("---------------------------------------");
        do{
            System.out.println("1. Cek Tiket Pesanan");
            System.out.println("2. Batalkan Pemesanan");
            System.out.println("3. Pesan Tiket");
            System.out.println("4. Ubah Password");
            System.out.println("5. Keluar");
            System.out.print("Masukkan Pilihan = ");
            pil = in.next();
            switch (pil){
                case "5": System.out.println("Terimakasih Telah Menggunakan Program Kami");jalan = false;break;
                default:System.out.println("Masukkan Salah!");break;
            }
        }while (jalan);
    }*/
    private static void showMenu(){
        do{
            System.out.println("1. Login");
            System.out.println("2. Daftar");
            System.out.println("3. Exit");
            System.out.print("Masukkan Pilihan = ");
            pil = in.next();
            switch (pil){
                case "1": login();break;
                case "2": daftar();break;
                case "3": System.out.println("Terimakasih Telah Menggunakan Program Kami");jalan = false;break;
                default:System.out.println("Masukkan Salah!");break;
            }
        }while (jalan);
    }

    private static void daftar() {

    }

    private static void login() {

    }
}
