package com.nusantarian.developer;

import java.util.*;

public class NilaiMahasiswa {
    private static Scanner in = new Scanner(System.in);
    private static ArrayList Nama = new ArrayList();
    private static ArrayList Nim  = new ArrayList();
    private static ArrayList Nilai = new ArrayList();
    private static boolean jalan,go = true;
    private static String pil,nama,tanya;
    private static int nim, nilai;

    private static void showMenu(){
        System.out.println("Program Nilai Mahasiswa");
        System.out.println("---------------------------------------");
        do{
            System.out.println("1. Masukkan Nilai Mahasiswa");
            System.out.println("2. Ubah Nilai Mahasiswa");
            System.out.println("3. Lihat Nilai Mahasiswa");
            System.out.println("4. Cari Nilai Mahasiswa");
            System.out.println("5. Keluar");
            System.out.print("Masukkan Pilihan = ");
            pil = in.next();
            System.out.println("---------------------------------------");
            switch (pil){
                case "1": tambahnilai();break;
                case "3": lihatnilai();break;
            }
        }while(go);
    }

    private static void tambahnilai() {
        do{
            System.out.print("Masukkan Nama  = ");
            nama = in.next();
            Nama.add(nama);
            System.out.print("Masukkan NIM   = ");
            nim = in.nextInt();
            System.out.print("Masukkan Nilai");
            nilai = in.nextByte();
        }while(go);
    }
    private static void lihatnilai() {
        if(Nama.isEmpty()&&Nilai.isEmpty()&&Nim.isEmpty()){
            System.out.println("Data Kosong, Silahkan Isikan Data Terlebih Dahulu");tambahnilai();
        }
    }
    public static void main(String[]args){
        showMenu();
    }
}
