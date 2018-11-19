package com.nusantarian.developer;

import java.io.*;
import java.util.*;

public class Kemahasiswaan {
    private static InputStreamReader in = new InputStreamReader(System.in);
    private static BufferedReader input = new BufferedReader(in);
    private static ArrayList Nama = new ArrayList();
    private static ArrayList Nim = new ArrayList();
    private static ArrayList Prodi = new ArrayList();
    private static String nama,prodi,pil;
    private static int nim;
    private static boolean go = true;
    public static void showMenu() throws IOException {
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
            pil = input.readLine();
            System.out.println("-----------------------------");
            switch (pil){
                case "1": tambahdata();break;
                case "2":
                case "3": tampildata();break;
                case "5": System.out.println("Terimakasih Telah Menggunakan Program Ini");break;
            }
        }while(pil != "5");
    }
    public static void tambahdata() throws IOException {
        do{
            System.out.print("Masukkan Nama Mahasiswa = ");
            nama = input.readLine();
            Nama.add(nama);
            System.out.print("Masukkan NIM Mahasiswa  = ");
            nim = input.read();
            Nim.add(nim);
            System.out.print("Masukkan Prodi Mahasiswa= ");
            prodi = input.readLine();
            Prodi.add(prodi);
            System.out.println("-----------------------------");
            System.out.print("Apakah Anda Ingin Menginput Data Lagi <y/n>? ");
            String tanya = input.readLine();
            if(tanya.charAt(0)=='y'||tanya.charAt(0)=='Y'){
                go = true;
            }
            if(tanya.charAt(0)=='n'||tanya.charAt(0)=='N'){
                showMenu();
            }
        }while(go);
    }
    public static void tampildata(){
        if(Nama.isEmpty()){
            System.out.println("Data Kosong");
        }else{
            System.out.println("Daftar Mahasiswa");
            System.out.printf("|%-15s|%-15s|%-15s|\n","Nama","NIM","Prodi");
            for(int i = 0; i<Nama.size();i++){
                System.out.printf("|%-15s|%-15d|%-15s|\n",Nama.get(i),Nim.get(i),Prodi.get(i));
            }
            System.out.println("-----------------------------");
        }
    }
    public static void main(String[] args)throws IOException{
        showMenu();
    }
}
