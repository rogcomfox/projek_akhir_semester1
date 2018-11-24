package com.nusantarian.developer;

import java.util.*;

public class NilaiMahasiswa {
    private static Scanner in = new Scanner(System.in);
    private static ArrayList Nama = new ArrayList();
    private static ArrayList Nim  = new ArrayList();
    private static ArrayList Nilai = new ArrayList();
    private static boolean go = true;
    private static String pil,nama,nim,a,ip,tanya;
    private static int nilai,i;
    private static double ip1;

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
                case "2": editnilai();break;
                case "5": System.out.println("Terimakasih Telah Menggunakan Program Kami");go = false;break;
                default:System.out.println("Masukkan Salah");break;
            }
        }while(go);
    }

    private static void tambahnilai() {
        do{
            System.out.print("Masukkan Nama  = ");
            in.nextLine();
            nama = in.nextLine();
            Nama.add(nama);
            System.out.print("Masukkan NIM   = ");
            nim = in.next();
            Nim.add(nim);
            System.out.print("Masukkan Nilai = ");
            nilai = in.nextByte();
            Nilai.add(nilai);
            System.out.print("Apakah Anda Ingin Memasukkan Nilai Lagi <y/n>? ");
            ulang();
            System.out.println("---------------------------------------");
        }while(go);
    }

    private static void ulang() {
        tanya = in.next();
        if("y".equalsIgnoreCase(tanya)){
            return;
        }
        if("n".equalsIgnoreCase(tanya)){
            showMenu();
        }else {
            System.out.print("Masukkan Salah");ulang();
        }
    }

    private static void lihatnilai() {
        if(Nama.isEmpty()&&Nilai.isEmpty()&&Nim.isEmpty()){
            System.out.println("Data Kosong, Silahkan Isikan Data Terlebih Dahulu");tambahnilai();
        }else{
            for(i = 0; i < Nama.size();i++){
                a = Nama.get(i).toString();
                if(nama.equalsIgnoreCase(a)){
                    konversi();
                    System.out.printf("|%-3s|%-15s|%-25s|%-7s|%-5s|%-11s|\n","No","NIM","Nama Lengkap","Nilai","IP","Huruf Mutu");
                    System.out.printf("|%-3d|%-15s|%-25s|%-7d|%-5.1f|%-11s|\n",i+1,Nim.get(i),Nama.get(i),Nilai.get(i),ip1,ip);
                    System.out.println("---------------------------------------");
                }
            }
        }
    }
    private static void konversi(){
        if(nilai == 100) ip = "A"; ip1 = 4.00;
        if(nilai >= 80) ip = "A"; ip1 = 3.50;
        if(nilai >= 75) ip = "B+"; ip1 = 3.00;
        if(nilai >= 70) ip = "B"; ip1 = 2.50;
        if(nilai >= 65) ip = "C+"; ip1 = 2.00;
        if(nilai >= 60) ip = "C"; ip1 = 1.50;
        if(nilai >= 55) ip = "D+"; ip1 = 1.00;
        if(nilai >= 50) ip = "D"; ip1 = 0.50;
        if(nilai >= 0) ip = "E"; ip1 = 0.00;
    }
    private static void editnilai(){

    }
    private static void carinilai(){
        do{
            if(Nama.isEmpty()&&Nilai.isEmpty()&&Nim.isEmpty()) {
                System.out.println("Data Kosong, Silahkan Isikan Data Terlebih Dahulu");tambahnilai();
            }else{
                System.out.print("Masukkan Nama = ");
                in.nextLine();
                nama = in.nextLine();
                for(i = 0;i < Nama.size();i ++){

                }
            }
        }while (go);
    }
    public static void main(String[]args){
        showMenu();
    }
}
