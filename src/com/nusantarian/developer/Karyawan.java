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
    private static int i;
    private static String pil, tanya, email, nama,id,alamat,telepon,a;

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
            System.out.println("-------------------------------");
            System.out.print("Masukkan Pilihan = ");
            pil = in.next();
            System.out.println("-------------------------------");
            switch (pil){
                case "1":tambahdata();break;
                case "2":tampil();break;
                case "3":editdata();break;
                case "6":System.out.println("Terimakasih Telah Menggunakan Program Kami");jalan = false;break;
                default:System.out.println("Masukkan Salah");break;
            }
        }while (jalan);
    }
    private static void tambahdata(){
        do{
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
            telepon = in.next();
            Nama.add(nama);
            ID.add(id);
            Alamat.add(alamat);
            Email.add(email);
            Telpon.add(telepon);
            System.out.println("-------------------------------");
            System.out.print("Apakah Anda Ingin Menambah Data Lagi <y/n>? ");
            ulang();
            System.out.println("-------------------------------");
        }while(jalan);
    }
    private static void ulang(){
        tanya = in.next();
        if("y".equalsIgnoreCase(tanya)){
            return;
        }
        if ("n".equalsIgnoreCase(tanya)){
            showMenu();
        }else{
            System.out.print("Masukkan Salah");ulang();
        }
    }
    private static void editdata(){
        if(Nama.isEmpty()){
            System.out.println("Data Kosong Silahkan Isikan Data Terlebih Dahulu");tambahdata();
        }else {
            System.out.print("Masukkan Nama Karyawan = ");
            in.nextLine();
            nama = in.nextLine();
            System.out.println("-------------------------------");
            for(i = 0;i < Nama.size();i++){
                a = Nama.get(i).toString();
                if(nama.equalsIgnoreCase(a)){
                    System.out.println("Data Ditemukan!");
                    System.out.println("-------------------------------");
                    System.out.println("1. Nama");
                    System.out.println("2. ID");
                    System.out.println("3. Alamat");
                    System.out.println("4. Email");
                    System.out.println("5. Telpon");
                    System.out.println("Masukkan Pilihan Anda = ");
                    pil = in.next();
                    switch (pil){
                        case "1":
                            System.out.print("Masukkan Nama Baru = ");
                            in.nextLine();
                            nama = in.nextLine();
                            Nama.set(i, nama);break;
                        case "2":
                            System.out.print("Masukkan ID Baru   = ");
                            id = in.next();
                            ID.set(i, id);break;
                    }
                }
            }
        }
    }
    private static void tampil(){

    }
    public static void main(String[] args){
        showMenu();
    }
}
