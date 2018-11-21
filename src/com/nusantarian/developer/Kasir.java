package com.nusantarian.developer;

import java.util.*;

public class Kasir {
    private static Scanner in = new Scanner(System.in);
    private static String[][] menu = {
            {"Nasi Goreng","15000","Es Teh","3000"},
            {"Mie Goreng","13000","Es Teh Lemon","7000"},
            {"Soto Ayam","17000","Es Degan","5000"},
            {"Rawon Daging","20000","Es Blewah","8000"},
            {"Nasi Pecel","11000","Es Buah","10000"},
    };
    private static String pil;
    private static boolean go = true;

    private static void showmenu(){
        System.out.println("Kasir Rumah Makan");
        System.out.println("-----------------------------");
        do{
            System.out.println("1. Pembelian");
            System.out.println("2. Menampilkan List Makanan dan Minuman");
            System.out.println("3. Tampilkan Data");
            System.out.println("4. Keluar");
            System.out.print("Masukkan Pilihan = ");
            pil = in.next();
            System.out.println("-----------------------------");
            switch (pil){
                case "1": beli();break;
            }
        }while(go);
    }
    private static void beli(){
        do{

        }while (go);
    }
}
