package com.nusantarian.developer;


import java.util.*;

public class Kemahasiswaan {
    private static Scanner is = new Scanner(System.in);
    private static ArrayList Nama = new ArrayList();
    private static ArrayList Nim = new ArrayList();
    private static ArrayList Prodi = new ArrayList();
    private static String nama,prodi,pil,tanya;
    private static int nim;
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
                case "2":
                case "3": tampildata();break;
                case "5": System.out.println("Terimakasih Telah Menggunakan Program Ini");go = false;break;
            }
        }while(go);
    }
    public static void tambahdata(){
        do{
            System.out.print("Masukkan Nama Mahasiswa = ");
            nama = is.next();
            Nama.add(nama);
            System.out.print("Masukkan Prodi Mahasiswa= ");
            prodi = is.next();
            Prodi.add(prodi);
            System.out.print("Masukkan NIM Mahasiswa  = ");
            nim = is.nextInt();
            Nim.add(nim);
            System.out.print("Apakah Anda Ingin Menginput Data Lagi <y/n>? ");
            ulang();
            System.out.println("-----------------------------");
        }while(go);
    }
    private static void ulang(){
        tanya = is.next();
        if(tanya.charAt(0)=='y'||tanya.charAt(0)=='Y'){
            return;
        }
        if(tanya.charAt(0)=='n'||tanya.charAt(0)=='N'){
            showMenu();
        }else{
            System.out.println("Masukkan Salah");ulang();
        }
    }
    public static void tampildata(){
        if(Nama.isEmpty()){
            System.out.println("Data Kosong");
        }else{
            System.out.println("Daftar Mahasiswa");
            System.out.printf("|%-25s|%-15s|%-25s|\n","Nama","NIM","Prodi");
            for(int i = 0; i<Nama.size();i++){
                System.out.printf("|%-25s|%-15d|%-25s|\n",Nama.get(i),Nim.get(i),Prodi.get(i));
            }
            System.out.println("-----------------------------");
        }
    }
    public static void main(String[] args){
        showMenu();
    }
}
