package com.nusantarian.developer;

import java.util.*;

public class Tiket {
    private static Scanner in = new Scanner(System.in);
    private static boolean jalan = true;
    private static String [][] TiketPesawat = {
            {""},
            {""},
    };
    private static String [][] TiketKereta = {
            {""},
            {""},
    };
    private static ArrayList Username = new ArrayList();
    private static ArrayList Password = new ArrayList();
    private static String username,tanya,pil,password;

    private static void showMenu(){
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
    }
    private static void access(){
        do{
            System.out.println("1. Login");
            System.out.println("2. Daftar");
            System.out.println("3. Exit");
            System.out.println("---------------------------------------");
            System.out.print("Masukkan Pilihan = ");
            pil = in.next();
            System.out.println("---------------------------------------");
            switch (pil){
                case "1": login();break;
                case "2": daftar();break;
                case "3": System.out.println("Terimakasih Telah Menggunakan Program Kami");jalan = false;break;
                default:System.out.println("Masukkan Salah!");break;
            }
        }while (jalan);
    }

    private static void daftar() {
        System.out.print("Masukkan Username = ");
        username = in.next();
        Username.add(username);
        System.out.print("Masukkan Password = ");
        password = in.next();
        Password.add(password);
        System.out.println("Data Tersimpan!");
        System.out.println("---------------------------------------");
        access();
    }

    private static void login() {
        if(Username.isEmpty()&&Password.isEmpty()){
            System.out.println("Belum Ada Akun yang Tersimpan, Silahkan Daftar Terlebih Dahulu");daftar();
        }else{
            System.out.print("Masukkan Username = ");
            username = in.next();
            System.out.print("Masukkan Password = ");
            password = in.next();
            for(int i = 0; i < 10; i++){
                if((username == Username.get(i)) && (password == Password.get(i))){
                    showMenu();
                }
            }
            System.out.println("---------------------------------------");
        }
    }
    public static void main(String[] args){
        access();
    }
}