package com.nusantarian.developer;


import java.util.*;

public class Kemahasiswaan {
    private static Scanner is = new Scanner(System.in);
    private static ArrayList Nama = new ArrayList();
    private static ArrayList Nim = new ArrayList();
    private static ArrayList Prodi = new ArrayList();
    private static String nama,prodi,pil,tanya,a,nim;
    private static boolean go = true;
    private static void showMenu() {
        System.out.println("Data Mahasiswa");
        System.out.println("-----------------------------");
        do{
            System.out.println("1. Tambah Data Mahasiswa");
            System.out.println("2. Cari Data Mahasiswa");
            System.out.println("3. Lihat Semua Daftar Mahasiswa");
            System.out.println("4. Hapus Data Mahasiswa");
            System.out.println("5. Keluar");
            System.out.println("-----------------------------");
            System.out.print("Masukkan Pilihan = ");
            pil = is.next();
            System.out.println("-----------------------------");
            switch (pil){
                case "1": tambahdata();break;
                case "2": caridata();break;
                case "3": tampildata();break;
                case "4": hapusdata();break;
                case "5": System.out.println("Terimakasih Telah Menggunakan Program Ini");go = false;break;
            }
        }while(go);
    }

    private static void hapusdata() {
        do{
            if(Nama.isEmpty()&&Nim.isEmpty()&&Prodi.isEmpty()){
                System.out.println("Data Kosong");
            }else{
                System.out.print("Masukkan Nama yang Akan Dihapus = ");
                is.nextLine();
                nama = is.nextLine();
                for(int i = 0; i < Nama.size();i++){
                    a = Nama.get(i).toString();
                    if(nama.equalsIgnoreCase(a)){
                        Nama.remove(i);Nim.remove(i);Prodi.remove(i);
                    }else {
                        System.out.print("Masukkan Salah");hapusdata();
                    }
                }
            }
        }while (go);
    }

    private static void caridata() {
        do{
            if(Nama.isEmpty()&&Nim.isEmpty()&&Prodi.isEmpty()){
                System.out.println("Data Kosong");
            }else{
                System.out.print("Masukkan Nama = ");
                is.nextLine();
                nama = is.nextLine();
                System.out.println("-----------------------------");
                for(int i = 0; i < Nama.size();i++){
                    a = Nama.get(i).toString();
                    if(nama.equalsIgnoreCase(a)){
                        System.out.printf("Nama  = %s\nNIM   = %s\nProdi = %s\n",Nama.get(i),Nim.get(i),Prodi.get(i));
                        System.out.println("-----------------------------");
                        System.out.print("Apakah Ingin Mencari Data Lagi <y/n>? ");
                        ulang();
                        System.out.println("-----------------------------");
                    }
                }
            }
        }while (go);
    }

    private static void tambahdata(){
        do{
            System.out.print("Masukkan Nama Mahasiswa = ");
            is.nextLine();
            nama = is.nextLine();
            Nama.add(nama);
            System.out.print("Masukkan Prodi Mahasiswa= ");
            prodi = is.nextLine();
            Prodi.add(prodi);
            System.out.print("Masukkan NIM Mahasiswa  = ");
            nim = is.next();
            Nim.add(nim);
            System.out.print("Apakah Anda Ingin Menginput Data Lagi <y/n>? ");
            ulang();
        }while(go);
    }
    private static void ulang(){
        tanya = is.next();
        if("y".equalsIgnoreCase(tanya)){
            return;
        }
        if("n".equalsIgnoreCase(tanya)){
            showMenu();
        }else{
            System.out.println("Masukkan Salah");ulang();
        }
        System.out.println("-----------------------------");
    }
    private static void tampildata(){
        if(Nama.isEmpty()&&Nim.isEmpty()&&Prodi.isEmpty()){
            System.out.println("Data Kosong");
        }else{
            System.out.println("Daftar Mahasiswa");
            System.out.printf("|%-25s|%-15s|%-25s|\n","Nama","NIM","Prodi");
            for(int i = 0; i<Nama.size();i++){
                System.out.printf("|%-25s|%-15s|%-25s|\n",Nama.get(i),Nim.get(i),Prodi.get(i));
            }
            System.out.println("-----------------------------");
        }
    }
    public static void main(String[] args){
        showMenu();
    }
}
